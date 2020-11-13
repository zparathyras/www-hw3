<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>My Product Page</title>
	<link rel="stylesheet" href="style/style.css">
</head>
<body>
	<div class="container">
		<h1>My Product Page</h1>
	</div>

	<form action="redirect_to">
		<div class="mytext">
			Insert new product.<br>
			<input type="submit" value="Insert">
		</div>
	</form>
	
	<form action="ShowStored">
		<div class="mytext">
			Show stored products.<br>
			<input type="submit" value="show">
		</div>
	</form>
</body>
</html>