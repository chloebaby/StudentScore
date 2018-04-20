<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <title>Student System</title>   
	    
	   
	</head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
	<body>
	    <center><h1>Student System</h1></center>	    
	   
	    <div align="right">
	    <p style="color:gree;font-size:23px">UserName:<c:out value="${user.username}" />&nbsp  &nbsp   
	    <a href="UserController?action=exit&username=${user.username}" style="color:gree;font-size:23px"><input type="hidden" name="username" value="${user.username}" />SignOut</a>
	    </p>		
	    </div>
	    
	    
	    <span>
	     <div >
            <h3>            
            <a href="courselist.jsp"   target="iframePosition" >Course</a>
            </h3>
        </div>
         <div>
            <h3>            
            <a href="studentlist.jsp" target="iframePosition" >Students</a>
            </h3>
        </div>
         <div>
            <h3>
            <a href="resultlist.jsp" target="iframePosition" >Results</a>
            </h3>
        </div>
        <div>
            <h3>
            <a href="mailpdf.jsp" target="iframePosition" >Mail&File</a>
            </h3>
        </div>        
         <div>
            <h3>
            <a href="personalinfo.jsp" target="iframePosition" >Account Summary</a>
            </h3>
        </div>
        </span>
        <div style=display:inline >
        
            <iframe id="iframePosition" name="iframePosition" width= "1000px" height="500px" src="" ></iframe>
        </div>
       
	</body>
	
</html>

 