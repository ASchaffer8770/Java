<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Submitted</title>
</head>
<body>
	<h1>Here's Your Omikuji!</h1>
	
	<p> In <c:out value="${number}"></c:out> years, you will live in <c:out value="${city }"></c:out> with 
	<c:out value="${name }"></c:out> as your roommate, selling
	<c:out value="${profession }"></c:out> for a living. The next time you see a <c:out value="${living }"></c:out>, you will have good luck.
	Also, <c:out value="${comments }"></c:out></p>
	
	<a href="/">Home</a>
</body>
</html>