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
	<div>

		<form action="AttachController" method="get">
			<input type="submit" name="action" value="attach" />
		</form>

	</div>

	<div>
	
	<form action="StudentController" method="get">
		<input type="hidden" name="action" value="send"/>
	<table >
		<tr>
			<td>FROM:</td>
			<td>
			<input type="text" name="sender" value="default" readonly="readonly" >
			
			</td>
		</tr>
		<tr>
			<td>TO:</td>
			<td>
				<input type="text" name="receiver" value="All the students " readonly="readonly">
			</td>
		</tr>	
		<tr>
			<td>SubTitle:</td>
			<td>
				<input type="text" name="subtitle" >
			</td>
		</tr>				
		<tr>
			<td>Message:</td>
			<td>				
				<textarea name="message" cols="40" rows=10"></textarea>
			</td>		
		</tr>
	</table>
	<p ><input type="submit" class="button" name="send" value="send" onclick="SelSubmit2()" ></p>
	</form>
	</div>
</body>
  
</html>