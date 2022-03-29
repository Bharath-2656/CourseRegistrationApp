<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logged in</title>
</head>
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
<body>
	<div align="center">
		<h1>Login Success</h1>
		<br><span>Email-ID:</span><span>${user.email}</span><br>
		<br><button onClick="JavaScript:window.location='area_of_intrest.jsp';">Choose Area of Interest</button>
	</div>
</body>
</html>