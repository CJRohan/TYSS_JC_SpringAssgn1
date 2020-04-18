<%@page import="com.tyss.springmvc.beans.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% EmployeeInfoBean employeeInfoBean = (EmployeeInfoBean) request.getAttribute("empInfo");
	String errMsg = (String) request.getAttribute("errMsg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>Search Employee Record</legend>
		<form action="./getEmployee" method="get">
			Emplyoee ID : <input type="text" name="empId" required="required">
			<br><br>
			<input type="submit" value="Search"> 
		</form>
	</fieldset>
	
	<% if (errMsg != null && !errMsg.isEmpty()) { %>
		<h3 style="color: red;"><%=errMsg %></h3>
	<% } %>
	
	<% if (employeeInfoBean != null) { %>
	<br><br>
	<div align="center">
		<table border="1" style="width: 70%;">
			<tr style="background: navy; color: white;">
				<th>Emp ID</th>
				<th>Name</th>
				<th>Mobile</th>
				<th>Salary</th>
			</tr>
			<tr>
				<td><%=employeeInfoBean.getEmpId()%></td>
				<td><%=employeeInfoBean.getEmpName()%></td>
				<td><%=employeeInfoBean.getMobile()%></td>
				<td><%=employeeInfoBean.getSalary()%></td>
			</tr>
		</table>
	</div>

	<% } %>
	
</body>
</html>
















