<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.*" %>
<%@ page import="controller.*" %>
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
	<div id="menu" >
		<div  class="" style="padding :9px;">
		<a href="CourseController?action=listcourse" >List Course</a>		
		</div>
		<div ><p align="left"><a href="CourseController?action=insert" >Add Course</a></p></div>
	</div>
	
	<table border="1" align="center" align="center">
		<thead>
			<tr>
				
				<th>Course ID</th>
				<th>Course Name</th>
				<th>Course Creditnumber</th>
				<th colspan=2>Action</th>
			</tr>
		</thead>
		<tbody>		
			<c:forEach begin="0" end="${fn:length(courses)}" items="${courses}" var="course">
				<tr>
				<td><c:out value="${course.courseid}" /></td>
				<td><c:out value="${course.coursename}" /></td>
				<td><c:out value="${course.creditnumbers}" /></td>				
				<td>	
					<a href="CourseController?action=edit&courseid=<c:out value="${course.courseid }"/>">Update</a>
				</td>				
				<td>
					<a href="CourseController?action=delete&courseid=<c:out value="${course.courseid }"/>">Delete</a>
				</td>
			</tr>
			</c:forEach>			
		</tbody>	
			
	</table>
	

</body>
</html>