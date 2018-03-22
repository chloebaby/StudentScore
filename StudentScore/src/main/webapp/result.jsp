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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<body>
	
<center>Result' Information</center>

<form method="post" action="ResultController">
	<table align="center">
		<tr>
			<td>Student ID:</td>
			<td>					
			<select name="studentid" value="${student.studentid }">
				<c:forEach begin="0" end="${fn:length(students)}" items="${students}" var="student">	
				<option >${student.studentid }</option>
				</c:forEach>
			</select>
			
			</td>
		</tr>
		<tr>
			<td>Course ID:</td>
			<td>				
				<select name="courseid" value="${course.courseid}">
					<c:forEach begin="0" end="${fn:length(courses)}" items="${courses}" var="course">
					<option  >${course.courseid}</option>
					</c:forEach>
				</select>
				
			</td>
		</tr>
		<tr>
			<td>Semester:</td>
			<td>
				<input type="text" name="semester" value="${result.semester }" >
			</td>
		<tr>
		<tr>
			<td>Marks:</td>
			<td>
				<input type="text" name="marks" value="${result.marks }" >
			</td>
		<tr>
		<tr>
			<td>Creation Date:</td>
 			<td> 
 				<input type="datetime-local" name="creationdate" value="${result.creationdate }" >
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