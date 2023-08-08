<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type=text/css>

body{
margin:0;
padding:0;
font-family: montserrat;
background: linear-gradient(120deg,#2980b9, #8e44ad);
height: 100vh;
overflow:hidden;
}

.center{
position: absolute;
top:50%;
left:50%;
transform: translate(-50%, -50%);
width: 400px;
background: white;
border-radius: 10px;
}

.center h1{
text-align: center;
padding: 0 0 20px 0;
border-bottom: 1px solid silver;
}

.center form{
padding: 0 40px;
box-sizing: border-box;
}

form .control-label{
position: relative;
margin: 30px 0;
}

form input{
width: 100%;
padding: 0 5px;
height:35px;
font-size:16px;
border:none;
background:none;
outline:none;
border-bottom:2px solid #adadad;
}

.form-group button[type="submit"]{
width: 25%;
height:25px;
border: 1px solid;
background: #2691d9;
border-radius:25px;
color: #e9f4fb;
}


</style>
</head>

<body>



<div class="center">

<h1>Login</h1>
<form:form method="post" action="credentials">
 
	<div class="form-group">
		<label class="control-label" for="email"> Email </label>
		<form:input path="customerEmail" autofocus="autofocus" name="customerEmail" type="email"
			required="required" />
	</div>

	<div class="form-group">
		<label class="control-label" for="password"> Password </label>
		<form:input path="customerPassword" autofocus="autofocus" name="customerPassword" type="password"
			required="required" />
	</div>

</br>
	<div class="form-group">
		<button type="submit" class="btn btn-success">Login</button> &nbsp &nbsp <a href="/signup">Signup</a>
	</div>
	</br>
</form:form>
</div>

</body>
</html>