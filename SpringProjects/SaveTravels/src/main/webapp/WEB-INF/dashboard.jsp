<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expense Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1 class="d-flex justify-content-center">Save Travels</h1>
	<div class="d-flex justify-content-center container">
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Expense</th>
					<th>Vendor</th>
					<th>Amount</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="eachExpense" items="${expenseList }">
					<tr>
						<td><c:out value="${eachExpense.expense }" /></td>
						<td><c:out value="${eachExpense.vendor }" /></td>
						<td>$ ${eachExpense.amount }</td>
						<td>Edit | Delete</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<h1 class="d-flex justify-content-center">Add an Expense:</h1>
	<div class="d-flex justify-content-center container">
		<form:form method="POST" action="/expenses/new"
			modelAttribute="newExpense">
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
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>
</html>