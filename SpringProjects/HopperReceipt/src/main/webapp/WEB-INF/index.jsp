<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hopper Receipt</title>
</head>
<body>
	<h1>Receipt</h1>
	<h2>Customer Name: ${jspName}</h2>
	<h3>Item: ${itemName} </h3>
	<h3>Price: ${price}</h3>
	<h3>Description: ${description }</h3>
	<h3>Vendor: ${vendor}</h3>
</body>
</html>