<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:main_container mostrarMenu="true">
    <jsp:body>
        <main class="mt-3">
            <div class="container">
                <h2>Mis contratos</h2>
                <div class="table-responsive">
                    <table class="table table-striped table-hover table-sm">
                        <thead>
                            <tr>
                                <th scope="col">Banquete</th>
                                <th scope="col">Fecha</th>
                                <th scope="col">Estatus</th>
                                <th scope="col">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="contrato" items="${requestScope.contratos}">
                                <tr>
                                    <td>${contrato.nombreBanquete}</td>
                                    <td>${contrato.fecha}</td>
                                    <td>${contrato.estatus}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/panel-cliente/detalle?id_contrato=${contrato.id}" class="btn btn-link" title="Ver">
                                            <span class="material-symbols-outlined">
                                                visibility
                                            </span>
                                        </a>
                                        <c:if test="${contrato.estatus eq 'Pendiente 3er Pago'}">
                                            <a href="${pageContext.request.contextPath}/panel-cliente/pagar?id_contrato=${contrato.id}" class="btn btn-link" title="Pagar">
                                                <span class="material-symbols-outlined">
                                                    monetization_on
                                                </span>
                                            </a>
                                        </c:if>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </main>
    </jsp:body>
</layout:main_container>
