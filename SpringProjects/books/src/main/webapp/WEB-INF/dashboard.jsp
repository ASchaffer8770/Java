<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	<h1>Dashboard</h1>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Language</th>
				<th># Pages</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="eachBook" items="${bookList }">
				<tr>
					<td> ${eachBook.id} </td>
					<td> 
						<a href="/books/${eachBook.id}">
						<c:out value="${eachBook.title }"/> </a>
					</td>
					<td> <c:out value="${eachBook.language }"/> </td>
					<td> ${eachBook.numberOfPages } </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>