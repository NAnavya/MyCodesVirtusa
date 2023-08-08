<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<h1 align="center">Welcome Admin!!</h1>
<h1 align="center">Users And Admins List</h1>
<table border="1" width="100%" cellpadding="1">
	<tr style="text-align:center">
		<th>Name</th>
		<th>Mobile No.</th>
		<th>Email Id</th>
		<th>Role</th>
		
	</tr>
	<c:forEach var="customer" items="${list}">
		<tr style="text-align:center">
			<td>${customer.customerName}</td>
			<td>${customer.customerMobile}</td>
			<td>${customer.customerEmail}</td>
			<td>${customer.role}</td>
		</tr>
	</c:forEach>
</table>
