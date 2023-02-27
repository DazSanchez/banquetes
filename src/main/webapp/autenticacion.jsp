<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:main_container mostrarMenu="false">
    <jsp:attribute name="estilosExternos">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/autenticacion.css" />
    </jsp:attribute>
    <jsp:body>
        <div class="d-flex justify-content-center align-items-center min-vh-100 fondo-imagen">
            <div class="card border-0 shadow-sm">
                <div class="card-body">
                    <h5 class="card-title">Ingresar</h5>
                    <p>Ingresa con tu cuenta para contratar tu servicio</p>
                    <c:if test="${requestScope.tieneError == true}">
                        <div class="alert alert-danger" role="alert">
                            ${requestScope.mensajeError}
                        </div>
                    </c:if>
                    <form id="formularioIngresar" action="${pageContext.request.contextPath}/autenticacion?redireccion=${param.redireccion}" method="POST">
                        <div class="mb-3">
                            <label for="correoIngresoInput" class="form-label">Correo electrónico</label>
                            <input name="correo" type="email" required="required" class="form-control" id="correoIngresoInput" aria-describedby="correoIngresoInput">
                        </div>
                        <div class="mb-3">
                            <label for="claveIngresoInput" class="form-label">Contraseña</label>
                            <input name="clave" type="password" required="required" class="form-control" id="claveIngresoInput">
                        </div>
                        <div class="mb-3">
                            <a href="${pageContext.request.contextPath}/registro">No tengo una cuenta</a>
                        </div>
                        <div class="row">
                            <button type="submit" class="btn btn-primary btn-block">Ingresar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </jsp:body>
</layout:main_container>