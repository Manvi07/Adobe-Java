<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Welcome , ${user} <br />
	<a href="logout.do">Logout</a>
	<h1> This is a JSP file</h1>
	<h3>Printing unicode characters</h3>
	<%
		for(int i = 2305; i < 3500; i++) {
	%>
		<%= i %> character is &#<%= i %>; <br />
	
	<%
		}
	%>
</body>
</html>