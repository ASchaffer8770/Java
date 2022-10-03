<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fruity Loops</title>
</head>
<body>
	<h1>Fruity Loops</h1>
	<table class="table">
		<tbody>
			<tr>
				<th>Name</th>
				<th>Price</th>
			</tr>
			<c:forEach var="eachFruit" items="${fruits}">
				<tr>
					<td>${eachFruit.name}</td>
					<td>${eachFruit.getPrice()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>