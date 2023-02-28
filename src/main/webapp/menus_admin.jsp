<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:main_container mostrarMenu="true">
    <jsp:body>
        <main class="mt-3">
            <div class="container">
                <div class="d-flex justify-content-between">
                    <h2>Menus</h2>
                    <a href="${pageContext.request.contextPath}/panel-administrador/menus/agregar" class="btn btn-success">Crear menú</a>
                </div>
                <div class="table-responsive">
                    <table class="table table-striped table-hover table-sm">
                        <thead>
                            <tr>
                                <th scope="col">Nombre de menú</th>
                                <th scope="col">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="menu" items="${requestScope.menus}">
                                <tr>
                                    <td>${menu.nombre}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/panel-administrador/menus/editar?id_menu=${menu.id}" class="btn btn-link" title="Editar">
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
