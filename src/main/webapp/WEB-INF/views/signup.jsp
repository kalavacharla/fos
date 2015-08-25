<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SignUp Page</title>
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/main.js" type="text/javascript"></script>

</head>
<body>
<h1>Sign up</h1>
	<form action="signup" method="post">
		<label>Username</label>
		<input type="text" name="username">
		<label>Email</label>
		<input type="text" name="email">
		<label>Password</label>
		<input type="password" name="password">
		<input type="Submit" value="Submit" id="signupSubmit" />
	</form>
</body>
</html>