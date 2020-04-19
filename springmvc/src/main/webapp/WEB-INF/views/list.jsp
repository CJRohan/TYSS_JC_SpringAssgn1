<%@page import="com.tyss.springmvc.beans.Login"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EmployeeList</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
	<%
	if(session.getAttribute("admin") == null)
		response.sendRedirect("./logout");
	%>
	<header class = "card-header text-center">Employee Management Portal</header>
	<div class = " text-right"> <a
		href="./welcome"
		class = "btn btn-success">HOME</a>
	<a
		href="./logout"
		class = "btn btn-warning" >LOGOUT</a>
		</div>
 <br> ${messagel}
	<div align="center">
		<a
			href="./add">ADD
			a new user</a><br> <br>
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
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${employees}" var="employee">
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
					<td>
						<form action="./add" method = "POST">
						<input type = "hidden" name = "action" value = "edit">
						<input type = "hidden" name = "id" value = "${employee.empid}">
						<input type = "hidden" name = "name" value = "${employee.name}">
						<input type = "hidden" name = "password" value = "${employee.password}">
						<input type = "hidden" name = "mail" value = "${employee.mailid}">
						<input type = "hidden" name = "dob" value = "${employee.dob}">
						<input type = "hidden" name = "joined" value = "${employee.joined}">
						<input type = "hidden" name = "deptid" value = "${employee.deptid}">
						<input type = "hidden" name = "managerid" value = "${employee.managerid}">
						<input type = "hidden" name = "designation" value = "${employee.designation}">
						<input type = "hidden" name = "salary" value = "${employee.salary}">
						<input type = "hidden" name = "mobile" value = "${employee.mobile}">
						<input type = "submit" value = "Edit" class = "btn btn-outline-success">
						</form>
					 </td>
					 <td> <a class = "btn btn-outline-danger"
						href="./list?id=${employee.empid}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>