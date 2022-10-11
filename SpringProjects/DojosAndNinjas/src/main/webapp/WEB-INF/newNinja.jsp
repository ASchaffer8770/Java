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
<title>New Ninja</title>
</head>
<body>
	<div class="container justify-content-center">
		<h1>New Ninja</h1>
		<form:form action="/ninja/process" method="POST"
			modelAttribute="newNinja">
			<form:label class="form-label" path="dojo">Dojo Location:</form:label>
			<form:select path="dojo">
				<c:forEach var="eachDojo" items="${dojoList }">
					<form:option value="${eachDojo.id }"> ${eachDojo.dojoname} </form:option>
				</c:forEach>
			</form:select>
			<form:errors class="text-danger" path="dojo" />
			<p>
				<form:label class="form-label" path="firstname">First Name:</form:label>
				<form:input class="form-input" path="firstname" />
				<form:errors class="text-danger" path="firstname" />
			</p>
			<p>
				<form:label class="form-label" path="lastname">Last Name:</form:label>
				<form:input class="form-input" path="lastname" />
				<form:errors class="text-danger" path="lastname" />
			</p>
			<p>
				<form:label class="form-label" path="age">Age:</form:label>
				<form:input class="form-input" path="age" />
				<form:errors class="text-danger" path="age" />
			</p>
			<button class="btn btn-success" type="submit">Create</button>
		</form:form>
	</div>
	<a href="/" class="btn btn-primary">New Dojo</a>
</body>
</html>