<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>

<link rel="stylesheet" type="text/css" href="css/styles.css">

</head>
<body>

	<div class="container">

		<form action="registerUrl" method="post">
			<h1>Registration Form</h1>
			<label>  <input type="text"
				placeholder="Enter Name" name="name1" required="required" /></label> <br />
			<label> <br /> <br />
			<input type="email" placeholder="Enter Email" name="email1"
				required="required" /></label> <br /> <label> <br /> <br />
			<input type="password" placeholder="Enter Password" name="pass1"
				required="required" /></label> <br />
			<br />
			<div class="gender-group">
				<br> <label>Gender:</label> <label><input type="radio"
					name="gender1" value="male" /> Male</label> <label><input
					type="radio" name="gender1" value="female" /> Female</label>
			</div>

			<select name="city1">
				<option value="select" selected disabled>Select City</option>
				<option value="delhi">Delhi</option>
				<option value="mumbai">Mumbai</option>
				<option value="kolkata">Kolkata</option>
				<option value="chennai">Chennai</option>
				<option value="bangalore">Bangalore</option>
				<option value="hyderabad">Hyderabad</option>
				<option value="ahmedabad">Ahmedabad</option>
				<option value="pune">Pune</option>
				<option value="jaipur">Jaipur</option>
				<option value="lucknow">Lucknow</option>
			</select> <br /> <input type="submit" value="Register" /> <br />
			<!-- Add this section before the closing </form> tag -->
			<div class="login-section">
				<p>Already a user?      <a href="login.jsp" class="login-link">Login</a></p>
				
			</div>

		</form>
	</div>

</body>
</html>
