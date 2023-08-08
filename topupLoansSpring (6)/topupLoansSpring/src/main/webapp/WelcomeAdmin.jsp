<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>Insert title here</title>  
</head>  
<body>
  <h2> Welcome  ${user.name} </h2>
 <p> Just go for loan</p>
 <a href="alluser">View Applicants</a><br><br>
 <a href="alladmin">View Admins</a><br><br>
 <a href="delete.jsp">Delete User</a><br><br>
 <a href="deleteLoans.jsp">Delete Loan</a><br><br>
 <a href="addEmp.jsp">Add Admin</a><br><br>
 <a href="deleteAdmin.jsp">Delete Admin</a><br><br>
 <a href="allloan">Approved Loans</a><br><br>
 <button ><a href="Home.jsp">Back</a></button>

</body>
</html>