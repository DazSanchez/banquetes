<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:main_container mostrarMenu="true">
    <jsp:attribute name="scriptsExternos">
        <c:if test="${requestScope.tieneExito == true}">
            <script>
                Swal.fire({
                    icon: 'success',
                    titleText: "Menú actualizado",
                    text: "Se ha modificado el menú.",
                    timer: 4000,
                    timerProgressBar: true,
                    allowOutsideClick: false,
                    allowEscapeKey: false,
                    allowEnterKey: false,
                    showConfirmButton: false
                }).then(() => {
                    window.location.href = window.contextPath + "/panel-administrador/menus";
                });
            </script>
        </c:if>
    </jsp:attribute>
    <jsp:body>
        <div class="d-flex justify-content-center align-items-center min-vh-100 bg-light row">
            <div class="card border-0 shadow-sm col-md-6">
                <div class="card-body">
                    <h5 class="card-title">Crear menú</h5>
                    <p><a href="${pageContext.request.contextPath}/panel-administrador/menus">Volver a listado</a></p>
                    <c:if test="${requestScope.tieneError == true}">
                        <div class="alert alert-danger" role="alert">
                            ${requestScope.mensajeError}
                        </div>
                    </c:if>
                    <form action="${pageContext.request.contextPath}/panel-administrador/menus/editar" method="POST" class="mt-3 row">
                        <input hidden="" name="id" value="${menu.id}" />
                        <div class="col-md-12">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="nombreInput" name="nombre" required="required">
                                <label for="nombreInput">Nombre</label>
                            </div>
                        </div>

                        <div class="col-md-12">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="entradaInput" name="platillos[0]" required="required">
                                <label for="entradaInput">Entrada</label>
                            </div>
                        </div>

                        <div class="col-md-12">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="platoFuerteInput" name="platillos[1]" required="required">
                                <label for="platoFuerteInput">Plato fuerte</label>
                            </div>
                        </div>
                                
                        <div class="col-md-12">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="postreInput" name="platillos[2]" required="required">
                                <label for="postreInput">Postre</label>
                            </div>
                        </div>


                        <div class="d-flex justify-content-end">
                            <button type="submit" class="btn btn-primary btn-block">Guardar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </jsp:body>
</layout:main_container>