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
	<div id="menu">
		<div align="left" class="" style="padding :9px;">
		<a href="ResultController?action=listresult">List Result</a>		
		</div>
	</div>
	
	<table border="1" align="center">
		<thead>
			<tr>
				
				<th>Student ID</th>
				<th>Course ID</th>
				<th>Semester</th>
				<th>Marks</th>
				<th>Creation Date</th>
				<th colspan=2>Action</th>
			</tr>
		</thead>
		<tbody>		
			<c:forEach begin="0" end="${fn:length(results)}" items="${results}" var="result">
				<tr>
				<td><c:out value="${result.student.studentid}" /></td>
				<td><c:out value="${result.course.courseid}" /></td>
				<td><c:out value="${result.semester}" /></td>		
				<td><c:out value="${result.marks}" /></td>	
				<td><c:out value="${result.creationdate}" /></td>			
				<td>	
					<a href="ResultController?action=edit&studentid=<c:out value="${result.student.studentid }"/>&courseid=<c:out value="${result.course.courseid }"/>">Update</a>
				</td>				
				<td>
					<a href="ResultController?action=delete&studentid=<c:out value="${result.student.studentid }"/>&courseid=<c:out value="${result.course.courseid }"/>">Delete</a>
				</td>
			</tr>
			</c:forEach>			
		</tbody>	
			
	</table>
	<p><a href="ResultController?action=insert">Add Result</a></p>

</body>
</html>