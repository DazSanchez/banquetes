<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:main_container mostrarMenu="true">
    <jsp:attribute name="scriptsExternos">
        <c:if test="${requestScope.tieneExito == true}">
            <script>
                Swal.fire({
                    icon: 'success',
                    titleText: "Banquete actualizado",
                    text: "Se ha modificado el banquete.",
                    timer: 4000,
                    timerProgressBar: true,
                    allowOutsideClick: false,
                    allowEscapeKey: false,
                    allowEnterKey: false,
                    showConfirmButton: false
                }).then(() => {
                    window.location.href = window.contextPath + "/panel-administrador/banquetes";
                });
            </script>
        </c:if>
    </jsp:attribute>
    <jsp:body>
        <div class="d-flex justify-content-center align-items-center min-vh-100 bg-light row">
            <div class="card border-0 shadow-sm col-md-6">
                <div class="card-body">
                    <h5 class="card-title">Crear banquete</h5>
                    <p><a href="${pageContext.request.contextPath}/panel-administrador/banquetes">Volver a listado</a></p>
                    <c:if test="${requestScope.tieneError == true}">
                        <div class="alert alert-danger" role="alert">
                            ${requestScope.mensajeError}
                        </div>
                    </c:if>
                    <form action="${pageContext.request.contextPath}/panel-administrador/banquetes/editar" method="POST" class="mt-3 row">
                        <input hidden="" name="id" value="${banquete.id}" />
                        <div class="col-md-12">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="nombreInput" name="nombre" required="required" value="${banquete.nombre}">
                                <label for="nombreInput">Nombre</label>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="mensajePrincipalInput" name="mensajePrincipal" required="required" value="${banquete.mensajePrincipal}">
                                <label for="mensajePrincipalInput">Mensaje principal</label>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="mensajePrincipalSubtituloInput" name="mensajePrincipalSubtitulo" required="required" value="${banquete.mensajePrincipalSubtitulo}">
                                <label for="mensajePrincipalSubtituloInput">Mensaje principal (Subtitulo)</label>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="tituloDescripcionInput" name="tituloDescripcion" required="required" value="${banquete.tituloDescripcion}">
                                <label for="tituloDescripcionInput">Descripcion (Titulo)</label>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="contenidoDescripcionInput" name="contenidoDescripcion" required="required" value="${banquete.contenidoDescripcion}">
                                <label for="contenidoDescripcionInput">Descripcion (Contenido)</label>
                            </div>
                        </div>

                        <div class="col-md-6 mb-3">
                            <div class="form-floating">
                                <input type="text" class="form-control" id="iconInput" name="icon" required="required" value="${banquete.icon}">
                                <label for="iconInput">Icono</label>
                            </div>
                            <div class="text-secondary form-text">
                                Catálogo: <a class="text-decoration-none text-secondary" href="https://fonts.google.com/icons">https://fonts.google.com/icons</a>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="imagenFondoInput" name="imagenFondo" required="required" value="${banquete.imagenFondo}">
                                <label for="imagenFondoInput">Imagen (URL)</label>
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