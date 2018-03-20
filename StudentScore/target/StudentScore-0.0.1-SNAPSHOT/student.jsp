<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<body>
	
<center>Students' Information</center>

<form method="post" action="StudentController">
	<table align="center">
<!-- 		<tr> -->
<!-- 			<td>Student ID:</td> -->
<!-- 			<td> -->
<%-- 			<input type="text" name="studentid" value="${student.studentid }" readonly="readonly" > --%>
			
<!-- 			</td> -->
<!-- 		</tr> -->
		<tr>
			<td>Last Name:</td>
			<td>
				<input type="text" name="lastname" value="${student.lastname} ">
			</td>
		</tr>
		<tr>
			<td>First Name:</td>
			<td>
				<input type="text" name="firstname" value="${student.firstname }" >
			</td>
		<tr>
		<tr>
			<td>Address:</td>
			<td>
				<input type="text" name="address" value="${student.address }" >
			</td>
		<tr>
		<tr>
			<td>City:</td>
			<td>
				<input type="text" name="city" value="${student.city }" >
			</td>
		<tr>
		<tr>
			<td>Email:</td>
			<td>
				<input type="text" name="email" value="${student.email }" >
			</td>
		<tr>
			<td></td>
			<td align="right">
				<input type="submit" name="save" value="save"  >
			</td>
		</tr>
		</tr>
	</table>

</form>
</body>
</html>