<%@ tag description="Main website container" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<%@ attribute name="title" required="false" %>
<%@ attribute name="mostrarMenu" required="false" %>
<%@ attribute name="scriptsExternos" fragment="true"%>
<%@ attribute name="estilosExternos" fragment="true"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>
            <c:choose>
                <c:when test="${not empty title}">
                    ${title}
                </c:when>
                <c:otherwise>
                    Banquetes | Bienvenido
                </c:otherwise>
            </c:choose>
        </title>
        
        <link 
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
            crossorigin="anonymous"
        />
        <link 
            rel="stylesheet" 
            href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@40,400,0,0"
        />
        
        <style>
            body {
                min-height: 100vh;
            }
        </style>
        
        <jsp:invoke fragment="estilosExternos" />
    </head>
    <body>
        <c:if test="${mostrarMenu == true}">
            <header>
                <layout:navigation_container />
            </header>
        </c:if>
        
        <jsp:doBody />
        
        <script 
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" 
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" 
            crossorigin="anonymous"
        ></script>
        <script>
            window.contextPath = "${pageContext.request.contextPath}";
        </script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        
        <jsp:invoke fragment="scriptsExternos" />
    </body>
</html>
