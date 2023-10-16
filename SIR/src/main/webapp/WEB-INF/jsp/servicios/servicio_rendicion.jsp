<%@ page session="false"%>
<%@ page contentType="text/html;charset=ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:out value="${mapa.json_respuesta}" escapeXml ="false" />