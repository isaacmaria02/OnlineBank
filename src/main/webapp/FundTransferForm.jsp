 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
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
        <meta charset="ISO-8859-1">
        <title>Insert title here</title>
    </head>
    <body>
        <form id="fundtransfer" action="ConfirmPayment">
            Select Payee : 
            <select class="readonly" name="payee_name">
                <c:forEach items="${PayeeList}" var="payee">
                    <option value="${payee.getName()}">${payee.getName()}</option>
                </c:forEach>
            </select>
            <br>
            Transaction Type :   
            <select class="readonly" name="type">
                <option value="IMPS">IMPS</option>
                <option value="RTGS">RTGS</option>
            </select>
            <br>
            Amount :   <input class="readonly" type="number" name="amount">
            <br>
            Remarks (Optional) : <input class="readonly" type="text" name="remark">
            <br>
            <input id="transfer" type="button" value="Transfer">
            <input id="backbtn" class="hidden" style="display:none;" type="button" value="Back">
            <input id="submitbtn" class="hidden" style="display:none;" type="submit" value="Confirm">
        </form>
    </body>
</html> 


