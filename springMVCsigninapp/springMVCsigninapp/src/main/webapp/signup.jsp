<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sign page</title>
</head>
<body>
<form action ="signup" method ="post">
Emailid: <input type="text" name="emailid"/><br/>
Password: <input type="password" name="password"/><br/>
Type of User: <select name ="typeofuser">
<option value="admin">ADMIN</option>
<option value="customer">CUSTOMER</option>
</select><BR>
<input type="submit" value="Sign Up"/>

</form>
<a href="login">Login</a>

</body>
</html>