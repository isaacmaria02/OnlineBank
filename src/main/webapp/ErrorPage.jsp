<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page isErrorPage = "true" %>
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



<html>
   <head>
   
   <style>
   .clear {
    clear: both;
}
   </style>
   
      <title>Show Error Page</title>
   </head>
   
   <body>
   
       
      <div class="clear"  id="notfound">
		<div class="notfound">
			<div class="notfound-404">
				<h1><span></span></h1>
			</div>
                           <center>   <h1>${pageContext.errorData.statusCode}</h1> </center>
			<center><h2>Oops! ${pageContext.exception}</h2>
			<p>${pageContext.errorData.requestURI}</p>
			<a  href="Login.jsp">Back to login page</a>
		</div>
	</div>

   </body>
</html>