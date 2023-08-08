<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type=text/css>
* {
	padding: 0;
	margin: 0;
	text-decoration: none;
	list-style: none;
	box-sizing: border-box;
}

nav {
	background: #0082e6;
	height: 80px;
	width: 100%;
}

label.logo {
	color: white;
	font-size: 35px;
	line-height: 80px;
	padding: 0 100px;
}

nav ul {
	float: right;
	margin-right: 20px;
}

nav ul li {
	display: inline-block;
	line-height: 80px;
	margin: 0 5px;
}

nav ul li a {
	color: white;
	font-size: 17px;
	text-transform: uppercase;
}
</style>
<title>Premium calculator</title>
</head>

<body>

	<nav>
		<label class="logo">PreCalc</label>
		<ul>
			<li><a href="/customer/contactUs">Contact Us</a></li> &nbsp
			<li><a href="/login">Logout</a></li>
		</ul>
	</nav>

</br>
	<h1 align="center">Welcome Customer!!</h1> </br>
	<h1 align="center">Policy List</h1></br>
	<table border="1" width="100%" cellpadding="1">
		<tr style="text-align: center">
			<th>Id</th>
			<th>Insurer</th>
			<th>Scheme Name</th>
			<th>Min Policy Term</th>
			<th>Max Policy Term</th>
			<th>Min Entry Age</th>
			<th>Max Entry Age</th>
			<th>Max Cover Age</th>
			<th>Min Sum Assured</th>
			<th>Premium</th>

		</tr>
		<c:forEach var="policy" items="${list}">
			<tr style="text-align: center">
				<td>${policy.policyId}</td>
				<td>${policy.insurer}</td>
				<td>${policy.schemeName}</td>
				<td>${policy.minPolicyTerm}</td>
				<td>${policy.maxPolicyTerm}</td>
				<td>${policy.minEntryAge}</td>
				<td>${policy.maxEntryAge}</td>
				<td>${policy.maxCoverAge}</td>
				<td>${policy.minSumAssured}</td>
				<td><a href="/customer/premium/${policy.policyId}"><img
						alt="premium"
						src="https://img.lovepik.com/free-png/20210926/lovepik-calculator-icon-free-vector-illustration-material-png-image_401495032_wh1200.png"
						width="25px"></a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<h3>Above is the list of policies for our customer to see what we
		have to offer</h3>
	<h4>What's the price for this security in Life? Wondering!! Click
		on the link above and find out.</h4>

</body>
</html>