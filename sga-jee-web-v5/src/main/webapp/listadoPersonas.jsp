<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ListadoPersonas</title>
    </head>
    <body>
        <h1>ListadoPersonas</h1>
        <ul>
            <c:forEach items="${personas}" var="persona">
                <li>${persona.idPersona} ${persona.nombre} ${persona.apellido} ${persona.email}</li>
            </c:forEach>
        </ul>
        <br/>
        <a href="index.html">Regresar al Inicio</a>
    </body>
</html>
