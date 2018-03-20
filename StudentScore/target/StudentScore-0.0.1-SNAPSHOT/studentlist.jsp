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
		<a href="StudentController?action=liststudent">List Student</a>		
		</div>
	</div>
	
	<table border="1" align ="center" width="80%" align="center">
		<thead>
			<tr>
				
				<th>Student ID</th>
				<th>Last Name</th>
				<th>First Name</th>
				<th>Address</th>
				<th>City</th>
				<th>Email</th>
				<th colspan=2>Action</th>
			</tr>
		</thead>
		<tbody>		
			<c:forEach begin="0" end="${fn:length(students)}" items="${students}" var="student">
				<tr>
				<td><c:out value="${student.studentid}" /></td>
				<td><c:out value="${student.lastname}" /></td>
				<td><c:out value="${student.firstname}" /></td>		
				<td><c:out value="${student.address}" /></td>	
				<td><c:out value="${student.city}" /></td>		
				<td><c:out value="${student.email}" /></td>		
				<td>	
					<a href="StudentController?action=edit&studentid=<c:out value="${student.studentid }"/>">Update</a>
				</td>				
				<td>
					<a href="StudentController?action=delete&studentid=<c:out value="${student.studentid }"/>">Delete</a>
				</td>				
			</tr>
			</c:forEach>			
		</tbody>	
			
	</table>
	<p><a href="StudentController?action=insert">Add Student</a></p>
	
	<div>
	
<!-- 	<form action="StudentController" method="get"> -->
<!-- 		<input type="hidden" name="action" value="send"/> -->
<!-- 	<table> -->
<!-- 		<tr> -->
<!-- 			<td>FROM:</td> -->
<!-- 			<td> -->
<!-- 			<input type="text" name="sender" value="default" readonly="readonly" > -->
			
<!-- 			</td> -->
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>TO:</td> -->
<!-- 			<td> -->
<!-- 				<input type="text" name="receiver" value="All the students " readonly="readonly"> -->
<!-- 			</td> -->
<!-- 		</tr>	 -->
<!-- 		<tr> -->
<!-- 			<td>SubTitle:</td> -->
<!-- 			<td> -->
<!-- 				<input type="text" name="subtitle" > -->
<!-- 			</td> -->
<!-- 		</tr>		 -->
<!-- 		<tr> -->
<!-- 			<td>Message:</td> -->
<!-- 			<td>				 -->
<!-- 				<textarea name="message" cols="20" rows=5"></textarea> -->
<!-- 			</td>		 -->
<!-- 		</tr> -->
<!-- 	</table> -->
<!-- 	<p><input type="submit" name="send" value="send"></p> -->
<!-- 	</form> -->
	</div>
</body>
</html>