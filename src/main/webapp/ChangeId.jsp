<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="checkId" method="post">
Old ID<input type="text" name="old"><br>
New User ID<input type="text" name="new"><br>
Confirm User ID<input type="text" name="confirm"><br>
<input type="submit" value="change id">
</form>

${changeId }

</body>
</html>