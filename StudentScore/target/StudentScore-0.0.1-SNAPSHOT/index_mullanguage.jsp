<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Lanage</title>
</head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<body>
	<table>
	<tr>
	<td colspan="4" bgcolor="black">
	<br/>
	<center><font face="frial" size=+2 color="white"><b><i>Student</i>System</b></font>	
	</center>
	<br/>
	</td>
	</tr>
	<tr>
	<td>
	<c:url value="login.jsp" var="englishURL">
	<c:param name="locale" value="en" />
	</c:url>
	<a href="${englishURL }">English</a>
	</td>
	<td>
	<c:url value="login.jsp" var="englishURL">
	<c:param name="locale" value="fr" />
	</c:url>
	<a href="${englishURL }">French Canadian</a>
	</td>
	</tr>
	</table>
	
</body>
</html>