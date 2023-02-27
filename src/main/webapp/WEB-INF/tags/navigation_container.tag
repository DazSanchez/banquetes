<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag description="Navegacion principal" pageEncoding="UTF-8" %>

<nav class="navbar navbar-expand-lg bg-body-tertiary sticky-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}">Banquetes App</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
            <div class="offcanvas-header">
                <h5 class="offcanvas-title" id="offcanvasNavbarLabel">Banquetes App</h5>
                <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <div class="offcanvas-body">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Banquetes
                        </a>
                        <ul class="dropdown-menu">
                            <c:forEach var="item" items="${sessionScope.navegacion.banquetes}">
                                <li>
                                    <a class="dropdown-item" href="${pageContext.request.contextPath}/banquetes?id_banquete=${item.id}">${item.nombre}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Tematicas
                        </a>
                        <ul class="dropdown-menu">
                            <c:forEach var="item" items="${sessionScope.navegacion.tematicas}">
                                <li>
                                    <a class="dropdown-item" href="${pageContext.request.contextPath}/tematicas?id_tematica=${item.id}">${item.nombre}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </li>
                    <c:choose>
                        <c:when test="${sessionScope.tipo_usuario == null}">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/autenticacion">Iniciar sesión</a>
                            </li>
                        </c:when>
                        <c:when test="${sessionScope.tipo_usuario != null}">
                            <li class="nav-item">
                                <c:choose>
                                    <c:when test="${sessionScope.tipo_usuario eq 'cliente'}">
                                        <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/panel-cliente">Mi panel</a>
                                    </c:when>
                                    <c:when test="${sessionScope.tipo_usuario eq 'admin'}">
                                        <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/panel-administrador">Mi panel</a>
                                    </c:when>
                                    <c:when test="${sessionScope.tipo_usuario eq 'empleado'}">
                                        <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/panel-empleado">Mi panel</a>
                                    </c:when>
                                </c:choose>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/cerrar-sesion">Cerrar sesion</a>
                            </li>
                        </c:when>
                    </c:choose>
                </ul>
            </div>
        </div>
    </div>
</nav>