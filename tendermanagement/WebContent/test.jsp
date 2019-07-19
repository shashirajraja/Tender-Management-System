<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%= new java.util.Date() %>
	
	<%
	/* Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tender","root","root"); */
	Connection con = com.hit.utility.DBUtil.provideConnection();
	if(con !=null)
		out.print("connected");
	else
		out.print("Not connectd");
	
	String str = "Hello!, JSP Welcome You";
	%>
	<h1>Here is the firs jsp variable: <%= str %></h1>
	<%
	
		PreparedStatement ps = con.prepareStatement("select * from notice");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			String id = rs.getString(1);
			String title = rs.getString(2);
			String info = rs.getString("info");
			out.print(id+" "+title+"    "+info);
			%>
			
			<table style="border:2px red solid; margin:20px; padding:25px; color:red">
			<tr>
				<td><%=id %></td>
				<td><%=title %></td>
				<td><%=info %></td>
			</tr>
			</table>
			
			<%
			
		}
		//out.print("Execution Completed!");
	%>
</body>
</html>