<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<c:set var="loc" value="en_US" />
<c:if test="${not empty param.locale }" >
<c:set var="loc" value="${param.locale }" />
</c:if>
<fmt:setLocale value="${loc}" />${param.locale}
<fmt:bundle basename="app"> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>StudentSystem <fmt:message key="email" /></title>
</head>  
<body>
<%-- 	<form action="${formActionURL}" method="post"> --%>
	<form action="j_security_check" method="post">
	<table>
	<tr>
	<td colsapan="2" bgcolor="black">
	<br/>
	<center><font face="arial" size=+2 color="white"><b><i>Student</i>System<fmt:message key="email"/></b></font>
	</center>
	<br/>
	</td>
	</tr>
	<tr>
	<td><fmt:message key="username" /></td>
	<td>
	<input type="hidden" name="local" value="${loc}" />
	<input type="text" name="j_username" size="40" />
	</td>
	</tr>
	<tr>
	<td><fmt:message key="password"/></td>
	<td><input type="text" name="j_password" size="40" /></td>
	</tr>
	<tr>
	<td colspan="2" align="center"><input type="submit" value="<fmt:message key='login'/>"/></td>
	</tr>
	</table>
	</form>
	</fmt:bundle>
</body>
</html>