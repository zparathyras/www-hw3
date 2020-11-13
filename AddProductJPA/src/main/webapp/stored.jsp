<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,demo.Product" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Stored Products</title>
	<link rel="stylesheet" href="style/style.css">
</head>
<body>
	<div class="container">
		<h1>My Product Page</h1>
	</div>
	
	<%
		List<Product> products = (List<Product>)request.getAttribute("products");
	%>
	
	<h3 style="color:black; text-align: center;" > Stored Product Details </h3>	   
	<h4 style="color:black; text-align: center;" > Total Number of Products is <%= products.size() %> </h4>

	<table border="1" style="color:black; margin-left:auto; margin-right:auto;">
		<tr>
			<th> Barcode </th> <th> Name </th> <th> Color </th> <th> Description </th>
		</tr>
		<%
			for(int i=0;i<products.size();i++) {
	        	Product produuct = products.get(i); 
		%>
		<tr> 
			<td><%= produuct.getBarcode() %></td>
			<td><%= produuct.getPname() %></td>
			<td><%= produuct.getColor() %></td>
			<td><%= produuct.getpDescription() %></td>
	
		</tr>
		<%     
			}
		%>
	</table>
	
	<form action="red_to_index">
		<div class="mytext">
			Back to options page.<input type="submit" value="go">
		</div>
	</form>
</body>
</html>