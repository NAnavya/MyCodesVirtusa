<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>Insert title here</title>  
</head>  
<body>
    <h1>Update Loan</h1>

    <form action="/saveloan" >
        <input type="hidden" name="_method" value="PUT"> <!-- Use this for PUT request -->
        
        <label for="id">Id:</label>
        <input type="text" id="id" name="id" value="${loan.id}" readonly><br><br>

        <label for="userid">User Id:</label>
        <input type="text" id="userid" name="userid" value="${loan.user.id}" readonly><br><br>
        <label for="loanType">Loan Type:</label>
        <input type="text" id="loanType" name="loanType" value="${loan.loanType}" required><br><br>

        <label for="salary">Salary:</label>
        <input type="text" id="salary" name="salary" value="${loan.salary}" required><br><br>
        
        <label for="amount_needed">Amount Needed:</label>
        <input type="text" id="amount_needed" name="amount_needed" value="${loan.amount_needed}" required><br><br>
        <label for="span">Span:</label>
        <input type="text" id="span" name="span" value="${loan.span}" required><br><br>
        <label for="emi">EMI:</label>
        <input type="text" id="emi" name="emi" value="${loan.emi}" required><br><br>
        <label for="status">Status:</label>
        <input type="text" id="status" name="status" value="${loan.status}" required><br><br>


        <input type="submit" value="Update">
        <button ><a href="WelcomeAdmin.jsp">Back</a></button>
    </form>
</body>
</html>