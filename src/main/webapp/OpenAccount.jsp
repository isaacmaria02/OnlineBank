<%@ page errorPage="ErrorPage.jsp" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
     <script language="Javascript" src="jquery.js"></script>
    <script type="text/JavaScript" src='state.js'></script>
    <link rel="stylesheet" type="text/css" href="state.css">
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
                    <h1>OPEN ACCOUNT</h1>
                </div><!-- .col -->
            </div><!-- .row -->
        </div><!-- .container -->
    </div><!-- .page-header -->

 <form action="open" method="post">
  <div class="container" align="center" >

    <h1 align="center">Open a savings account</h1>
    <h2>Personal details</h2>
    <hr>

    <label for="Title"><b>Title* <span class="fas fa-hand-point-down"> :</span></b></label><br>
    <select name="Title" required>
        <option value="select">Select</option>
        <option value="Mr.">Mr.</option>
	<option value="Ms.">Ms.</option>
	 <option value="Mrs.">Mrs.</option>
	</select><br>

  <label for="First Name"><b>First Name* <span class="fa fa-user"></span> :</b></label><br>
    <input type="text" pattern="[A-Za-z]{3,20}"  maxlength="20"  title="Minimum 3 characters, No special Characters Allowed, No spaces allowed"   placeholder="Enter First Name" name="first_name" required><br>

    <label for="Middle Name"><b>Middle Name <span class="fa fa-user"></span> :</b></label><br>
    <input type="text" pattern="[A-Za-z]{3,20}"  maxlength="20"  title="Minimum 3 characters, No special Characters Allowed" placeholder="Enter Middle Name" name="middle_name"><br>

<label for="Last Name"><b>Last Name* <span class="fa fa-user"></span> :</b></label><br>
    <input type="text" pattern="[A-Za-z]{3,20}"  maxlength="20"  title="Minimum 3 characters, No special Characters Allowed" placeholder="Enter Last Name" title="Minimum 3 characters" name="last_name" required><br>

<label for="Father's Name"><b>Father's Full Name* <span class="fa fa-user"></span> :</span></b></label><br>
    <input type="text" pattern="[a-zA-Z][a-zA-Z\s]*{8,30}"  maxlength="30"  placeholder="Enter Father's Full Name" name="father_name" title="Please enter " required><br>

<label for="Email Id"><b>Email Id <span class = "fa fa-envelope"></span></b></label><br>
<input type="email" id="Enter Email Id" title="Please enter a valid email address ending with e.g. @gmail.com,@yahoo.com etc." name="email_id" pattern="[a-zA-Z]{1}[a-zA-Z0-9._%+-]+@[a-z.-]+\.[a-z]{2,3}$"></br>

 <label for="Mobile No"><b>Mobile Number* <span class="fa fa-mobile"></span>:</b></label><br>
<input type="tel" name="mobile_number" pattern="[6-9]{1}[0-9]{9}" maxlength="10"  title="Please enter a valid mobile number starting with 6,7,8 or 9" required>
</br>

<label for="Aadhar Card No"><b>Aadhar Card No* <span class="fa fa-address-card"></span>:</b></label><br>
    <input type="text" placeholder="Enter Aadhar No" name="aadhar_card"  maxlength="12" pattern = "[2-9]{1}[0-9]{11}" title="Please enter a 12 digit aadhar number, not starting with 0 or 1" required><br> 

<label for="Date Of Birth"><b>Date Of Birth* <span class="fa fa-calendar"></span>:</b></label><br>
    <input type="date"  name="date_of_birth"  min="1960-01-01" max="2000-01-31" required><br>
    
    <label for="Annual_Income"><b>Annual Income* :</b></label><br>
    <input type="number"  name="annual_income" pattern="[1-9]{1}[0-9]+" min="10000" max="100000000" ><br>

 <p><b>Address <span class="fa fa-address-card"></span>:</b></p><br>

 <label for="Address Line 1"><b>Address Line 1* :</b></label><br>
    <input type="text"    maxlength="30" name="address_line_1" required><br>
    
<label for="Address Line 2"><b>Address Line 2* :</b></label><br>
    <input type="text"   maxlength="30" name="address_line_2" required><br>
    
 <div class='resp_code frms'>

      <div id="selection">
        <b>State* :</b> <br>
      <select name="state" id="listBox" onchange='selct_district(this.value)'></select>
                     <br><b>City* :</b> <br>
       
        <select name="city" id='secondlist'></select>
      </div>
      
      <div id="dumdiv" align="center" style=" font-size: 10px;color: #dadada;">
        <a id="dum" style="padding-right:0px; text-decoration:none;color: green;text-align:center;" ></a>
      </div>
    </div>
    
<label for="Pincode"><b>Pincode* :</b></label><br>
    <input type="text"  name="pin_code" pattern="[1-9]{1}[0-9]{5}" maxlength="6" required><br><br>

<input type="checkbox" name="Agree" value="Agree" required>By creating an account you agree to our terms and conditions.<br>
   
    <input type="submit" class="registerbtn" value="Open Account">
  
  </form>

</div>


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