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



<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  

   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
   <html lang="en">

  <head>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<link rel="stylesheet" href="css/bootstrap-theme.min.css">

<script src="js/bootstrap.min.js" ></script>


<script  src="js/jquery-3.3.1.min.js" ></script>

<script src="bootstable.min.js"></script>

</head>
<body>



<div style="width:70%; margin: auto;">
<a href="adminlogout" class="nav navbar-nav navbar-right btn btn-primary" >Logout</a>

<h1>Welcome to Admin Portal</h1>  
<br><br>
<table class=" table-striped table-dark table table-responsive table-hover  table-bordered text-center" id="makeEditable">
    <thead class="bg-primary">
    <tr><th>Customer ID</th><th>Full Name</th><th>Email ID</th><th>Mobile Numer</th><th>Date of Birth</th><th colspan="2">Action</th></tr>  

    </thead >
    <tbody>
       <c:forEach var="request" items="${requests}">       
      <tr class="info">
       <td>${request.customer_id}</td>  
   <td>${request.first_name} ${request.middle_name} ${request.last_name}</td>  
   <td>${request.email_id}</td>  
   <td>${request.mobile_number }</td>  
   <td>${request.date_of_birth }</td>  
   <td><a  class="btn btn-success" href="approve/${request.customer_id}">Approve<span class="glyphicon glyphicon-ok-circle"></span></a></td>  
   <td><a class="btn btn-danger" href="reject/${request.customer_id}">Reject<span class="glyphicon glyphicon-remove-circle"></span></button></a></td>  
              <td><a class="btn btn-danger" href="show/${request.customer_id}">Show<span class="glyphicon glyphicon-remove-circle"></span></button></a></td>  
            
      </tr> 
   </c:forEach>  

  
    </tbody>
  </table>
</div>

</body>
</html>


   
