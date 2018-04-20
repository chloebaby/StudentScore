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
		<a href="studentlist">List Student</a>		
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
			<c:forEach items="${students}" var="student">
				<tr>
				<td><c:out value="${student.studentid}" /></td>
				<td><c:out value="${student.lastname}" /></td>
				<td><c:out value="${student.firstname}" /></td>		
				<td><c:out value="${student.address}" /></td>	
				<td><c:out value="${student.city}" /></td>		
				<td><c:out value="${student.email}" /></td>		
				<td>	
					<a href="">Update</a>
				</td>				
				<td>
					<!--  <a href="<c:url value='/remove/${student.studentid}'/>">Delete</a>-->
					<form action="remove/${student.studentid}" method="post">
						<input type="hidden" name="_method" value="DELETE /">
						<input type="submit" value="delete" />
					</form>
				</td>				
			</tr>
			</c:forEach>			
		</tbody>	
			
	</table>
	<p><a href="<c:url value='/student'/>">Add Student</a></p>
	
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