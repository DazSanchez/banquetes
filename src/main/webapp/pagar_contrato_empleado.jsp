<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:main_container mostrarMenu="true">
    <jsp:attribute name="scriptsExternos">
        <c:if test="${requestScope.tieneExito == true}">
            <script>
                Swal.fire({
                    icon: 'success',
                    titleText: "Pago registrado",
                    text: "El pago ha sido registrado. En breve regresará a su panel de empleado.",
                    timer: 4000,
                    timerProgressBar: true,
                    allowOutsideClick: false,
                    allowEscapeKey: false,
                    allowEnterKey: false,
                    showConfirmButton: false
                }).then(() => {
                    window.location.href = window.contextPath + "/panel-empleado";
                });
            </script>
        </c:if>
    </jsp:attribute>
    <jsp:body>
        <main class="mt-3">
            <div class="container">
                <h2>Pago de contrato</h2>
                <p><a href="${pageContext.request.contextPath}/panel-empleado">Volver a mis contratos</a></p>
                <form class="row" method="POST" action="${pageContext.request.contextPath}/panel-empleado/pagar">
                    <input hidden="" name="idContrato" value="${param.id_contrato}" />
                    <ul class="list-group list-group mb-3">
                        <li class="list-group-item d-flex justify-content-between align-items-start">
                            <div class="ms-2 me-auto">
                                <div class="fw-bold">Tercer pago</div>
                                Confirmar que se ha cobrado al finalizar el evento.
                            </div>
                            <span class="badge bg-primary rounded-pill">$${desglosePago.tercerPago}</span>
                        </li>
                    </ul>

                    <div class="row">
                        <div class="col-md-6">
                            <p>Total a pagar:</p>
                        </div>
                        <div class="col-md-6">
                            <p class="h5 text-end">$${desglosePago.tercerPago}</p>
                        </div>
                    </div>


                    <div class="d-flex justify-content-end">
                        <button type="submit" class="btn btn-primary btn-block">Confirmar pago</button>
                    </div>
                </form>
            </div>
        </main>
    </jsp:body>
</layout:main_container>
