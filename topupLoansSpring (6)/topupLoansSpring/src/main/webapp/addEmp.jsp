<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>Insert title here</title>  
</head>  
<body>
    <form action="/addEmp" method="post">
   Name: <input type="text" name="name"><br>
    Email: <input type="email" name="email"><br>
    Password :<input type="password" name="password"><br>
    Confirm Password:<input type="password" name="conPassword"><br>
    <input type="submit">
    <button><a href="WelcomeAdmin.jsp">Back</a></button>
    </form>
    
</body>
</html>