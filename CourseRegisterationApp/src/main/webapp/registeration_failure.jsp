<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course Registration Home Page</title>
<style type="text/css">
label {
	display: inline-block;
	width: 200px;
	margin: 5px;
	text-align: left;
}

button {
	padding: 10px;
	margin: 10px;
}
</style>
</head>
<body>
	<div align="center">
		<h1>Invalid Email or Password</h1>
		<p>
			<br>Password requirements</br>
			<br>Password must contain at least one digit [0-9].</br>
			<br>Password must contain at least one lowercase character [a-z].</br>
			<br>Password must contain at least one uppercase character [A-Z].</br>
			<br>Password must contain at least one special character like ! @ # & ( ).</br>
			<br>Password must contain a length of at least 8 characters and a maximum of 20 characters.</br>
		</p>
		<button onClick="JavaScript:window.location='register.jsp';">Register</button>
	</div>
</body>
</html>