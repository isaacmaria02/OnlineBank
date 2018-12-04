<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/adminlogin.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Homepage</title>
</head>
<body>




       <h1 align="center" style="color:white;">Admin Portal</h1>

<div class="login-page">
  <div class="form">
   
    <form class="login-form" action="adminlogin" method="post">
      <input type="text" placeholder="username" name="adminId"/>
      <input type="password" placeholder="password" name="adminPassword"/>
      <button>login</button>
    </form>
  </div>
</div>

</body>
</html>