<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:main_container mostrarMenu="true">
    <jsp:attribute name="estilosExternos">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" />
    </jsp:attribute>
    <jsp:body>
        <main>
            <div class="p-5 mb-4 mensaje-principal text-white">
                <div class="container py-5">
                    <h1 class="display-5 fw-bold">Una fecha especial</h1>
                    <p class="col-md-8 fs-4">Merece un banquete especial.</p>
                    <a href="${pageContext.request.contextPath}/contratacion" class="btn btn-outline-light btn-lg">Contratar</a>
                </div>
            </div>
            <div class="container">
                <h2 class="pb-2 border-bottom">Nuestros banquetes</h2>
                <div class="row g-4 py-5 row-cols-1 row-cols-lg-3">
                    <c:forEach var="banquete" items="${requestScope.banquetes}">
                        <div class="feature col">
                            <img src="${banquete.imgUrl}" class="img-fluid" />
                            <h3 class="fs-2">${banquete.nombre}</h3>
                            <p>${banquete.descripcion}</p>
                            <a href="${pageContext.request.contextPath}/banquetes?id_banquete=${banquete.id}" class="icon-link d-inline-flex text-decoration-none">
                                Ver más
                                <span class="material-symbols-outlined">
                                    chevron_right
                                </span>
                            </a>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="container">
                <h2 class="pb-2 border-bottom">Nuestras temáticas</h2>
                <div class="row g-4 py-5 row-cols-1 row-cols-lg-3">
                    <c:forEach var="tematica" items="${requestScope.tematicas}">
                        <div class="feature col">
                            <img src="${tematica.imgUrl}" class="img-fluid" />
                            <h3 class="fs-2">${tematica.nombre}</h3>
                            <p>${tematica.descripcion}</p>
                            <a href="${pageContext.request.contextPath}/tematicas?id_tematica=${tematica.id}" class="icon-link d-inline-flex text-decoration-none">
                                Ver más
                                <span class="material-symbols-outlined">
                                    chevron_right
                                </span>
                            </a>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </main>
    </jsp:body>
</layout:main_container>
