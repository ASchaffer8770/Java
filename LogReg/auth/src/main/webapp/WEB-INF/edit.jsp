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
<title>Edit ${book.title }</title>
</head>
<body>
	<div class="container mt-5">
		<h1>Edit Entry</h1>
		<a href="/dashboard" class="btn btn-primary">Dashboard</a>
	</div>
	<div class="container mt-5">
		<form:form action="/books/edit/${book.id }" method="POST"
			modelAttribute="book">
			<input type="hidden" name="_method" value="put">
			<p>
				<form:label path="title" class="form-label">Title:</form:label>
				<form:input path="title" class="form-control" />
				<form:errors style="color:red" path="title" />
			</p>
			<p>
				<form:label path="author" class="form-label">Author</form:label>
				<form:input type="text" path="author" class="form-control" />
				<form:errors path="author" style="color:red" />
			</p>
			<p>
				<form:label path="thoughts" class="form-label">My Thoughts:</form:label>
				<form:textarea path="thoughts" rows="5" cols="30"
					class="form-control" />
				<form:errors path="thoughts" style="color:red" />
			</p>
			<form:hidden path="user"/>
			<button type="submit" class="btn btn-primary">Edit</button>
		</form:form>
	</div>
</body>
</html>