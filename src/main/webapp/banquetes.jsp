<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:main_container mostrarMenu="true">
    <jsp:attribute name="estilosExternos">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" />
    </jsp:attribute>
    <jsp:body>
        <main>
            <section class="p-5 mb-4 mensaje-principal text-white" style="--url: url('${banquete.imagenFondo}')">
                <div class="container py-5">
                    <h1 class="display-5 fw-bold">${banquete.mensajePrincipal}</h1>
                    <p class="col-md-8 fs-4">${banquete.mensajePrincipalSubtitulo}</p>
                    <a href="${pageContext.request.contextPath}/contratacion?id_banquete=${banquete.id}" class="btn btn-outline-light btn-lg">Contratar</a>
                </div>
            </section>
            <section class="px-4 py-5 my-5 text-center">
                <span class="material-symbols-outlined text-primary fs-1">
                    ${banquete.icon}
                </span>
                <h1 class="display-5 fw-bold">${banquete.tituloDescripcion}</h1>
                <div class="col-lg-6 mx-auto">
                    <p class="lead mb-4">${banquete.contenidoDescripcion}</p>
                </div>
            </section>
            <section class="container">
                <h2 class="border-bottom">Menus de ${banquete.nombre}</h2>
                <div class="row g-4 py-5 row-cols-1 row-cols-lg-3">
                    <c:forEach var="menu" items="${banquete.menus}">
                        <div class="feature col">
                            <h3 class="fs-2">${menu.nombre}</h3>
                            <ul class="list-group mb-4">
                                <c:forEach var="platillo" items="${menu.platillos}">
                                    <li class="list-group-item">${platillo.nombre}</li>
                                </c:forEach>
                            </ul>
                            <a href="${pageContext.request.contextPath}/contratacion?id_banquete=${banquete.id}&id_menu=${menu.id}" class="btn btn-outline-primary">
                                Elegir este menu
                            </a>
                        </div>
                    </c:forEach>
                </div>
            </section>
        </jsp:body>
    </layout:main_container>
