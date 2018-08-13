<%@ page language="java" contentType="text/html"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" id="bootstrap-css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
#mycontainer {
	background-color: orange;
}
</style>
</head>

<body>
	<div id="mycontainer" class="container">social icon</div>

	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">ecombackend</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="home">Home</a>
		
					<li><a href="login">LoginPage</a></li>
					<li><a href="register"> RegisterPage </a></li>
					<li><a href="contactus">ContactUs</a></li>
					<li><a href="aboutus">AboutUs</a></li>
				
						<li><a href="category">Manage Category</a></li>
						<li><a href="manageproduct">Manage Product</a></li>
					
						<li><a href="productDisplay">Display Product</a></li>
					
		</ul>
	</div>
	<div class="nav navbar-nav navbar-right">
		<font color="white" face="calibri" size="3">Welcome:${username}</font> 
		<a href="/logout"><font color="white" face="calibri" size="2">Logout</font></a>
	</div>
	</nav>
</body>
</html>

