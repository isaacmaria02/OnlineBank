<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
if(session!=null)
{
	if(session.getAttribute("isAdminLoggedIn")==null)
	{
		out.println(session.getAttribute("isAdminLoggedIn"));
		response.sendRedirect("index.jsp");
	}
}
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<link rel="stylesheet" href="css/bootstrap-theme.min.css">

<script src="js/bootstrap.min.js" ></script>


<script  src="js/jquery-3.3.1.min.js" ></script>

<script src="bootstable.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Print Customer Information</title>
</head>
<body>
<div align="center" style="margin-top:50px">
<h3>Dear ${userInfo.first_name },</h3>
<h3>Your account has been activated. Please use the following account number to activate for internet banking</h3>
<h3>Account Number : ${userInfo.account_number }</h3>
<input class="btn btn-info" type="button" value="Print" onclick="window.print()" /> 
<a class="btn btn-info" href="display">Go back</a>
</div>
</body>
</html>