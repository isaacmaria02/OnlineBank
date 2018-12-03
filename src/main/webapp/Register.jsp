<%@ page errorPage="ErrorPage.jsp" %>  


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%-- 
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

 <link rel="stylesheet" href="css/registration.css">
 <link rel="stylesheet" href="css/addbtn.css">
 <link rel="stylesheet" href="css/passwordShow.css">
 <link rel="stylesheet" href="css/Button.css">
<script type="text/javascript">

function Validate(){
var loginpassword = document.getElementById("Password").value;
var conloginpass = document.getElementById("ConfirmPassword").value;
	if(loginpassword != conloginpass){
alert ("Login Password do not match.");
return false;
}
return true;
}	
	function ValidateTran(){
var TranPass = document.getElementById("TransactionPass").value;
var conTranPass = document.getElementById("ConTransactionPass").value;
	if(TranPass != conTranPass){
alert ("Transaction Password do not match.");
return false;
}
return true;
}
</script>

</head>
<body>

<nav class="navbar navbar-inverse">

   <ul class="nav navbar-nav pull-right float-left">
            <li><a  href="javascript:history.back()" class="btn btn-outline-light	pull-right">Back</a></li>
        </ul>   


  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">SBBI Bank</a>
    </div>
</nav>
  
  <h2>${register }</h2>
<form action="register" method="post">
  <div class="container" align="center">

    <h1 align="center">Register for Internet Banking</h1>
   <center> <h4>Please fill in the form to avail Internet Banking</h2></center>
    <hr>    
    <h2>${register_error }</h2>
  <label for="Account No"><b>Account Number *<span class="fa fa-address-card"></span>  :</b></label><br>
    <input type="number" placeholder="Enter your account number" name="account_number" maxlength="12" required><br>

    <label for="User Id"><b>Set User Id * <span class="fa fa-user-circle"></span> :</b></label><br>
    <input type="text" placeholder="Set your user id" pattern="[A-Za-z0-9]{}"  maxlength="8" name="user_id" required><br>
<label for="Password"><b>Enter Login Password* <span class="fa fa-key"></span> :</span></b></label><br>
    <input type="password" id="Password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Password must contain at least one number,one uppercase letter and one lowercase letter, and at least 8 or more characters" placeholder="Enter new password" name="login_password" required><br>
    <div id="message">
  <h3>Password must contain the following:</h3>
  <p id="letter" class="invalid">A <b>lowercase</b> letter</p>
  <p id="capital" class="invalid">A <b>capital (uppercase)</b>letter</p>
  <p id="number" class="invalid">A <b>number</b></p>
  <p id="length" class="invalid">Minimum <b>8 characters</b></p>
</div> 
<script>
var myInput = document.getElementById("Password");
var letter = document.getElementById("letter");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");

// When the user clicks on the password field, show the message box
myInput.onfocus = function() {
    document.getElementById("message").style.display = "block";
}

// When the user clicks outside of the password field, hide the message box
myInput.onblur = function() {
    document.getElementById("message").style.display = "none";
}

// When the user starts to type something inside the password field
myInput.onkeyup = function() {
  // Validate lowercase letters
  var lowerCaseLetters = /[a-z]/g;
  if(myInput.value.match(lowerCaseLetters)) {  
    letter.classList.remove("invalid");
    letter.classList.add("valid");
  } else {
    letter.classList.remove("valid");
    letter.classList.add("invalid");
  }
  
  // Validate capital letters
  var upperCaseLetters = /[A-Z]/g;
  if(myInput.value.match(upperCaseLetters)) {  
    capital.classList.remove("invalid");
    capital.classList.add("valid");
  } else {
    capital.classList.remove("valid");
    capital.classList.add("invalid");
  }

  // Validate numbers
  var numbers = /[0-9]/g;
  if(myInput.value.match(numbers)) {  
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }
  
  // Validate length
  if(myInput.value.length >= 8) {
    length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }
}
</script>

<label for="Confirm New Password"><b>Confirm New Password* :</b></label><br>
<input type="password" id="ConfirmPassword" onblur="return Validate()" placeholder="Confirm New Password" name="LOGIN_PASSWORD" required></br>
   
  <label for="Trans Password"><b>Enter Transaction Password* <span class="fa fa-key"></span> :</span></b></label><br>
    <input type="password" id="TransactionPass" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Password must contain at least one number,one uppercase letter and one lowercase letter, and at least 8 or more characters" placeholder="Enter new password" name="transaction_password" required><br>
    <div id="message">
  <h3>Password must contain the following:</h3>
  <p id="letter" class="invalid">A <b>lowercase</b> letter</p>
  <p id="capital" class="invalid">A <b>capital (uppercase)</b>letter</p>
  <p id="number" class="invalid">A <b>number</b></p>
  <p id="length" class="invalid">Minimum <b>8 characters</b></p>
</div> 
<script>
var myInput = document.getElementById("Password");
var letter = document.getElementById("letter");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");

// When the user clicks on the password field, show the message box
myInput.onfocus = function() {
    document.getElementById("message").style.display = "block";
}

// When the user clicks outside of the password field, hide the message box
myInput.onblur = function() {
    document.getElementById("message").style.display = "none";
}

// When the user starts to type something inside the password field
myInput.onkeyup = function() {
  // Validate lowercase letters
  var lowerCaseLetters = /[a-z]/g;
  if(myInput.value.match(lowerCaseLetters)) {  
    letter.classList.remove("invalid");
    letter.classList.add("valid");
  } else {
    letter.classList.remove("valid");
    letter.classList.add("invalid");
  }
  
  // Validate capital letters
  var upperCaseLetters = /[A-Z]/g;
  if(myInput.value.match(upperCaseLetters)) {  
    capital.classList.remove("invalid");
    capital.classList.add("valid");
  } else {
    capital.classList.remove("valid");
    capital.classList.add("invalid");
  }

  // Validate numbers
  var numbers = /[0-9]/g;
  if(myInput.value.match(numbers)) {  
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }
  
  // Validate length
  if(myInput.value.length >= 8) {
    length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }
}
</script>
<label for="Confirm transaction password "><b>Confirm transaction password *  :</b></label><br>
  <input type="password" id="ConTransactionPass"                onblur="return ValidateTran()" placeholder="Confirm your transaction password" required><br>

<label for="Security Question "><b>Select a security question * <span class="fa fa-question"></span>  :</b></label><br>
    <select name="security_questions">
        <option value="State">Select</option>
        <option value="What's your childhood nickname">What's your childhood nickname?</option>
        <option value="What's your favourite movie?">What's your favourite movie?</option>
         <option value="What's your favourite sport?">What's your favourite sport?</option> <required>
</select><br>

<label for="Security Answer "><b>Your Answer * <span class="fa fa-pencil"></span>:</b></label><br>
<input type="text" placeholder="Enter your security answer" pattern=[A-Za-z]{} name="security_answers" required><br>
   
    <input type="submit" class="registerbtn" value="Register">
  
  </form>
  <div class="container loginin">
    <p>Already have an account? <a href="#">Login</a>.</p>
  </div>
</form>

</body>
</html>

 --%>
 
 <html lang="en">
<head>
    <title>SBBI Bank</title>
    
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">

<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.4.2/css/all.css' integrity='sha384-/rXc/GQVaYpyDdyxK+ecHPVYJSN9bmVFBvjA/9eOB+pb3F2w2N6fc5qB9Ew5yIns' crossorigin='anonymous'>


  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

 <link rel="stylesheet" href="css/registration.css">
 
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

 <link rel="stylesheet" href="css/registration.css">
 <link rel="stylesheet" href="css/addbtn.css">
 <link rel="stylesheet" href="css/passwordShow.css">
 <link rel="stylesheet" href="css/Button.css">
<script type="text/javascript">

function Validate(){
var loginpassword = document.getElementById("Password").value;
var conloginpass = document.getElementById("ConfirmPassword").value;
	if(loginpassword != conloginpass){
alert ("Login Password do not match.");
return false;
}
return true;
}	
	function ValidateTran(){
var TranPass = document.getElementById("TransactionPass").value;
var conTranPass = document.getElementById("ConTransactionPass").value;
	if(TranPass != conTranPass){
alert ("Transaction Password do not match.");
return false;
}
return true;
}
</script>
 

    <!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <!-- FontAwesome CSS -->
    <link rel="stylesheet" href="css/font-awesome.min.css">

    <!-- ElegantFonts CSS -->
    <link rel="stylesheet" href="css/elegant-fonts.css">

    <!-- themify-icons CSS -->
    <link rel="stylesheet" href="css/themify-icons.css">

    <!-- Swiper CSS -->
    <link rel="stylesheet" href="css/swiper.min.css">

    <!-- Styles -->
    <link rel="stylesheet" href="style.css">
</head>
<body class="single-page about-page">
<header class="site-header">
    <div class="top-header-bar">
        <div class="container">
            <div class="row flex-wrap justify-content-center justify-content-lg-between align-items-lg-center">
                <div class="col-12 col-lg-8 d-none d-md-flex flex-wrap justify-content-center justify-content-lg-start mb- mb-lg-0">
                    <div class="header-bar-email">
                        
                    </div><!-- .header-bar-email -->

                    <div class="header-bar-text">
                        
                    </div><!-- .header-bar-text -->
                </div><!-- .col -->

                <div class="col-12 col-lg-4 d-flex flex-wrap justify-content-center justify-content-lg-end align-items-center">
                    <div class="donate-btn">
                       
                    </div><!-- .donate-btn -->
                </div><!-- .col -->
            </div><!-- .row -->
        </div><!-- .container -->
    </div><!-- .top-header-bar -->

    <div class="nav-bar">
        <div class="container">
            <div class="row">
                <div class="col-12 d-flex flex-wrap justify-content-between align-items-center">
                    <div class="site-branding d-flex align-items-center">
                       
                    </div><!-- .site-branding -->

                    <nav class="site-navigation d-flex justify-content-end align-items-center">
                        <ul class="d-flex flex-column flex-lg-row justify-content-lg-end align-content-center">
                            <li class="current-menu-item"><a href="index.html">Home</a></li>
                            <li><a href="about.html">About us</a></li>
                            
                            <li><a href="contact.html">Contact</a></li>
                            <li><a href="contact.html">FAQ's</a></li>
                        </ul>
                    </nav><!-- .site-navigation -->

                    <div class="hamburger-menu d-lg-none">
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                    </div><!-- .hamburger-menu -->
                </div><!-- .col -->
            </div><!-- .row -->
        </div><!-- .container -->
    </div><!-- .nav-bar -->
</header><!-- .site-header -->

    <div class="page-header">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <h1>REGISTRATION FOR INTERNET BANKING</h1>
                </div><!-- .col -->
            </div><!-- .row -->
        </div><!-- .container -->
    </div><!-- .page-header -->

   

  

 





  <h2>${register }</h2>
<form action="register" method="post">
  <div class="container" align="center">

    <h1 align="center">Register for Internet Banking</h1>
   <center> <h4>Please fill in the form to avail Internet Banking</h2></center>
    <hr>    
    <h2>${register_error }</h2>
  <label for="Account No"><b>Account Number *<span class="fa fa-address-card"></span>  :</b></label><br>
    <input type="number" placeholder="Enter your account number" name="account_number" maxlength="12" required><br>

    <label for="User Id"><b>Set User Id * <span class="fa fa-user-circle"></span> :</b></label><br>
    <input type="text" placeholder="Set your user id" pattern="[A-Za-z0-9]{}"  maxlength="8" name="user_id" required><br>
<label for="Password"><b>Enter Login Password* <span class="fa fa-key"></span> :</span></b></label><br>
    <input type="password" id="Password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Password must contain at least one number,one uppercase letter and one lowercase letter, and at least 8 or more characters" placeholder="Enter new password" name="login_password" required><br>
    <div id="message">
  <h3>Password must contain the following:</h3>
  <p id="letter" class="invalid">A <b>lowercase</b> letter</p>
  <p id="capital" class="invalid">A <b>capital (uppercase)</b>letter</p>
  <p id="number" class="invalid">A <b>number</b></p>
  <p id="length" class="invalid">Minimum <b>8 characters</b></p>
</div> 
<script>
var myInput = document.getElementById("Password");
var letter = document.getElementById("letter");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");

// When the user clicks on the password field, show the message box
myInput.onfocus = function() {
    document.getElementById("message").style.display = "block";
}

// When the user clicks outside of the password field, hide the message box
myInput.onblur = function() {
    document.getElementById("message").style.display = "none";
}

// When the user starts to type something inside the password field
myInput.onkeyup = function() {
  // Validate lowercase letters
  var lowerCaseLetters = /[a-z]/g;
  if(myInput.value.match(lowerCaseLetters)) {  
    letter.classList.remove("invalid");
    letter.classList.add("valid");
  } else {
    letter.classList.remove("valid");
    letter.classList.add("invalid");
  }
  
  // Validate capital letters
  var upperCaseLetters = /[A-Z]/g;
  if(myInput.value.match(upperCaseLetters)) {  
    capital.classList.remove("invalid");
    capital.classList.add("valid");
  } else {
    capital.classList.remove("valid");
    capital.classList.add("invalid");
  }

  // Validate numbers
  var numbers = /[0-9]/g;
  if(myInput.value.match(numbers)) {  
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }
  
  // Validate length
  if(myInput.value.length >= 8) {
    length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }
}
</script>

<label for="Confirm New Password"><b>Confirm New Password* :</b></label><br>
<input type="password" id="ConfirmPassword" onblur="return Validate()" placeholder="Confirm New Password" name="LOGIN_PASSWORD" required></br>
   
  <label for="Trans Password"><b>Enter Transaction Password* <span class="fa fa-key"></span> :</span></b></label><br>
    <input type="password" id="TransactionPass" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Password must contain at least one number,one uppercase letter and one lowercase letter, and at least 8 or more characters" placeholder="Enter new password" name="transaction_password" required><br>
    <div id="message">
  <h3>Password must contain the following:</h3>
  <p id="letter" class="invalid">A <b>lowercase</b> letter</p>
  <p id="capital" class="invalid">A <b>capital (uppercase)</b>letter</p>
  <p id="number" class="invalid">A <b>number</b></p>
  <p id="length" class="invalid">Minimum <b>8 characters</b></p>
</div> 
<script>
var myInput = document.getElementById("Password");
var letter = document.getElementById("letter");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");

// When the user clicks on the password field, show the message box
myInput.onfocus = function() {
    document.getElementById("message").style.display = "block";
}

// When the user clicks outside of the password field, hide the message box
myInput.onblur = function() {
    document.getElementById("message").style.display = "none";
}

// When the user starts to type something inside the password field
myInput.onkeyup = function() {
  // Validate lowercase letters
  var lowerCaseLetters = /[a-z]/g;
  if(myInput.value.match(lowerCaseLetters)) {  
    letter.classList.remove("invalid");
    letter.classList.add("valid");
  } else {
    letter.classList.remove("valid");
    letter.classList.add("invalid");
  }
  
  // Validate capital letters
  var upperCaseLetters = /[A-Z]/g;
  if(myInput.value.match(upperCaseLetters)) {  
    capital.classList.remove("invalid");
    capital.classList.add("valid");
  } else {
    capital.classList.remove("valid");
    capital.classList.add("invalid");
  }

  // Validate numbers
  var numbers = /[0-9]/g;
  if(myInput.value.match(numbers)) {  
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }
  
  // Validate length
  if(myInput.value.length >= 8) {
    length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }
}
</script>
<label for="Confirm transaction password "><b>Confirm transaction password *  :</b></label><br>
  <input type="password" id="ConTransactionPass"                onblur="return ValidateTran()" placeholder="Confirm your transaction password" required><br>

<label for="Security Question "><b>Select a security question * <span class="fa fa-question"></span>  :</b></label><br>
    <select name="security_questions">
        <option value="State">Select</option>
        <option value="What's your childhood nickname">What's your childhood nickname?</option>
        <option value="What's your favourite movie?">What's your favourite movie?</option>
         <option value="What's your favourite sport?">What's your favourite sport?</option> <required>
</select><br>

<label for="Security Answer "><b>Your Answer * <span class="fa fa-pencil"></span>:</b></label><br>
<input type="text" placeholder="Enter your security answer" pattern=[A-Za-z]{} name="security_answers" required><br>
   
    <input type="submit" class="registerbtn" value="Register">
  
  </form>
  <div class="container loginin">
    <p>Already have an account? <a href="#">Login</a>.</p>
  </div>
</form>















    <footer class="site-footer">
        <div class="footer-widgets">
            <div class="container">
                <div class="row">
                    <div class="col-12 col-md-6 col-lg-3">
                        <div class="foot-about">
                           

                            <p>SBBI Bank is a multinational banking and financial services company headquartered in Mumbai, India. It operates a network of more than 1,200 branches and outlets (including subsidiaries, associates and joint ventures) across more than 70 countries and employs around 87,000 people.</p>

                            <ul class="d-flex flex-wrap align-items-center">
                                <li><a href="#"><i class="fa fa-pinterest-p"></i></a></li>
                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                <li><a href="#"><i class="fa fa-behance"></i></a></li>
                                <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                            </ul>
                        </div><!-- .foot-about -->
                    </div><!-- .col -->

                    <div class="col-12 col-md-6 col-lg-3 mt-5 mt-md-0">
                        <h2>Our Offerings</h2>

                        <ul>
                            <li><a href="#">Savings Account</a></li>
                            <li><a href="#">Credit Card</a></li>
                            <li><a href="#">Debit Card</a></li>
                            <li><a href="#">Download our App</a></li>
                            <li><a href="#">Contact Us</a></li>
                            
                        </ul>
                    </div><!-- .col -->

                    <div class="col-12 col-md-6 col-lg-3 mt-5 mt-md-0">
                        <div class="foot-latest-news">
                            <h2>Media Center</h2>

                            <ul>
                                <li>
                                    <h3><a href="#">About us</h3>
                                    
                                </li>

                                <li>
                                    <h3><a href="#">Careers</a></h3>
                                    
                                </li>

                                <li>
                                    <h3><a href="#">FAQ's</a></h3>
                                    
                                </li>
                            </ul>
                        </div><!-- .foot-latest-news -->
                    </div><!-- .col -->

                    <div class="col-12 col-md-6 col-lg-3 mt-5 mt-md-0">
                        <div class="foot-contact">
                            <h2>Contact</h2>

                            <ul>
                                <li><i class="fa fa-phone"></i><span>+91 022 26501509</span></li>
                                <li><i class="fa fa-envelope"></i><span>sbbi@outlook.com</span></li>
                                <li><i class="fa fa-map-marker"></i><span>Main Street, Opp Hypercity Mall ,Thane(West) Mumbai,Maharashtra</span></li>
                            </ul>
                        </div><!-- .foot-contact -->

                        <div class="subscribe-form">
                            <form class="d-flex flex-wrap align-items-center">
                                <input type="email" placeholder="Your email">
                                <input type="submit" value="send">
                            </form><!-- .flex -->
                        </div><!-- .search-widget -->
                    </div><!-- .col -->
                </div><!-- .row -->
            </div><!-- .container -->
        </div><!-- .footer-widgets -->

        <div class="footer-bar">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <p class="m-0"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved 
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                    </div><!-- .col-12 -->
                </div><!-- .row -->
            </div><!-- .container -->
        </div><!-- .footer-bar -->
    </footer><!-- .site-footer -->

    <script type='text/javascript' src='js/jquery.js'></script>
    <script type='text/javascript' src='js/jquery.collapsible.min.js'></script>
    <script type='text/javascript' src='js/swiper.min.js'></script>
    <script type='text/javascript' src='js/jquery.countdown.min.js'></script>
    <script type='text/javascript' src='js/circle-progress.min.js'></script>
    <script type='text/javascript' src='js/jquery.countTo.min.js'></script>
    <script type='text/javascript' src='js/jquery.barfiller.js'></script>
    <script type='text/javascript' src='js/custom.js'></script>

</body>
</html>
