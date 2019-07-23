<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="red" color="white" align="center">
	<h2>There is some Server error while processing</h2><br><br>
	<h3>Server Error:  <%= exception.getMessage() %></h3>
	<h2>Please try again!!</h2><br><br>
	<h3> <a href="index.jsp"> Go to home page</a> </h3>
</body>
</html>