<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:main_container mostrarMenu="true">
    <jsp:body>
        <main class="mt-3">
            <div class="container">
                <h2>Detalle de contrato</h2>
                <p><a href="${pageContext.request.contextPath}/panel-cliente">Volver a mis contratos</a></p>
                <form class="row" method="POST" action="${pageContext.request.contextPath}/contratacion">
                    <div class="col-md-12 mb-3">
                        <div class="form-floating">
                            <select class="form-select" id="tipoBanqueteInput" name="idBanquete" required="required">
                                <c:forEach var="banquete" items="${banquetes}">
                                    <option value="${banquete.id}" ${contrato.idBanquete eq banquete.id.toString() ? 'selected' : ''}>${banquete.nombre}</option>
                                </c:forEach>
                            </select>
                            <label for="tipoBanqueteInput">Tipo de banquete</label>
                        </div>
                    </div>

                    <div class="col-md-6 mb-3">
                        <div class="form-floating">
                            <select class="form-select" id="tematicaInput" name="idTematica" required="required">
                                <c:forEach var="tematica" items="${tematicas}">
                                    <option value="${tematica.id}" ${contrato.idTematica eq tematica.id.toString() ? 'selected' : ''}>${tematica.nombre}</option>
                                </c:forEach>
                            </select>
                            <label for="tematicaInput">Tematica</label>
                        </div>
                    </div>
                    <div class="col-md-6 mb-3">
                        <div class="form-floating">
                            <select class="form-select" id="colorInput" name="idColor" required="required">
                                <c:forEach var="color" items="${colores}">
                                    <option value="${color.id}" ${contrato.idColor eq color.id.toString() ? 'selected' : ''}>${color.nombre}</option>
                                </c:forEach>
                            </select>
                            <label for="colorInput">Color</label>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-floating mb-3">
                            <input type="date" class="form-control" id="fechaInput" name="fecha" required="required" value="${contrato.fecha}">
                            <label for="fechaInput">Fecha</label>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-floating mb-3">
                            <input type="number" class="form-control" id="asistentes" name="asistentes" required="required" value="${contrato.asistentes}">
                            <label for="fechaInput">Asistentes</label>
                        </div>
                    </div>


                    <h2 class="h4 mb-3">Dirección del evento</h2>

                    <div class="col-md-12">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="calleInput" name="calle" required="required" value="${contrato.calle}">
                            <label for="calleInput">Calle</label>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="coloniaInput" name="colonia" required="required" value="${contrato.colonia}">
                            <label for="coloniaInput">Colonia</label>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="ciudadInput" name="ciudad" required="required" value="${contrato.ciudad}">
                            <label for="ciudadInput">Ciudad</label>
                        </div>
                    </div>

                    <div class="col-md-12">
                        <div class="alert alert-warning" role="alert">
                            Cualquier cambio genera un  <strong>cargo extra del 10%</strong> sobre el nuevo monto del banquete.
                        </div>
                    </div>


                    <div class="col-md-12 d-grid">
                        <button class="btn btn-primary d-block">Guardar cambios</button>
                    </div>
                </form>
            </div>
        </main>
    </jsp:body>
</layout:main_container>
