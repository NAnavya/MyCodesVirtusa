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

a {
	color: white;
}
</style>

<script>
	function myFunction() {
		let inputVal = document.getElementById("searchTxt").value.toUpperCase();
		let productRows = document.getElementsByClassName("productRow");
		Array.from(productRows).forEach(
				function(element) {
					let productTxt = element
							.getElementsByClassName("productName")[0].innerText
							.toUpperCase();
					if (productTxt.includes(inputVal)) {
						element.style.display = "";
					} else {
						element.style.display = "none";
					}
				})
	}
</script>

<title>Premium calculator</title>
</head>
<body>

	<nav>
		<label class="logo"><a href="/viewpolicies">PreCalc</a></label>
		<ul>
			<li><a href="viewqueries">Customer Queries</a></li> &nbsp
			<li><a href="addPolicy">Add new Policy</a></li> &nbsp
			<li><a href="viewcustomers">View Users</a></li> &nbsp
			<li><a href="addAdmin">Add Admin</a></li> &nbsp
			<li><a href="/login">Logout</a></li> &nbsp
		</ul>
	</nav>
	</br>
	<h1 align="center">Welcome Admin!!</h1>
	</br>
	<h1 align="center">Life Insurance Policy List</h1>
	</br>
	<div>
		<input id="searchTxt" type="search" size="25"
			placeholder="Search By Insurer"
			aria-label="Search" onkeyup="myFunction()">
	</div>
	</br>
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
			<th>Action</th>
			<th>Action</th>

		</tr>
		<c:forEach var="policy" items="${list}">
			<tr class="productRow" style="text-align: center">
				<td>${policy.policyId}</td>
				<td class="productName">${policy.insurer}</td>
				<td>${policy.schemeName}</td>
				<td>${policy.minPolicyTerm}</td>
				<td>${policy.maxPolicyTerm}</td>
				<td>${policy.minEntryAge}</td>
				<td>${policy.maxEntryAge}</td>
				<td>${policy.maxCoverAge}</td>
				<td>${policy.minSumAssured}</td>
				<td><a href="updatepolicy/${policy.policyId}"><img
						alt="edit"
						src="https://cdn-icons-png.flaticon.com/512/84/84380.png"
						width="25px"></a></td>
				<td><a href="deletepolicy/${policy.policyId}"><img
						alt="delete"
						src="https://t4.ftcdn.net/jpg/03/46/38/39/360_F_346383913_JQecl2DhpHy2YakDz1t3h0Tk3Ov8hikq.jpg"
						width="30px"></a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>