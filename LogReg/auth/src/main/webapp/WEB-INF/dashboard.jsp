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
<title>Dashboard</title>
</head>
<body>
	<div class="container mt-5">
		<h1>Welcome, ${userName }</h1>
	</div>
	<div class="container mt-5">
		<h4>Books from everyone's shelves.</h4>
	</div>
	<div class="container mt-5 d-flex justify-content-evenly">
		<a href="/books/new">+ Add a book to my Shelf!</a> <a href="/logout"
			class="btn btn-danger">LogOut</a>
	</div>
	<div class="container mt-5">
		<table class="table table-secondary table-hover">
		<thead>
			<tr>
				<th> ID </th>
				<th> Title</th>
				<th> Author Name </th>
				<th> Posted By </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="eachBook" items="${bookList }">
				<tr>
					<td>${eachBook.id } </td>
					<td> 
					<a href="/books/${eachBook.id }">
					<c:out value="${eachBook.title }"/></a>
					</td>
					<td> ${eachBook.author }</td>
					<td> <c:out value="${eachBook.user.userName }" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>   
	</div>
</body>
</html>