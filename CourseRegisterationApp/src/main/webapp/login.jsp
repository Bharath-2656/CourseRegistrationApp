<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
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
		<h1>Login Page</h1>
		<h2>Enter Login Details</h2>
		<form action="login" method="post" modelAttribute="user">
			<label>EMAIL</label> <input type="text" name="email"><br>
			<label>PASSWORD</label> <input type="password" name="password"><br>
			<button>Login</button>
			<br>
		</form>
	</div>
</body>
</html>