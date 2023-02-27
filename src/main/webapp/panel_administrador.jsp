<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:main_container mostrarMenu="true">
    <jsp:body>
        <main class="mt-3">
            <div class="container">
                <h2 class="border-bottom pb-2">Panel de administrador</h2>
                <div class="row g-4 py-3 row-cols-1 row-cols-lg-3">
                    <div class="col d-flex align-items-start">
                        <div class="card">
                            <div class="card-body">
                                <h3 class="fs-2">Banquetes</h3>
                                <p>Visualize, crea o edite sus banquetes.</p>
                                <a href="${pageContext.request.contextPath}/panel-administrador/banquetes" class="btn btn-primary">
                                    Ver panel
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col d-flex align-items-start">
                        <div class="card">
                            <div class="card-body">
                                <h3 class="fs-2">Tematicas</h3>
                                <p>Visualize, crea o edite sus temáticas.</p>
                                <a href="${pageContext.request.contextPath}/panel-administrador/tematicas" class="btn btn-primary">
                                    Ver panel
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col d-flex align-items-start">
                        <div class="card">
                            <div class="card-body">
                                <h3 class="fs-2">Menus</h3>
                                <p>Visualize, crea o edite sus menús.</p>
                                <a href="${pageContext.request.contextPath}/panel-administrador/menus" class="btn btn-primary">
                                    Ver panel
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </jsp:body>
</layout:main_container>
