<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Account Statement</h1>


<form action="AccountStatement">
From<input type="date" name="from">
To <input type="date" name="to">
<input type="submit" value="Get Account Statement">
</form>
<br><br>
<c:if test="${not empty AccountStatementList}">
    	<table border="1">
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
                    
             
          
       </tr>
     </c:forEach>
  </tbody>
</table>

	</c:if>

</body>
</html>