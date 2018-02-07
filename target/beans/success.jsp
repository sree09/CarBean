<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logged in succesfully</title>
</head>
<body>
<jsp:useBean id="ud"  class="beans.LoginBean" scope="session"></jsp:useBean>
<form method = "post" action="Car">
Welcome <jsp:getProperty property="userName" name="ud"/>
Logged in Successfully.
Click here to check car inventory.
<input type = "submit" value = "cars">
</form>
</body>
</html>