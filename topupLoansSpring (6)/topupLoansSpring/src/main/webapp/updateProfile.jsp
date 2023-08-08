<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>Insert title here</title>  
</head>  
<body>
    <h1>Update User</h1>

    <form action="/editsave" method="post">
        <input type="hidden" name="_method" value="PUT"> <!-- Use this for PUT request -->
        
        <label for="userid">User Id:</label>
        <input type="text" id="userid" name="userid" value="${user.userid}" required><br><br>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${user.name}" required><br><br>

        <label for="aadhar">Aadhar:</label>
        <input type="text" id="aadhar" name="aadhar" value="${user.aadhar}" required><br><br>
        
        <label for="pan">Pan:</label>
        <input type="text" id="pan" name="pan" value="${user.pan}" required><br><br>
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" value="${user.address}" required><br><br>
        <label for="salary">Salary:</label>
        <input type="text" id="salary" name="salary" value="${user.salary}" required><br><br>


        <input type="submit" value="Update">
        <button ><a href="WelcomeUser.jsp">Back</a></button>
    </form>
</body>
</html>