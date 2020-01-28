<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
			<tr>
				<th>Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Number</th>
			</tr>
	          <c:forEach var="employee" items="${employees}" varStatus="count">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.fname}</td>
                    <td>${employee.lname}</td>
                    <td>${employee.number}</td>
                    <td><a href="editEmployees?employee_id=${employee.id}">Edit</a></td>
                    <td><a href="deleteEmployees?employee_id=${employee.id}">Delete</a></td>	         
                </tr>
             </c:forEach>
     </table>          
</body>
</html>