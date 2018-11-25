<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello User</h1>

<a href="AddPayee.jsp">Add Payee</a><br>
<a href="DeletePayee.jsp">Delete Payee</a><br> <p>${msg}</p>

<a id="display_button" href="DisplayPayee">Display</a>

</form>

<br><br>
Search   <input class="form-control" id="searchPayee" type="text" placeholder="Search..">


<div >
<c:if test="${not empty PayeeList}">
    	<table border="1" id="">
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

	</c:if>


</div>

<%-- <select>
        <c:forEach items="${PayeeList}" var="payee">
   
        <option value="${payee.getName()}">${payee.getName()}</option>
     </c:forEach>
        
      </select> --%>

<a href="FundTransfer">Initiate a Fund Transfer</a>

<br><br>

<a href="">User Profile</a><br>
<a href="">Account Summary</a><br>
<a href="">Account Statement</a><br>

</body>
</html>