<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course Registration</title>
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
		<h1>Registration Success</h1>
		<br><span>Full name:</span><span>${user.name}</span><br>
		<br><span>ID:</span><span>${user.id}</span><br>
		<br><span>Age:</span><span>${user.age}</span><br>
		<br><span>Email-ID:</span><span>${user.email}</span><br>
		<br><button onClick="JavaScript:window.location='homepage.jsp';">Back to Home Page</button>
	</div>
</body>
</html>