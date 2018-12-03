<%@ page errorPage="ErrorPage.jsp" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Homepage</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!-- Required meta tags -->
    <meta charset="utf-8">
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
<body>
    <header class="site-header">
        <div class="top-header-bar">
            <div class="container">
                <div class="row flex-wrap justify-content-center justify-content-lg-between align-items-lg-center">
                    <div class="col-12 col-lg-8 d-none d-md-flex flex-wrap justify-content-center justify-content-lg-start mb-3 mb-lg-0">
                        <div class="header-bar-email">
                            MAIL: <a href="#">sbbi@outlook.com</a>
                        </div><!-- .header-bar-email -->

                        <div class="header-bar-text">
                            <p>PHONE: <span>+91 02226501509</span></p>
                        </div><!-- .header-bar-text -->
                    </div><!-- .col -->


                    <div class="col-12 col-lg-4 d-flex flex-wrap justify-content-center justify-content-lg-end align-items-center">
                        <div class="donate-btn">
                            <div class="dropdown">
  <button class="btn btn-default btn-group-sm navbar-btn dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Login/Register <span class="glyphicon glyphicon-user"></span>
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
    <a class="dropdown-item"  href="Login.jsp">Login</a>
    <a class="dropdown-item"  href="Register.jsp">Register for Internet Banking </a>
    <a class="dropdown-item" href="OpenAccount.jsp">Open a new Savings Account</a>
  </div>
</div>
                           <!-- <a href="#">Login <span class="glyphicon glyphicon-user"></span></a>-->
                        </div><!-- .donate-btn -->
                    </div><!-- .col -->
                </div><!-- .row -->
            </div><!-- .container -->
        </div><!-- .top-header-bar -->

        <div class="nav-bar">
            <div class="container">
                <div class="row">
                    <div class="col-12 d-flex flex-wrap justify-content-between align-items-center">
                        <div class="site-branding d-flex align-items-center"><br><br><br><br><br>
                            <h1 > SBBI Bank</h1>   

                         <!--  <a class="d-block" href="index.html" rel="home"><img class="d-block" src="images/logo.png" alt="logo" ></a>-->
                        </div>
                        <!-- .site-branding -->

                        <nav class="site-navigation d-flex justify-content-end align-items-center">
                            <ul class="d-flex flex-column flex-lg-row justify-content-lg-end align-content-center">
                                <li class="current-menu-item"><a href="index.jsp">Home</a></li>
                                <li><a href="about.html">About us</a></li>                              
                                <li><a href="contact.html">Contact</a></li>
                                <li><a href="FAQ.html">FAQ's</a></li>
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

    <div class="swiper-container hero-slider">
        <div class="swiper-wrapper">
            <div class="swiper-slide hero-content-wrap">
                <img src="images/bb2.jpg" alt="">

                <div class="hero-content-overlay position-absolute w-100 h-100">
                    <div class="container h-100">
                        <div class="row h-100">
                            <div class="col-12 col-lg-8 d-flex flex-column justify-content-center align-items-start">
                                <header class="entry-header">
                                    <h1>SBBI BANK</h1>
                                    <h4>"The name you can bank on!"</h4>
                                </header><!-- .entry-header -->

                                <div class="entry-content mt-4">
                                    <p>As a leading international bank, we strive to help people and businesses prosper across Asia, Africa and the Middle East</p>
                                </div><!-- .entry-content -->

                                <footer class="entry-footer d-flex flex-wrap align-items-center mt-5">
                                    <a href="Login.jsp" class="btn gradient-bg mr-2">Login</a>
                                    <a href="OpenAccount.jsp" class="btn orange-border">Apply online for account </a>
                                </footer><!-- .entry-footer -->
                            </div><!-- .col -->
                        </div><!-- .row -->
                    </div><!-- .container -->
                </div><!-- .hero-content-overlay -->
            </div><!-- .hero-content-wrap -->

            <div class="swiper-slide hero-content-wrap">
                <img src="images/bb1.jpg" alt="">

                <div class="hero-content-overlay position-absolute w-100 h-100">
                    <div class="container h-100">
                        <div class="row h-100">
                            <div class="col-12 col-lg-8 d-flex flex-column justify-content-center align-items-start">
                                <header class="entry-header">
                                    <h1>SBBI Bank</h1>
                                    <h4>"The name you can bank on!"</h4>
                                </header><!-- .entry-header -->

                                <div class="entry-content mt-4">
                                    <p>As a leading international bank, we strive to help people and businesses prosper across Asia, Africa and the Middle East</p>
                                </div><!-- .entry-content -->

                                <footer class="entry-footer d-flex flex-wrap align-items-center mt-5">
                                    <a href="Login.jsp" class="btn gradient-bg mr-2">Login</a>
                                    <a href="OpenAccount.jsp" class="btn orange-border">Apply online for account</a>
                                </footer><!-- .entry-footer -->
                            </div><!-- .col -->
                        </div><!-- .row -->
                    </div><!-- .container -->
                </div><!-- .hero-content-overlay -->
            </div><!-- .hero-content-wrap -->

            <div class="swiper-slide hero-content-wrap">
                <img src="images/bb.jpg" alt="">

                <div class="hero-content-overlay position-absolute w-100 h-100">
                    <div class="container h-100">
                        <div class="row h-100">
                            <div class="col-12 col-lg-8 d-flex flex-column justify-content-center align-items-start">
                                <header class="entry-header">
                                    <h1>SBBI Bank</h1>
                                    <h4>"The name you can bank on!"</h4>
                                </header><!-- .entry-header -->

                                <div class="entry-content mt-4">
                                    <p>As a leading international bank, we strive to help people and businesses prosper across Asia, Africa and the Middle East</p>
                                </div><!-- .entry-content -->

                                <footer class="entry-footer d-flex flex-wrap align-items-center mt-5">
                                    <a href="Login.jsp" class="btn gradient-bg mr-2">Login</a>
                                    <a href="OpenAccount.jsp" class="btn orange-border">Apply online for account</a>
                                </footer><!-- .entry-footer -->
                            </div><!-- .col -->
                        </div><!-- .row -->
                    </div><!-- .container -->
                </div><!-- .hero-content-overlay -->
            </div><!-- .hero-content-wrap -->
        </div><!-- .swiper-wrapper -->

        <div class="pagination-wrap position-absolute w-100">
            <div class="container">
                <div class="swiper-pagination"></div>
            </div><!-- .container -->
        </div><!-- .pagination-wrap -->

        <!-- Add Arrows -->
        <div class="swiper-button-next flex justify-content-center align-items-center">
            <span><svg viewBox="0 0 1792 1792" xmlns="http://www.w3.org/2000/svg"><path d="M1171 960q0 13-10 23l-466 466q-10 10-23 10t-23-10l-50-50q-10-10-10-23t10-23l393-393-393-393q-10-10-10-23t10-23l50-50q10-10 23-10t23 10l466 466q10 10 10 23z"/></svg></span>
        </div>

        <div class="swiper-button-prev flex justify-content-center align-items-center">
            <span><svg viewBox="0 0 1792 1792" xmlns="http://www.w3.org/2000/svg"><path d="M1203 544q0 13-10 23l-393 393 393 393q10 10 10 23t-10 23l-50 50q-10 10-23 10t-23-10l-466-466q-10-10-10-23t10-23l466-466q10-10 23-10t23 10l50 50q10 10 10 23z"/></svg></span>
        </div>
    </div><!-- .hero-slider -->
    <br><br><br>
<h1 align="center">Services </h1>
    <div class="home-page-icon-boxes">
        <div class="container">
            <div class="row">
                <div class="col-12 col-md-6 col-lg-4 mt-4 mt-lg-0">
                    <div class="icon-box ">
                        <figure class="d-flex justify-content-center">
                            <img src="images/hands-gray.png" alt="">
                            <img src="images/hands-white.png" alt="">
                        </figure>

                        <header class="entry-header">
                            <h3 class="entry-title">Savings Account</h3>
                        </header>

                        <div class="entry-content">
                            <p> We offer various schemes related to savings account opening at low  rates of account opening charge.</p>
                            <button type="button" class="btn btn-basic">Learn More</button>
                        </div>
                    </div>
                </div>

                <div class="col-12 col-md-6 col-lg-4 mt-4 mt-lg-0">
                    <div class="icon-box">
                        <figure class="d-flex justify-content-center">
                            <img src="images/donation-gray.png" alt="">
                            <img src="images/donation-white.png" alt="">
                        </figure>

                        <header class="entry-header">
                            <h3 class="entry-title">Fund Transfer</h3>
                        </header>

                        <div class="entry-content">
                            <p>Transfer funds using IMPS/RTGS modes of payment using our fast and secure fund transfer facility.</p>

                            <button type="button" class="btn btn-basic">Learn More</button>
                        </div>
                    </div>
                </div>

                <div class="col-12 col-md-6 col-lg-4 mt-4 mt-lg-0">
                    <div class="icon-box">
                        <figure class="d-flex justify-content-center">
                            <img src="images/charity-gray.png" alt="">
                            <img src="images/charity-white.png" alt="">
                        </figure>

                        <header class="entry-header">
                            <h3 class="entry-title">Account Statement</h3>
                        </header>

                        <div class="entry-content">
                            <p>View all of your transactions in a single page using the account statement feature.</p>
                            <button type="button" class="btn btn-basic">Learn More</button>
                        </div>
                    </div>
                </div>
            </div><!-- .row -->
        </div><!-- .container -->
    </div><!-- .home-page-icon-boxes -->

    <div class="home-page-welcome">
        <div class="container">
            <div class="row">
                <div class="col-12 col-lg-6 order-2 order-lg-1">
                    <div class="welcome-content">
                        <header class="entry-header">
                            <h2 class="entry-title">Welcome to  SBBI Bank</h2>
                        </header><!-- .entry-header -->

                        <div class="entry-content mt-5">
                            <p>SBBI Bank is India’s largest international bank with 100 branches in 43 cities, and we have been operating here since 1858. Key clients segments include Corporate & Institutional Banking, Commercial & Private Banking as well as Retail Banking. 

SBBI also has the following subsidiaries operating in India: SBBI Securities (India) Ltd; SBBI Private Equity Advisory (India) Private Limited; SBBI Investments and Loans (India) Limited; SBBI Finance limited and SBBI Global Business Services Pvt. Ltd. </p>
                        </div><!-- .entry-content -->

                        <div class="entry-footer mt-5">
                            <a href="#" class="btn gradient-bg mr-2">Read More</a>
                        </div><!-- .entry-footer -->
                    </div><!-- .welcome-content -->
                </div><!-- .col -->

                <div class="col-12 col-lg-6 mt-4 order-1 order-lg-2">
                    <img src="images/welcome.jfif" alt="welcome">
                </div><!-- .col -->
            </div><!-- .row -->
        </div><!-- .container -->
    </div><!-- .home-page-icon-boxes -->

    <br><br><br>
    <footer class="site-footer">
        <div class="footer-widgets">
            <div class="container">
                <div class="row">
                    <div class="col-12 col-md-6 col-lg-3">
                        <div class="foot-about">
                            <!--<h2><a class="foot-logo" href="#"><img src="images/foot-logo.png" alt=""></a></h2>-->

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
                        <h2>Useful Links</h2>

                        <ul>
                            <li><a href="#">Savings Account</a></li>
                            <li><a href="#">Credit Card</a></li>
                            <li><a href="#">Debit Card</a></li>
                            <li><a href="#">Download our App</a></li>
                            <li><a href="contact.html">Contact Us</a></li>
                            
                        </ul>
                    </div><!-- .col -->

                    <div class="col-12 col-md-6 col-lg-3 mt-5 mt-md-0">
                        <div class="foot-latest-news">
                            <h2>Media Center</h2>

                            <ul>
                                <li>
                                    <h3><a href="about.html">About Us</a></h3>
                                    
                                </li>

                                <li>
                                    <h3><a href="#">Careers </a></h3>
                                    
                                </li>

                                <li>
                                    <h3><a href="FAQ.html">FAQ's</a></h3>
                                    
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
                                <li><i class="fa fa-map-marker"></i><span>Main Street, Opp Hypercity Mall,Thane(West) Mumbai,Maharashtra</span></li>
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