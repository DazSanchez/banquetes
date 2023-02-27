<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:main_container mostrarMenu="false">
    <jsp:attribute name="estilosExternos">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/autenticacion.css" />
    </jsp:attribute>
    <jsp:attribute name="scriptsExternos">
        <c:if test="${requestScope.tieneExito == true}">
            <script>
                Swal.fire({
                    icon: 'success',
                    titleText: "Registro exitoso",
                    text: "Su cuenta ha sido registrada, le redirigiremos para ingresar con su nueva cuenta.",
                    timer: 3000,
                    timerProgressBar: true,
                    allowOutsideClick: false,
                    allowEscapeKey: false,
                    allowEnterKey: false,
                    showConfirmButton: false
                }).then(() => {
                    window.location.href = window.contextPath + "/autenticacion";
                });
            </script>
        </c:if>
    </jsp:attribute>
    <jsp:body>
        <div class="d-flex justify-content-center align-items-center min-vh-100 fondo-imagen py-5">
            <div class="card border-0 shadow-sm">
                <div class="card-body">
                    <a href="${pageContext.request.contextPath}" class="d-block h5 card-title text-decoration-none">Banquetes App</a>
                    <p>Crea una cuenta para contratar tu servicio</p>
                    <form id="formularioRegistro" action="${pageContext.request.contextPath}/registro" method="POST">
                        <div class="row">
                            <div class="mb-3 col-md-6">
                                <label for="nombreInput" class="form-label">Nombre</label>
                                <input name="nombre" type="text" required="required" class="form-control" id="nombreInput" aria-describedby="nombreInput">
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="apellidosInput" class="form-label">Apellidos</label>
                                <input name="apellidos" type="text" required="required" class="form-control" id="apellidosInput" aria-describedby="apellidosInput">
                            </div>
                        </div>
                        <div class="row">
                            <div class="mb-3 col-md-6">
                                <label for="telefonoInput" class="form-label">Teléfono</label>
                                <input name="telefono" type="tel" required="required" class="form-control" id="telefonoInput" aria-describedby="telefonoInput">
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="calleInput" class="form-label">Calle</label>
                                <input name="calle" type="text" required="required" class="form-control" id="calleInput" aria-describedby="calleInput">
                            </div>
                        </div>
                        <div class="row">
                            <div class="mb-3 col-md-6">
                                <label for="coloniaInput" class="form-label">Colonia</label>
                                <input name="colonia" type="text" required="required" class="form-control" id="coloniaInput" aria-describedby="coloniaInput">
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="codigoPostalInput" class="form-label">Código Postal</label>
                                <input name="codigoPostal" type="text" required="required" pattern="[0-9]{5}" class="form-control" id="codigoPostalInput" aria-describedby="codigoPostalInput">
                            </div>
                        </div>
                        <div class="row">
                            <div class="mb-3 col-md-6">
                                <label for="ciudadInput" class="form-label">Ciudad</label>
                                <input name="ciudad" type="text" required="required" class="form-control" id="ciudadInput" aria-describedby="ciudadInput">
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="correoInput" class="form-label">Correo electrónico</label>
                                <input name="correo" type="email" required="required" class="form-control" id="correoInput" aria-describedby="correoInput">
                            </div>
                        </div>
                        <div class="row">
                            <div class="mb-3 col-md-6">
                                <label for="claveInput" class="form-label">Contraseña</label>
                                <input name="clave" type="password" required="required" class="form-control" id="claveInput" aria-describedby="claveInput">
                            </div>
                        </div>
                        <div class="mb-3">
                            <a href="${pageContext.request.contextPath}/autenticacion">Ya tengo una cuenta</a>
                        </div>
                        <div class="row">
                            <button type="submit" class="btn btn-primary">Registrarme</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </jsp:body>
</layout:main_container>