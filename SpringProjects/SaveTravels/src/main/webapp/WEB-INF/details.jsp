<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>Details of Expense</h1>
	<table class="table table-striped table-hover">
		<tr>
			<td>Expense name:</td>
			<td><c:out value="${anExpense.expense }" /></td>
		</tr>
		<tr>
			<td>Expense Description:</td>
			<td><c:out value="${anExpense.description }" /></td>
		</tr>
		<tr>
			<td>Vendor:</td>
			<td><c:out value="${anExpense.vendor }" /></td>
		</tr>
		<tr>
			<td>Amount Spent:</td>
			<td><c:out value="${anExpense.amount }" /></td>
		</tr>
	</table>
	<a href="/" class="btn btn-primary">Home</a>
</body>
</html>