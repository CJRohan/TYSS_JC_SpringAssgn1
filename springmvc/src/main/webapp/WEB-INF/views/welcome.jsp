<%@page import="com.tyss.springmvc.beans.Login"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<%
String name = "";
if(session.getAttribute("admin") == null)
	response.sendRedirect("./logout");
else 
	name = ((Login)session.getAttribute("admin")).getAdmin();
%>
<header class = "card-header text-center">Employee Management Portal</header>
	<div class = " text-right"><a
		href="./logout"
		class = "btn btn-warning">LOGOUT</a>
		</div><br>
	<br>
	<div class = "text-center">
		<h1>Welcome <%= name %></h1>
	</div><br><br>
	<br>
	<div align="center">	
		<a
			href="./add" class = "btn btn-link">Add
			User</a> <br> <br> <a
			href="./list" class = "btn btn-link">View
			Users</a> <br> <br> <form
			action="./welcome">
			Search by ID : <input type = "text" name = "id">
			<input type = "submit" value = "Search" class = "btn btn-primary">
			<br>${message}</form>
	</div>
	<%if(request.getAttribute("employee") != null) {%>
	<br><br>
				<div align="center">
				<table class = "table-striped table-hover table-bordered text-center"  >
				<tr class = "table-info">
				<th >ID</th>
				<th>Name</th>
				<th colspan=2>DOB&emsp;&ensp;&emsp;JoinedOn<br>yyyy-mm-dd</th>
				<th>DeptID</th>
				<th>Designation</th>
				<th>Salary</th>
				<th>OfficialEmail</th>
				<th>Mobile</th>
			    </tr>
				<tr>
					<td>${employee.empid}</td>
					<td>${employee.name}</td>
					<td>${employee.dob}</td>
					<td>${employee.joined}</td>
					<td>${employee.deptid}</td>
					<td>${employee.designation}</td>
					<td>${employee.salary}</td>
					<td>${employee.mailid}</td>
					<td>${employee.mobile}</td>
				</tr>
				</table>
				</div>
	<%} %>
</body>
</html>