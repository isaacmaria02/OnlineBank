<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Account Opening Request</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Customer ID</th><th>Full Name</th><th>Email ID</th><th>Mobile Numer</th><th>Date of Birth</th><th>Approve</th><th>Reject</th></tr>  
   <c:forEach var="request" items="${requests}">   
   <tr>  
   <td>${request.customer_id}</td>  
   <td>${request.first_name} ${request.middle_name} ${request.last_name}</td>  
   <td>${request.email_id}</td>  
   <td>${request.mobile_number }</td>  
   <td>${request.date_of_birth }</td>  
   <td><a href="approve/${request.customer_id}">Approve</a></td>  
   <td><a href="reject/${request.customer_id}">Reject</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
