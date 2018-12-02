<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="checkTransactionPassword" method="post">
Old Password<input type="password" name="old"><br>
New Login Password<input type="password" name="new"><br>
Confirm Login Password<input type="password" name="confirm"><br>
<input type="submit" value="change id">
</form>

${changeTransactionPassword }

</body>
</html>