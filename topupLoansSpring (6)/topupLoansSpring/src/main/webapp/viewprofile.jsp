
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>Insert title here</title>  
</head>  
<body >
    <form action="allProfileByUserId">
        <h1 style="text-align: center;">Applicants</h1>
 <table border="1" cellpadding="1" width="100%">
    <tr style="text-align: center;">
        <th>User Id</th>
        <th>Name</th>
        <th>Aadhar</th>
        <th>Pan</th>
        <th>Address</th>
        <th>Salary</th>
        
    </tr>
    <c:forEach var="userps" items="${userps}">
		<tr style="text-align:center">
            <td>${userps.userid}</td>
			<td>${userps.name}</td>
            <td>${userps.aadhar}</td>
            <td>${userps.pan}</td>
            <td>${userps.address}</td>
			<td>${userps.salary}</td>
		</tr>
	</c:forEach>
 </table>
 <button ><a href="WelcomeUser.jsp">Back</a></button>
</form>

</body>
</html>