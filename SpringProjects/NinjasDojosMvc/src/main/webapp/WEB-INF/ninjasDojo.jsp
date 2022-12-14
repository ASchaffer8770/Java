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
	<h1>Dashboard</h1>
	<a href="/dojo/new" class="btn btn-primary">New Dojo</a>
	<a href="/ninja/new" class="btn btn-warning">New Ninja</a>
	<div class="container">
		<table class=" table table-striped table-hover">
			<thead>
				<tr>
					<th>List of Dojos</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="eachDojo" items="${dojoList }">
				<tr>
					<td> 
						<a href="/dojo/${eachDojo.id}"><c:out value="${eachDojo.dojoname }" /></a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	
</body>
</html>