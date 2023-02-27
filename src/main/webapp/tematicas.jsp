<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:main_container mostrarMenu="true">
    <jsp:attribute name="estilosExternos">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" />
    </jsp:attribute>
    <jsp:body>
        <main>
            <section class="p-5 mb-4 mensaje-principal text-white" style="--url: url('${tematica.imagenFondo}')">
                <div class="container py-5">
                    <h1 class="display-5 fw-bold">${tematica.mensajePrincipal}</h1>
                    <p class="col-md-8 fs-4">${tematica.mensajePrincipalSubtitulo}</p>
                    <a href="${pageContext.request.contextPath}/contratacion?id_tematica=${tematica.id}" class="btn btn-outline-light btn-lg">Contratar</a>
                </div>
            </section>
            <section class="px-4 py-5 my-5 text-center">
                <span class="material-symbols-outlined text-primary fs-1">
                    ${tematica.icon}
                </span>
                <h1 class="display-5 fw-bold">${tematica.tituloDescripcion}</h1>
                <div class="col-lg-6 mx-auto">
                    <p class="lead mb-4">${tematica.contenidoDescripcion}</p>
                </div>
            </section>
            <section class="container">
                <h2 class="border-bottom">Colores</h2>
                <p>Elige el color que más se adecue a ti.</p>
                <div class="row g-4 py-5 row-cols-1 row-cols-lg-3">
                    <c:forEach var="color" items="${tematica.colores}">
                        <div class="feature col">
                            <img src="${color.imgUrl}" class="img-fluid" />
                            <h3 class="fs-2">${color.nombre}</h3>
                            <a href="${pageContext.request.contextPath}/contratacion?id_tematica=${tematica.id}&id_color=${color.id}" class="btn btn-outline-primary">
                                Elegir este color
                            </a>
                        </div>
                    </c:forEach>
                </div>
            </section>
            <section class="container">
                <h2 class="border-bottom">Adornos</h2>
                <p>Esta temática incluye estos adornos.</p>
                <div class="row g-4 py-5 row-cols-1 row-cols-lg-3">
                    <c:forEach var="adorno" items="${tematica.adornos}">
                        <div class="feature col">
                            <img src="${adorno.imgUrl}" class="img-fluid" />
                            <h3 class="fs-2">${adorno.nombre}</h3>
                        </div>
                    </c:forEach>
                </div>
            </section>
        </jsp:body>
    </layout:main_container>
