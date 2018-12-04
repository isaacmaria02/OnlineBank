<%@ page errorPage="ErrorPage.jsp" %>  


<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
if(session!=null)
{
	if(session.getAttribute("isLoggedIn")==null)
	{
		
		response.sendRedirect("index.jsp");
	}
}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

  <head>
  <title>
  Dashboard
  </title>
  <style type="text/css">
	.pull{

		margin-left:5px;
  width:100%;
	}

</style>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script>
            $(document).ready(function(){
              $("#searchPayee").on("keyup", function() {
                var value = $(this).val().toLowerCase();
                $("#payeeListTable tr").filter(function() {
                  $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
              });
              
              $("#transfer").click(function(){
            	  $('.hidden').show();
                  $('#transfer').hide();                                    
                  $('.readonly').prop('disabled', true)        	  
              });                            
              $("#backbtn").click(function(){
            	  $('.hidden').hide();
                  $('#transfer').show();                          
                  $('.readonly').prop('disabled', false) 
        });
 
              $('#fundtransfer').on('submit', function() {
            	    $('.readonly').prop('disabled', false);
            	});
            });
        </script>


    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script>
            $(document).ready(function(){
              $("#searchPayee").on("keyup", function() {
                var value = $(this).val().toLowerCase();
                $("#payeeListTable tr").filter(function() {
                  $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
              });
   });
       </script>
       <script>
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
       function ValidateUserId(){
		var userId = document.getElementById("UserId").value;
		var conUserId = document.getElementById("ConUserId").value;
			if(userId != conUserId){
		alert ("User Id's do not match.");
		return false;
		}
		return true;
		}	
</script>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Dashboard</title>

    <!-- Bootstrap core CSS-->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="custombutton.css">
    
    <style>
#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#customers td, #customers th {
    border: 1px solid #ddd;
    padding: 8px;
}

#customers tr:nth-child(even){background-color:#f2f2f2;}

#customers tr:hover {background-color: #ccffe6;}

#customers th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #0099ff;
    color: white;
}
</style>

  </head>

  <body id="page-top">

    <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

      <a class="navbar-brand mr-1" href="index.html"> SBBI Bank</a> <img src="images.png" width=3% height=3%>

      <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
        <i class="fas fa-bars"></i>
      </button>
<div class="pull">
        <ul class="nav navbar-nav pull-right float-right">
            <li><a href="logout" class="btn btn-outline-light	pull-right">Logout  <span class="glyphicon glyphicon-off"></span></a></li>
        </ul>     
         
</div>
    </nav>

    <div id="wrapper">

      <!-- Sidebar -->
      <ul class="sidebar navbar-nav">
        <li class="nav-item active">
          <a class="nav-link" href="summary">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Account Summary</span>
          </a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="accountStatementPage"  role="button"  aria-haspopup="true" aria-expanded="false">
 
            <span>Account Statement</span>
          </a>
       <!--    <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <h6 class="dropdown-header">Login Screens:</h6>
            <a class="dropdown-item" href="login.html">Login</a>
            <a class="dropdown-item" href="register.html">Register</a>
            <a class="dropdown-item" href="forgot-password.html">Forgot Password</a>
            <div class="dropdown-divider"></div>
            <h6 class="dropdown-header">Other Pages:</h6>
            <a class="dropdown-item" href="404.html">404 Page</a>
            <a class="dropdown-item" href="blank.html">Blank Page</a>
          </div> -->
        </li>
        <li class="nav-item">
          <a class="nav-link" href="FundTransfer">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Fund Transfer</span></a>
        </li>
        <br><br>
         <!-- <li class="nav-item">
          <a class="nav-link" href="logout">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Logout</span></a>
        </li> -->
              </ul>

      <div id="content-wrapper">

        <div class="container-fluid">

          <!-- Breadcrumbs-->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="#">Dashboard</a>
            </li>
            
          </ol>

          <!-- Icon Cards-->
          <div class="row">
            <div class="col-xl-4 col-lg-6 mb-3">
              <div class="card text-white bg-primary o-hidden h-10">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-comments"></i>
                  </div>
                  <div class="mr-5">User Profile</div>
                </div>
                
              </div>

<!-- .dropright -->
<div class="btn-group dropdown">
   <button class="btn btn-primary dropdown-toggle dropdown-toggle-split"
      type="button"
      id="dropdownMenuButton" data-toggle="dropdown"
      aria-haspopup="true" aria-expanded="false">
   View Details
   </button>
   <div class="dropdown-menu">
      <a class="dropdown-item" href="details">Account Details</a>
      <div class="dropdown-divider"></div>
      <a class="dropdown-item" href="accountStatementPage">Account Statement</a>
 <div class="dropdown-divider"></div>
      <a class="dropdown-item" href="summary">Account Summary</a>
      
   </div>
</div>
            </div>
            <div class="col-xl-4 col-sm-6 mb-3">
              <div class="card text-white bg-warning o-hidden h-10">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-list"></i>
                  </div>
                  <div class="mr-5">Fund Transfer</div>
                </div>             
              </div>

<!-- .dropright -->
<div class="btn-group dropdown">
   <button class="btn btn-primary dropdown-toggle dropdown-toggle-split"
      type="button"
      id="dropdownMenuButton" data-toggle="dropdown"
      aria-haspopup="true" aria-expanded="false">
   View Details
   </button>
   <div class="dropdown-menu">
      <a class="dropdown-item" href="addPayeePage">Add Payee</a>
      <div class="dropdown-divider"></div>
      <a class="dropdown-item" href="deletePayeePage">Delete Payee</a>
          <a class="dropdown-item" href="DisplayPayee">Display Payee</a>
   
   </div>
</div>
            </div>
            <div class="col-xl-4 col-sm-6 mb-3">
              <div class="card text-white bg-success o-hidden h-10">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-shopping-cart"></i>
                  </div>
                  <div class="mr-5">Manage Account</div>
                </div>
          
              </div>
<!-- .dropright -->
<div class="btn-group dropdown">
   <button class="btn btn-primary dropdown-toggle dropdown-toggle-split "
      type="button"
      id="dropdownMenuButton" data-toggle="dropdown"
      aria-haspopup="true" aria-expanded="true">
   View Details
   </button>
   <div class="dropdown-menu">
      <a class="dropdown-item" href="changeIdPage">Change User ID</a>
      <div class="dropdown-divider"></div>
      <a class="dropdown-item" href="changePasswordPage">Change Login Password</a>
<div class="dropdown-divider"></div>
      <a class="dropdown-item" href="changeTransactionPasswordPage">Change Transaction Password</a>
   </div>
</div>
            </div>
            <c:if test="${not empty DisplayPayeeView}">
            <div align="center">
                <br><br>
        <h3>Search</h3>   <input class="form-control" id="searchPayee" type="text" placeholder="Search..">
       <br><br> <div >
                <table id="customers" border="1" id="">
                    <thead>
                        <tr>
                            <th>Account Number</th>
                            <th>Payee Name</th>
                            <th>Payee Nick Name</th>
                        </tr>
                    </thead>
                    <tbody id="payeeListTable">
                        <c:forEach items="${PayeeList}" var="payee">
                            <tr>
                                <td>${payee.getPayee_account_number()}</td>
                                <td>${payee.getName()}</td>
                                <td>${payee.getNick_name()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                </div>
            </c:if>
        </div>
            ${transaction}
            ${payee_status}            
            ${changeId }
            ${changePassword}
            ${changeTransactionPassword }
            ${fundTransfer }
            <c:if test="${not empty AddPayeeView}">
                            
                <div align="center">
                             <h3>Add Payee</h3>
                
         <form action="addPayee" >
         <table>
            <input style="display:none;" type="number" value="${account_number}" name="customer_account_number">
             <tr><td>Payee Account Number : </td><td><input type="number" pattern="[1]{1}[0-9]{11}" max="12" name="payee_account_number"></td><tr>
            <tr><td>Name :</td><td> <input type="text" name="name" pattern="[A-Za-z A-Za-z]+"></td></tr>
            <tr><td>NickName: </td><td><input type="text" name="nick_name" pattern=[A-Za-z]+></td></tr>
            <tr><td colspan="2"><input value="Add Payee" class="btn btn-primary dropdown-toggle dropdown-toggle-split"  type="submit"></td></tr>
       </table>
        </form>
            </div>
            </c:if>
             <c:if test="${not empty DeletePayeeView}">
                            <div align="center">
            
             <h3>Delete Payee</h3>
        <form action="DeletePayee">
        <table>
         <tr><td>Delete Payee by Name</td><td> <input type="text" name="payee_name"></td></tr>
                         
            <tr><td colspan="2"><input value="Delete Payee" class="btn btn-primary dropdown-toggle dropdown-toggle-split"  type="submit"></td><tr>
        </table>
        </form>
            </div>
            
            </c:if>
             <c:if test="${not empty ChangeIdView}">
                            <div align="center">
                            
                            <h3>Change User Id</h3>
            <table>
          <form action="checkId" method="post">
<tr><td>Old ID</td><td><input type="text" name="old" pattern="[A-Za-z0-9]+"></td></tr>
<tr><td>New User ID</td><td><input type="text" name="new" pattern="[A-Za-z0-9]+" id="UserId"></td></tr>
<tr><td>Confirm User ID</td><td><input type="text" name="confirm" pattern="[A-Za-z0-9]" id="ConUserId" onblur="ValidateUserId()"></td></tr>
<tr><td colspan="2"><input type="submit" class="btn btn-primary dropdown-toggle dropdown-toggle-split" value="Change User Id"></td></tr>
</form>

</table>
${changeId }          
            </div>
            
            </c:if>
               <c:if test="${not empty ChangePasswordView}">
                            <div align="center">
                            
                            <h3>Change Password</h3>
           <table>
              <form action="checkPassword" method="post" onsubmit="return Validate()">
<tr><td>Old Password</td><td><input type="password" name="old"></td></tr>
<tr><td>New Login Password</td><td><input type="password" name="new" id="Password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Password must contain at least one number,one uppercase letter and one lowercase letter, and at least 8 or more characters" placeholder="Enter new password" required></td></tr>
<tr><td>Confirm Login Password</td><td><input type="password" id="ConfirmPassword" name="confirm"></td></tr>
<tr><td colspan="2"><input type="submit" class="btn btn-primary dropdown-toggle dropdown-toggle-split" value="Change Password"></td></tr>
</form>
</table>
${changePassword }
            </div>
            
            </c:if>
               <c:if test="${not empty ChangeTransactionPasswordView}">
                            <div align="center">
                            
                            <h3>Change Transaction Password</h3>
           <table>
              <form action="checkTransactionPassword" method="post">
<tr><td>Old Transaction Password</td><td><input type="password" name="old"></td></tr>
<tr><td>New Transaction Password</td><td><input type="password" id="TransactionPass" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Password must contain at least one number,one uppercase letter and one lowercase letter, and at least 8 or more characters" ></td></tr>
<tr><td>Confirm Transaction Password</td><td><input type="password" name="confirm" id="ConTransactionPass" onblur="return ValidateTran()"></td></tr>
<tr><td colspan="2"><input type="submit" class="btn btn-primary dropdown-toggle dropdown-toggle-split" value="Change Password"></td></tr>
</form>
</table>
${changeTransactionPassword }
            </div>           
            </c:if>
 <c:if test="${not empty AccountStatementView}">
                            <div align="center">
                            
                         <h3>Account Statement</h3>
        <br><div>
        <form action="AccountStatement">
            From<input id="fromDate"  type="date" name="from" value="2018-01-06">
            To <input id="toDate"  type="date" name="to" value="2018-01-06"><br><br>
            <input type="submit" value="Get Account Statement" class="btn btn-primary dropdown-toggle dropdown-toggle-split">

            <!-- <input type="submit" value="Get Account Statement"><br> -->
        </form>
           </div>
        <br><br>
                    </div>
            
            </c:if>
         <c:if test="${not empty AccountStatementList}">
           
<div align="center">
                            
                         <h3>Account Statement</h3>
        <br><div>
        <form action="AccountStatement">
            From<input id="fromDate" value="2018-12-06" type="date" name="from">
            To <input id="toDate"  value="2018-12-06" type="date" name="to"><br><br>
            <input type="submit" value="Get Account Statement" class="btn btn-primary dropdown-toggle dropdown-toggle-split">

            <!-- <input type="submit" value="Get Account Statement"><br> -->
        </form>
           </div><br>

            <table id="customers" border="1">
                <thead>
                    <tr>
                        <th>Reference ID</th>
                        <th>Transaction Type</th>
                        <th>Amount</th>
                        <th>From Account</th>
                        <th>To Account</th>
                        <th>Date</th>
                        <th>Remark</th>
                        <th>Transaction Charges</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${AccountStatementList}" var="record">
                        <tr>
                            <td>${record.reference_id }</td>
                            <td>${record.type }</td>
                            <td>${record.amount }</td>
                            <td>${record.from_account }</td>
                            <td>${record.to_account }</td>
                            <td>${record.timestamp }</td>
                            <td>${record.remark }</td>
                            <td>${record.charges }</td>
                            <td>${record.status }</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            
               <a class="btn btn-primary"  href="download">Download</a>
        
        </c:if>
 <c:if test="${not empty statement}">
            
              <div align="center">
  <h3>Account Statement</h3>
        <br><div>
        <form action="AccountStatement">
            From<input value="2018-12-06" id="fromDate" type="date" name="from">
            To <input value="2018-12-06" id="toDate" type="date" name="to"><br><br>
            <input type="submit" value="Get Account Statement" class="btn btn-primary dropdown-toggle dropdown-toggle-split">

            <!-- <input type="submit" value="Get Account Statement"><br> -->
        </form>
           </div><br>
           
              ${statement}
           
     </div>
</c:if>
  <c:if test="${not empty AccountSummaryView}">
            
              <div align="center">
  <h3>Account Summary</h3>
        <br><div>
        
        <table id="customers">
            <tr>
              <td>Customer ID</td>
               <td>${summary.customer_id}</td>
            </tr>
   <tr>
             <td>  Account Number</td>
                <td>${summary.account_number}</td>
            </tr>
            
              <tr>
               <td>Balance</td>
               <td>${summary.balance}</td>
            </tr>
   <tr>
               <td>Type</td>
               <td>${summary.account_type}</td>
            </tr>       
            </table>
 </div><br>
  </div>
</c:if>
 <c:if test="${not empty AccountDetailsView}">
            
              <div align="center">
  <h3>Account Details</h3>
        <br><div>
        
           <table id="customers" >
            <th colspan="2">Personal Details</th>
            <tr>
              <td>Name</td>
               <td>${user_profile.first_name} ${user_profile.middle_name} ${user_profile.last_name}</td>
            </tr>
              <tr>
              <td>Father's Name</td>
               <td>${user_profile.father_name}</td>
            </tr>  <tr>
              <td>Email ID</td>
               <td>${user_profile.email_id}</td>
            </tr>  <tr>
              <td>Mobile Number</td>
               <td>${user_profile.mobile_number}</td>
            </tr><tr>
              <td>Aadhar Card Number</td>
               <td>${user_profile.aadhar_card}</td>
            </tr>       
            <tr>
              <td>Date of Birth</td>
               <td>${user_profile.date_of_birth}</td>
            </tr>    
            <tr>
              <td>Address</td>
               <td>${user_profile.address_line_1}, ${user_profile.address_line_2}</td>
            </tr> <tr>
              <td>Pincode</td>
               <td>${user_profile.pin_code}</td>
            </tr>  
             <tr>
              <td>City</td>
               <td>${user_profile.city}</td>
            </tr>  <tr>
              <td>State</td>
               <td>${user_profile.state}</td>
            </tr>       
     
            </table>   
            
            <br><br>
            
            <table style="margin-top:30px;" id="customers" >
            <th colspan="2">Account Details</th>
           <tr>
              <td>Customer ID</td>
               <td>${user_profile.customer_id}</td>
            </tr>
                        
              <tr>
             <td>  Account Number</td>
                <td>${user_profile.account_number}</td>
            </tr>
            
              <tr>
               <td>Balance</td>
               <td>${user_profile.balance}</td>
            </tr>                 
              <tr>
               <td>Type</td>
               <td>${user_profile.account_type}</td>
            </tr>       
            </table>
           </div><br>
     </div>
</c:if>
 <c:if test="${not empty FundTransferView}">
            
              <div align="center">
 
  <div ng-app="app">
  
   <div ng-controller="TimeController">
   
   <script>
   function validateForm() {

   var amount = document.forms["fundTrans"]["amount"].value;
   var type = document.forms["fundTrans"]["type"].value;
  
   if(type == "IMPS")
	   {
	       if(amount<100000)
	    	   {
	    	      return true;
	    	   }
	       else
	    	   {
	    	   alert('Amount must be less than one lakh');
	    	   return false;
	    	   }
	   }
   else if (type=="RTGS")
	   {
	       if(amount>200000)
	    	   {
	    	      return true;
	    	   }
	       else
	    	   {
	    	   alert('Amount must be greater than two lakhs');
	    	   return false;
	    	   }
	   }
   
   }
   </script>
    
    <div>
  <table>
         <form id="fundtransfer" name="fundTrans" action="ConfirmPayment" onsubmit="return validateForm()">
        <tr><td>Select Payee :</td>
            <td><select class="readonly" name="payee_name" required >
                <c:forEach items="${PayeeList}" var="payee">
                    <option value="${payee.getName()}">${payee.getName()}</option>
                </c:forEach>
            </select>
            </td></tr>
            <tr><td>Transaction Type :</td>   
            <td><select class="readonly" name="type" ng-change="update_values()" ng-model="selected" required>
                  <option value="IMPS">IMPS</option>
                   <option value="RTGS">RTGS</option>
                  
            </select>
            </td></tr>
            <tr><td>Amount : </td><td>  <input id ="amt" class="readonly" type="number"  min="1"  required  name="amount" oninput="validity.valid||(value='');">
            </td></tr>
                  <tr><td colspan="2"><span>Please enter amount between {{min}} and {{max}}</span></td></tr>
            
            <tr><td>Remarks (Optional) : </td><td><input class="readonly" type="text" name="remark"></td></tr>
            
           <tr><td colspan="2"><input class="btn btn-primary dropdown-toggle dropdown-toggle-split" id="transfer" type="button" value="Transfer"></td></tr>
            <tr><td colspan="2"><p style="display:none;" class="hidden">Enter Transaction Password</p></td><tr>
            <tr><td colspan="2"><input style="display:none;" type="password" class="hidden" name="transactionPassword" title="Please enter transaction password" required></td></tr>
            <tr><td colspan="2"><input id="backbtn" class="hidden btn btn-primary dropdown-toggle dropdown-toggle-split" style="display:none;" type="button" value="Back">
            <input id="submitbtn" class="hidden btn btn-primary dropdown-toggle dropdown-toggle-split" style="display:none;" type="submit" value="Confirm"></td></tr>            
            
        </form>
            </table>
            
            <script>
            var app = angular.module('app', []);
            app.controller('TimeController', function($scope) {

              var vm = $scope;
              
              vm.update_values = function() {
                  if(vm.selected === 'IMPS') {
                     vm.min = "1";
                     vm.max = "100000";
                  } else if(vm.selected === 'RTGS') {
                     vm.min = "100001";
                     vm.max = "1000000";
                  } 
               }
            });
  </script>
  
</div>

 </div>
</c:if>

        <!-- /.container-fluid -->

        <!-- Sticky Footer -->
        <footer class="sticky-footer">
          <div class="container my-auto">
            <div class="copyright text-center my-auto">
              <span>Copyright ©  SBBI Bank</span>
            </div>
          </div>
        </footer>

      </div>
      <!-- /.content-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <a class="btn btn-primary" href="login.html">Logout</a>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Page level plugin JavaScript-->
    <script src="vendor/chart.js/Chart.min.js"></script>
    <script src="vendor/datatables/jquery.dataTables.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin.min.js"></script>

    <!-- Demo scripts for this page-->
    <script src="js/demo/datatables-demo.js"></script>
    <script src="js/demo/chart-area-demo.js"></script>
    
  </body>
</html>
