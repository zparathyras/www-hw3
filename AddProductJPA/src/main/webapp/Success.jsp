<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="demo.Product" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Success</title>
	<link rel="stylesheet" href="style/style.css">
</head>
<body>
	<%
		session.getAttribute("product_saved");
	%>


	<div class="container">
		<h1>My Product Page</h1>
	</div>
	
	
	<div class="mytext">
		Product added Successfully with data:<br><br>
		Barcode: ${product_saved.barcode}<br>
		Name:  ${product_saved.pname}<br>
		Color: ${product_saved.color}<br>
		Description: ${product_saved.pDescription}<br>
	</div>
	
	
	<form action="redirect_to">
		<div class="mytext">
			<br><br>Do you want to add another product?<br><br>
			<input type="submit" value="yes">
		</div>
	</form>
	
	<form action="red_to_index">
		<div class="mytext">
			<input type="submit" value="no">
		</div>
	</form>
</body>
</html>