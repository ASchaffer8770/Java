<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Current Visit Count</title>
</head>
<body>
	<h1>Count Page</h1>
	<h3>You have visited <a href="http://localhost:8080/counter"> the counter</a> <c:out value="${count}"/> times.</h3>
	<h3><a href="http://localhost:8080/counter">Another Visit?</a></h3>
</body>
</html>