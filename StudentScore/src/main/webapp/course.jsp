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
	
<center>Courses' Information</center>

<form method="post" action="CourseController">
	<table align="center">
		<tr>
			<td>Course ID:</td>
			<td>
			<input type="text" name="courseid" value="${course.courseid}"  >
			
			</td>
		</tr>
		<tr>
			<td>Course Name:</td>
			<td>
				<input type="text" name="coursename" value="${course.coursename} ">
			</td>
		</tr>
		<tr>
			<td>Credit Numbers:</td>
			<td>
				<input type="text" name="creditnumbers" value="${course.creditnumbers }" >
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