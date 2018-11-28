<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


        <form action="register">
            Account Number <input type="number"  name="account_number"><br>
            User ID <input type="text" name="user_id"><br>
            Login Password <input type="password" name="login_password"><br>
            Confirm Login Password <input type="password"><br>
            Transaction Password <input type="password" name="transaction_password"><br>
            Confirm Transaction Password <input type="password"><br>
            Security Question
            <select name="security_questions">
                <option value="select">select</option>
                <option value="What was your childhood nickname?">What was your childhood nickname?</option>
                <option value="What is your favourite movie?">What is your favourite movie?</option>
                <option value="What is your favourite team?">What is your favourite team?</option>
            </select>
            <br>
            Security Answer <input type="text" name="security_answers">
            <input type="submit" value="Register">
        </form>
      





<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">

<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.4.2/css/all.css' integrity='sha384-/rXc/GQVaYpyDdyxK+ecHPVYJSN9bmVFBvjA/9eOB+pb3F2w2N6fc5qB9Ew5yIns' crossorigin='anonymous'>

  <link rel="stylesheet" href="registration.css">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

 <link rel="stylesheet" href="registration.css">
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">SBBI Bank</a>
    </div>
</nav>
  
<form action="register" method="post">
  <div class="container" align="center">

    <h1 align="center">Register for Internet Banking</h1>
   <center> <h4>Please fill in the form to avail Internet Banking</h2></center>
    <hr>    
  <label for="Account No"><b>Account Number *<span class="fa fa-address-card"></span>  :</b></label><br>
    <input type="text" placeholder="Enter your account number" name="account_number" required><br>

    <label for="User Id"><b>Set User Id * <span class="fa fa-user-circle"></span> :</b></label><br>
    <input type="text" placeholder="Set your user id" name="user_id" required><br>

<label for="Login password"><b>Set login password * <span class="fa fa-key"></span> :</b></label><br>
    <input type="password" placeholder="Set your login password" name="login_password" required><br>

<label for="Confirm login password "><b>Confirm login password *  :</b></label><br>
    <input type="password" placeholder="Confirm your login password" required><br>

<label for="Transaction password"><b>Set Transaction password * <span class="fa fa-key"></span> :</b></label><br>
    <input type="password" placeholder="Set your transaction password" name="transaction_password" required><br>

<label for="Confirm transaction password "><b>Confirm transaction password *  :</b></label><br>
    <input type="password" placeholder="Confirm your transaction password" required><br>

<label for="Security Question "><b>Select a security question * <span class="fa fa-question"></span>  :</b></label><br>
    <select name="security_questions">
        <option value="State">Select</option>
        <option value="What's your childhood nickname">What's your childhood nickname?</option>
        <option value="What's your favourite movie?">What's your favourite movie?</option>
         <option value="What's your favourite sport?">What's your favourite sport?</option> <required>
</select><br>

<label for="Security Answer "><b>Your Answer * <span class="fa fa-pencil"></span>:</b></label><br>
<input type="text" placeholder="Enter your security answer" name="security_answers" required><br>
   
    <input type="submit" class="registerbtn" value="Register">
  
  </form>
  <div class="container loginin">
    <p>Already have an account? <a href="#">Login</a>.</p>
  </div>
</form>

</body>
</html>