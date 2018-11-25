<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addPayee">
<%-- <input style="display:hidden;" type="number" value="${account_number}" name="customer_account_number">
 --%>Payee Account Number : <input type="number" name="payee_account_number"><br>
Name : <input type="text" name="name"><br>
NickName: <input type="text" name="nick_name"><br>
<input type="submit">
</form>

</body>
</html>