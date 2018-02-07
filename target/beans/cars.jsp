<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="javax.servlet.jsp.jstl.core.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="beans.CarBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cars Inventory</title>
</head>
<body>
        <p><b><i>List of cars:</i></b></p>
        
        <a href="another.jsp">click here for another jsp </a>
        <table border="1">

            <tr>
            <th>VIN</th>
            <th>MAKE</th>
            <th>MODEL</th>
            <th>YEAR</th>
            <th>MILEAGE</th>
            <th>PRICE</th>
            </tr>
<% 	ArrayList<CarBean> cars = (ArrayList<CarBean>)request.getAttribute("cars"); %>

	<% for(CarBean car:cars){
			%><tr> <td> <% out.println(car.getVin()); %> </td>
			<td> <% out.println(car.getMake()); %> </td>
			<td> <% out.println(car.getModel()); %> </td>
			<td> <% out.println(car.getYear()); %> </td>
			<td> <% out.println(car.getMileage()); %> </td>
			<td> <% out.println(car.getPrice()); %> </td>
			</tr>
			<%  
	}
	%>
	<br/>
	<br/>
        </table>
                <table border="1">

            <tr>
            <th>VIN</th>
            <th>MAKE</th>
            <th>MODEL</th>
            <th>YEAR</th>
            <th>MILEAGE</th>
            <th>PRICE</th>
            </tr>
	<%ArrayList<CarBean> carslist = (ArrayList<CarBean>)session.getAttribute("carlist");%>

	<% for(CarBean car:carslist){
			%><tr> <td> <% out.println(car.getVin()); %> </td>
			<td> <% out.println(car.getMake()); %> </td>
			<td> <% out.println(car.getModel()); %> </td>
			<td> <% out.println(car.getYear()); %> </td>
			<td> <% out.println(car.getMileage()); %> </td>
			<td> <% out.println(car.getPrice()); %> </td>
			</tr>
			<%  
	}
	%>

        </table>
        
       
</body>
</html>