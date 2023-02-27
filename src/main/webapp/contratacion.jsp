<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:main_container mostrarMenu="true">
    <jsp:attribute name="estilosExternos">
        <style>
            .contenedor {
                min-height: calc(100vh - 56px);
            }
            .contenedor::before {
                content: "";
                position: absolute;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                z-index: -1;
                filter: blur(5px);
                background:
                    linear-gradient(to right, rgba(0,0,0,.25), rgba(0,0,0,.25)),
                    url("https://conexionmigrante.com/wp-content/uploads/2022/11/10-restaurantes-para-celebrar-el-Di%CC%81a-de-Accio%CC%81n-de-Gracias-en-San-Diego.jpg") no-repeat center center / cover;
            }
        </style>
    </jsp:attribute>
    <jsp:body>
        <main class="row justify-content-center align-items-center contenedor g-0">
            <div class="col-md-6">
                <div class="card d-flex flex-column my-5">
                    <div class="card-body">
                        <h2 class="pb-2 ">Contrate un banquete a su medida</h2>
                        <form class="row" method="POST" action="${pageContext.request.contextPath}/contratacion">
                            <div class="col-md-12 mb-3">
                                <div class="form-floating">
                                    <select class="form-select" id="tipoBanqueteInput" name="idBanquete" required="required">
                                        <c:forEach var="banquete" items="${banquetes}">
                                            <option value="${banquete.id}" ${param.id_banquete eq banquete.id.toString() ? 'selected' : ''}>${banquete.nombre}</option>
                                        </c:forEach>
                                    </select>
                                    <label for="tipoBanqueteInput">Tipo de banquete</label>
                                </div>
                            </div>

                            <div class="col-md-6 mb-3">
                                <div class="form-floating">
                                    <select class="form-select" id="tematicaInput" name="idTematica" required="required">
                                        <c:forEach var="tematica" items="${tematicas}">
                                            <option value="${tematica.id}" ${param.id_tematica eq tematica.id.toString() ? 'selected' : ''}>${tematica.nombre}</option>
                                        </c:forEach>
                                    </select>
                                    <label for="tematicaInput">Tematica</label>
                                </div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <div class="form-floating">
                                    <select class="form-select" id="colorInput" name="idColor" required="required">
                                        <c:forEach var="color" items="${colores}">
                                            <option value="${color.id}" ${param.id_color eq color.id.toString() ? 'selected' : ''}>${color.nombre}</option>
                                        </c:forEach>
                                    </select>
                                    <label for="colorInput">Color</label>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="form-floating mb-3">
                                    <input type="date" class="form-control" id="fechaInput" name="fecha" required="required">
                                    <label for="fechaInput">Fecha</label>
                                </div>
                            </div>
                            
                            <div class="col-md-6">
                                <div class="form-floating mb-3">
                                    <input type="number" class="form-control" id="asistentes" name="asistentes" required="required">
                                    <label for="fechaInput">Asistentes</label>
                                </div>
                            </div>


                            <h2 class="h4 mb-3">Dirección del evento</h2>

                            <div class="col-md-12">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="calleInput" name="calle" required="required">
                                    <label for="calleInput">Calle</label>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="coloniaInput" name="colonia" required="required">
                                    <label for="coloniaInput">Colonia</label>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="ciudadInput" name="ciudad" required="required">
                                    <label for="ciudadInput">Ciudad</label>
                                </div>
                            </div>

                            <div class="col-md-12">
                                <div class="alert alert-primary" role="alert">
                                    El pago se divide en 3 partes:
                                    <ul>
                                        <li>Un pago del <strong>30%</strong> al realizar la contratación.</li>
                                        <li>Un pago del <strong>30%</strong> dos días antes de la fecha del evento.</li>
                                        <li>Un pago del <strong>40%</strong> se paga al finalizar el banquete en el lugar.</li>
                                    </ul>
                                </div>
                            </div>

                            <div class="col-md-12">
                                <div class="alert alert-warning" role="alert">
                                    Es posible realizar <strong>modificaciones</strong> al contrato una vez realizada la contratación aun que esto genera un  <strong>cargo extra del 10%</strong> sobre el nuevo monto del banquete.
                                </div>
                            </div>

                            <div class="col-md-12">
                                <div class="alert alert-danger" role="alert">
                                    Puede realizar la <strong>cancelación</strong> de su reservación hasta <strong>2 semanas antes</strong> de la fecha del evento, en este caso se le realizará una <strong> devolución del 50%</strong> de su primer pago. 
                                    Pasado este tiempo, no se puede realizar una devolución.
                                </div>
                            </div>


                            <div class="col-md-12 d-grid">
                                <button class="btn btn-primary d-block">Reservar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </main>
    </jsp:body>
</layout:main_container>
