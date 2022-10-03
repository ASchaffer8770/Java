<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji Form</title>
</head>
<body>
	<h1>Send a Omikuji</h1>
	<form method="POST" action="/submitted">
		<div>
			<label>Pick Any Number from 5 to 25:</label> 
			<input type="number" name="number" />
		</div>
		<div>
			<label>Enter The Name of Any City:</label> 
			<input type="text" name="city" />
		</div>
		<div>
			<label>Enter The Name of Any Real Person:</label> 
			<input type="text" name="person" />
		</div>
		<div>
			<label>Enter Professional Endeavor or Hobby:</label> 
			<input type="text" name="profession" />
		</div>
		<div>
			<label>Enter Any Type of Living Thing:</label> 
			<input type="text" name="living" />
		</div>
		<div>
			<label>Say Something Nice to Someone:</label> 
			<textarea name="comments"></textarea>
		</div>
		<div>
			<p>Send and Show a Friend</p>
			<button type="submit">Submit</button>
		</div>
	</form>
</body>
</html>