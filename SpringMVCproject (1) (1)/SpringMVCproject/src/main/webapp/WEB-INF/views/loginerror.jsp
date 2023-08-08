<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
.alert {
	padding: 20px;
	background-color: #f44336;
	color: white;
	font-size: large;
}

.closebtn {
	margin-left: 15px;
	color: white;
	font-weight: bold;
	float: right;
	font-size: 22px;
	line-height: 20px;
	cursor: pointer;
	transition: 0.3s;
}

.closebtn:hover {
	color: black;
}
</style>



</head>
<body>



	<h2>Sorry Please LOGIN Again</h2>


	<div class="alert">
		<span class="closebtn"
			onclick="this.parentElement.style.display='none';">&times;</span> <strong>Check!</strong>
		Your emailId or Password is wrong
	</div>
	<a href="login">Try login again with Correct email</a>

</body>
</html>