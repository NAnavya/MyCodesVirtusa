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
 <a href="addLoan.jsp">Add Loan</a><br><br>
 <a href="allLoanByUserId">Loan Status</a><br><br>
 <a href="allProfileByUserId">View Profile</a><br><br>
 <a href="userprofile.jsp">Add Profile</a><br><br>
 <a href="editusers">Update Profile</a><br><br>
 <button ><a href="Home.jsp">Back</a></button>
</body>
</html>