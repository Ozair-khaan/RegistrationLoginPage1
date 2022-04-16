<%@page import="com.bean.student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color:green">Login has Successfully Done !</h1><br><br><br>
	
	<h4>Your Details are shown below in the table.</h4>
	
	<table border=1>
	<th>First Name</th><th>middle name</th><th>last name</th><th>Mobile no</th>
	<th>Email</th><th>Address/<th>User Name</th> <th>Password</th> <th>ReType password</th>
	<tr>
	<%
		student st =(student)	session.getAttribute("uname");
	
	     
		%>
		<td><%= st.getFirstname() %></td>
		<td><%= st.getMiddlename() %></td>
		<td><%= st.getLastname() %></td>
		<td><%= st.getMobileno() %></td>
		<td><%= st.getEmail() %></td>
		<td><%= st.getAddress() %></td>
		<td><%= st.getUsername() %></td>
		<td><%= st.getPassword() %></td>
		<td><%= st.getRetypepsw() %></td>
		</tr>
		</table>
</body>
</html>