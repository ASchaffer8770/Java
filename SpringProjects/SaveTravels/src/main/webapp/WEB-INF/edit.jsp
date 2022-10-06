<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Expense</title>
</head>
<body>
	<h1>Edit Expense</h1>
	<a href="/">Home</a>
	<div class="d-flex justify-content-center container">
		<form:form method="POST" action="/expenses/edit/${anExpense.id}" modelAttribute="anExpense">
			<input type="hidden" name="_method" value="put">
			<p>
				<form:label path="expense">Expense Name:</form:label>
				<form:input path="expense" />
				<form:errors class="text-danger" path="expense" />
			</p>
			<p>
				<form:label path="vendor">Vendor:</form:label>
				<form:input path="vendor" />
				<form:errors class="text-danger" path="vendor" />
			</p>
			<p>
				<form:label path="amount">Amount:</form:label>
				<form:input path="amount" />
				<form:errors class="text-danger" path="amount" />
			</p>
			<p>
				<form:label path="description">Description:</form:label>
				<form:input path="description" />
				<form:errors class="text-danger" path="description" />
			</p>
			<button type="submit" class="btn btn-primary">Edit</button>
		</form:form>
	</div>
</body>
</html>