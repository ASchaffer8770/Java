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
<title>New Dojo</title>
</head>
<body>
	<div class="container justify-content=center">
	<h1>Create a New Dojo</h1>
	<form:form action="/dojo/process" method="POST" modelAttribute="newDojo">
		<p>
			<form:label path="dojoname">Location:</form:label>
			<form:input path="dojoname" />
			<form:errors class="text-danger" path="dojoname" />
		</p>
		<button class="btn btn-primary" type="submit">Submit</button>
	</form:form>
	<a href="/ninja/new" class="btn btn-success">New Ninja</a>
	<a href="/" class="btn btn-danger">Home</a>
	</div>
</body>
</html>