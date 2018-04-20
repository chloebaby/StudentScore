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
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<body>
	
<center>Student Page</center>

<form:form action="${pageContext.request.contextPath}" method="POST" modelAttribute="student">
	
	Last Name:<form:input path="lastname"/>
	<br>
	First Name:<form:input path="firstname"/>
	<br>
	Address:<form:input path="address"/>
	<br>
	City:<form:input path="city"/>
	<br>
	Email:<form:input path="email"/>
	<br>
	<input type="submit" name="save" value="save"  >
</form:form>


</body>
</html>