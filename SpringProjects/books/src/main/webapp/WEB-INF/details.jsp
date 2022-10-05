<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Details</title>
</head>
<body>
	<h1>Details</h1>
	<h2> <c:out value="${book.title }"></c:out> </h2>
	<h4>Description: <c:out value="${book.description }"></c:out> </h4>
	<h4>Language: <c:out value="${book.language }"></c:out> </h4>
	<h4>Number of Pages: <c:out value="${book.numberOfPages }"></c:out> </h4>
	<a href="/books">Home</a>
</body>
</html>