<%@ page language="java" import = "java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<TITLE>Login Bean</TITLE></HEAD>  
<BODY>
<jsp:useBean id="ud"  class="beans.LoginBean" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="ud"/>
<jsp:forward page="Login"></jsp:forward>   
</body>
</html>