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
<body>
	
<center>Send Email</center>

<form method="post" action="StudentController">
	<table>
		<tr>
			<td>Sender:</td>
			<td>
			<input type="text" name="sender" value="default" readonly="readonly" >
			
			</td>
		</tr>
		<tr>
			<td>Receiver:</td>
			<td>
				<input type="text" name="receiver" value="All the students " readonly="readonly">
			</td>
		</tr>		
		<tr>
			<td>Message:</td>
			<td>
				<input type="textarea" name="message"  >
			</td>
		<tr>
		
			<td></td>
			<td align="right">
				<input type="submit" name="send" value="send"  >
			</td>
		</tr>
		</tr>
	</table>

</form>
</body>
</html>