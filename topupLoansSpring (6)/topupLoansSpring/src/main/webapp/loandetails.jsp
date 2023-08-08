
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>Insert title here</title>  
</head>  
<body >
    <form action="getLoanByUserId">
        <h1 style="text-align: center;">Applicants</h1>
 <table border="1" cellpadding="1" width="100%">
   
    <tr style="text-align: center;">
        <th>User Id</th>
        <th>Loan id</th>
        <th>Loan Type</th>
        <th>Amount Needed</th>
        <th>Emi</th>
        <th>Status</th>
    </tr>
    <c:forEach var="loans" items="${loans}">
		<tr style="text-align:center">
            <td>${loans.user.id}</td>
			<td>${loans.id}</td>
            <td>${loans.loanType}</td>
            <td>${loans.amount_needed}</td>
            <td>${loans.emi}</td>
			<td>${loans.status}</td>
		</tr>
	</c:forEach>
 </table>
 <button ><a href="WelcomeUser.jsp">Back</a></button>
</form>

</body>
</html>