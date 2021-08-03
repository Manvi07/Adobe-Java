<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form method="post" action="chat.do">
		Message <input type="text" name="message" />
		<button type="submit">Send</button>
	</form>
	
	<c:forEach items="${messages}" var="msg">
		${msg} <br />
	</c:forEach>
</body>	
</html>