<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="register">
Account Number<input type="number" name="account_number"><br>
User ID <input type="text" name="user_id"><br>
Login Password <input type="text" name="login_password"><br>
Confirm Login Password <input type="text"><br>
Transaction Password <input type="text" name="transaction_password"><br>
Confirm Transaction Password <input type="text"><br>
Security Question<select name="security_questions">
        <option value="select">select</option>
        <option value="What was your childhood nickname?">What was your childhood nickname?</option>
        <option value="What is your favourite movie?">What is your favourite movie?</option>
        <option value="What is your favourite team?">What is your favourite team?</option>
</select><br>
Security Answer <input type="text" name="security_answers">
<input type="submit" value="Register">

</form>
</body>
</html>