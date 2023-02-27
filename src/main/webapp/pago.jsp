<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:main_container mostrarMenu="false">
    <jsp:attribute name="scriptsExternos">
        <c:if test="${requestScope.tieneExito == true}">
            <script>
                Swal.fire({
                    icon: 'success',
                    titleText: "Pago exitoso",
                    text: "Su anticipo ha sido registrado, en breve será dirigido a su cuenta para revisar su reservación.",
                    timer: 4000,
                    timerProgressBar: true,
                    allowOutsideClick: false,
                    allowEscapeKey: false,
                    allowEnterKey: false,
                    showConfirmButton: false
                }).then(() => {
                    window.location.href = window.contextPath + "/panel-cliente";
                });
            </script>
        </c:if>
    </jsp:attribute>
    <jsp:body>
        <div class="d-flex justify-content-center align-items-center min-vh-100 bg-light row">
            <div class="card border-0 shadow-sm col-md-4">
                <div class="card-body">
                    <h5 class="card-title">Desglose de pago</h5>
                    <c:if test="${requestScope.tieneError == true}">
                        <div class="alert alert-danger" role="alert">
                            ${requestScope.mensajeError}
                        </div>
                    </c:if>
                    <form action="${pageContext.request.contextPath}/pago" method="POST" class="mt-3">
                        <ul class="list-group list-group mb-3">
                            <li class="list-group-item d-flex justify-content-between align-items-start">
                                <div class="ms-2 me-auto">
                                    <div class="fw-bold">Primer pago</div>
                                    Se cobrará inmediatamente.
                                </div>
                                <span class="badge bg-primary rounded-pill">$${desglosePago.primerPago}</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-start">
                                <div class="ms-2 me-auto">
                                    <div class="fw-bold">Segundo pago</div>
                                    Deberá pagarlo el día ${desglosePago.fechaSegundoPago}
                                </div>
                                <span class="badge bg-primary rounded-pill">$${desglosePago.segundoPago}</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-start">
                                <div class="ms-2 me-auto">
                                    <div class="fw-bold">Tercer pago</div>
                                    Deberá pagarlo el día ${desglosePago.fechaTercerPago} al finalizar el evento.
                                </div>
                                <span class="badge bg-primary rounded-pill">$${desglosePago.tercerPago}</span>
                            </li>
                        </ul>

                        <div class="row">
                            <div class="col-md-6">
                                <p>Total a pagar:</p>
                            </div>
                            <div class="col-md-6">
                                <p class="h5 text-end">$${desglosePago.total}</p>
                            </div>
                        </div>

                        <input hidden="" value="${param.id_operacion}" name="idOperacion" />
                        <div class="row">
                            <button type="submit" class="btn btn-primary btn-block">Pagar con Paypal</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </jsp:body>
</layout:main_container>