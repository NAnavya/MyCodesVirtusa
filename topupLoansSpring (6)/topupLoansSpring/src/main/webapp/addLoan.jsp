<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>Insert title here</title>  
</head>  
<body>
  <h2> Add Loan</h2>
  amount_needed
  <form action="/addLoan" method="post">
    loanType : <select  name="loanType">
        <option value="HOME">HOME</option>
        <option value="EDUCATION">EDUCATION</option>
        <option value="PERSONAl">PERSONAL</option>
    </select><br>
    Salary : <input type="text" name="salary" ><br>
    Amount Required :<input type ="text" name="amount_needed"><br>
    Span : <input type="text" name="span" ><br>
    <a href="WelcomeUser.jsp"> 
    <button >Submit</button>
    </a>
    <a href="WelcomeUser.jsp">Back</a>
  </form>
</body>
</html>