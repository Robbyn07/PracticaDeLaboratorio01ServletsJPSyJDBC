<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Perfil User</title>
</head>
<body>
	<c:set var="usuN" scope="request" value="${usuario}" />
	
	<h1>Persona encontrada</h1>		
		
	<p>Id: ${usuN.id}</p>
	<p>Nombre: ${usuN.nombre}</p>
	<p>Apellid: ${usuN.apellido}</p>
</body>
</html>