<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="controller.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<body>
	<form name ="form" action="UserController" method="post">
	<input type="hidden" name="action" value="login">
	
	<h3 align="center">Welcome to Student Score System:</h3>
		<table align="center">
			<tr>
				<td>User Name:</td>	
				<td>
					<input type="text" name="username">
					<c:if test="${not empty requestScope.faillog2 }"><font color=red><c:out value="${requestScope.faillog2 }"/></c:if>
				</td>
			</tr>
			<tr>
				<td>Password:</td>	
				<td>
					<input type="password" name="password">
					<c:if test="${not empty requestScope.faillog1 }"><font color=red><c:out value="${requestScope.faillog1 }"/></c:if>	
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td>
					<input type="submit" value="login"><input type="reset" value="reset">
					<a href="register.jsp">register</a>
				</td>
				
			</tr>
		</table>
	</form>
</body>
</html>