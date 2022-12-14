<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Book Details</title>
</head>
<body>
	<div class="container mt-5">
		<h1>${book.title }Details</h1>
		<a href="/dashboard" class="btn btn-primary">Dashboard</a>
	</div>
	<div class="container mt-5">
		<h3>${book.user.userName } read ${book.title } by ${book.author }.</h3>
		<h3>Here are ${book.user.userName }'s thoughts:</h3>
		<p>${book.thoughts }</p>
	</div>

	<div class="container mt-5 d-flex justify-content-around">
		<a href="/books/edit/${book.id}" class="btn btn-warning">Edit</a>

		<form action="/books/delete/${book.id }" method="POST">
			<input type="hidden" name="_method" value="delete" />
			<button class="btn btn-danger" type="submit">Delete</button>
		</form>
	</div>

</body>
</html>