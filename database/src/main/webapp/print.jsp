<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products Page</title>
<link rel="stylesheet" href="./styles.css" >
</head>
<body>
	<h1 class="custom">Products JSP Page</h1>
	Welcome , ${user} <br />
	<a href="logout.do">Logout</a>
	
	<table border="1">
		<tr>
			<th>ID</th><th>Name</th><th>Price</th>
		</tr>
		<c:forEach items="${products}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.name}</td>
				<td>${p.price}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="index.html">Back</a>
</body>
</html>