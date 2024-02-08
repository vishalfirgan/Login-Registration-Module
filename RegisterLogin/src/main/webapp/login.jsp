<!-- login.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>

<form action="loginurl" method="post">
    <h1>Login</h1>
    <label>Email: <br/><input type="email" placeholder="Enter Email" name="email2" required="required"/></label>
    <br/><br/>
    <label>Password: <br/><input type="password" placeholder="Enter Password" name="pass2" required="required"/></label>
    <br/><br/>
    <input type="submit" value="Login"/>

    <div class="register-link-container">
        <p>Not a user yet? <a href="form.jsp" class="register-link">Register</a></p>
    </div>
</form>

</body>
</html>
