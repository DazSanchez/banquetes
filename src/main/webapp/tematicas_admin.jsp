<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:main_container mostrarMenu="true">
    <jsp:body>
        <main class="mt-3">
            <div class="container">
                <div class="d-flex justify-content-between">
                    <h2>Temáticas</h2>
                    <a href="${pageContext.request.contextPath}/panel-administrador/tematicas/agregar" class="btn btn-success">Crear temática</a>
                </div>
                <div class="table-responsive">
                    <table class="table table-striped table-hover table-sm">
                        <thead>
                            <tr>
                                <th scope="col">Nombre de banquete</th>
                                <th scope="col">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="tematica" items="${requestScope.tematicas}">
                                <tr>
                                    <td>${tematica.nombre}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/panel-administrador/tematicas/editar?id_tematica=${tematica.id}" class="btn btn-link" title="Editar">
                                            <span class="material-symbols-outlined">
                                                edit
                                            </span>
                                        </a>
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
