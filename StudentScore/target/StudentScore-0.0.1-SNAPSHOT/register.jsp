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
	<form name ="form" action="RegisterController" method="post">
	<input type="hidden" name="action" value="register">
	
	<h3 align="center">Register:</h3>
		<table align="center">
			<tr>
				<td>User Name:</td>	
				<td>
					<input type="text" name="username">
					<c:if test="${not empty requestScope.fail4 }"><font color=red><c:out value="${requestScope.fail4 }"/></c:if>	
					<c:if test="${not empty requestScope.fail3 }"><font color=red><c:out value="${requestScope.fail3 }"/></c:if>	
				</td>
			</tr>
			<tr>
				<td>Password:</td>	
				<td>
					<input type="password" name="password1">
					<c:if test="${not empty requestScope.fail2 }"><font color=red><c:out value="${requestScope.fail2 }"/></c:if>	
				</td>
			</tr>
			<tr>
				<td>Password Again:</td>	
				<td>
					<input type="password" name="password2">
					<c:if test="${not empty requestScope.fail2 }"><font color=red><c:out value="${requestScope.fail2 }"/></c:if>	
					<c:if test="${not empty requestScope.fail1 }"><font color=red><c:out value="${requestScope.fail1 }"/></c:if>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="Envoyer"><input type="reset" value="reset">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>