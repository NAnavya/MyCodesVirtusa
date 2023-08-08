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




	<h2>Sorry Please SIGNUP Again</h2>




	<div class="alert">
		<span class="closebtn"
			onclick="this.parentElement.style.display='none';">&times;</span> <strong>Check!</strong>
		User with email already exists!!!.Try with other.
	</div>


	<a href="signup">Try signing up again with different email</a>

</body>
</html>