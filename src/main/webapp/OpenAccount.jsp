<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form action="open" method="post">
  <div class="container">
    <h1>Open a savings account</h1>
    <p>Personal details</p>
    <hr>

<!--     <label for="Title"><b>Title</b></label>
    <input type="text" placeholder="Enter title" name="Title" required> -->

  <label for="First Name"><b>First Name</b></label>
    <input type="text" placeholder="Enter First Name" name="first_name" required><br>

    <label for="Middle Name"><b>Middle Name</b></label>
    <input type="text" placeholder="Enter Middle Name" name="middle_name" required><br>

<label for="Last Name"><b>Last Name</b></label>
    <input type="text" placeholder="Enter Last Name" name="last_name" required><br>

<label for="Father's Name"><b>Father's Name</b></label>
    <input type="text" placeholder="Enter Father's Name" name="father_name" required><br>

<label for="Email Id"><b>Email Id</b></label>
    <input type="text" placeholder="Enter email Id" name="email_id" required> <br>

 <label for="Mobile No"><b>Mobile Number</b></label>
    <input type="number" placeholder="Enter Mobile Number" name="mobile_number" required><br><br>

<label for="Aadhar Card No"><b>Aadhar Card No</b></label>
    <input type="number" placeholder="Enter Aadhar No" name="aadhar_card" required><br><br>
 

<label for="Date Of Birth"><b>Date Of Birth</b></label>
    <input type="date"  name="date_of_birth" ><br>
    
    <label for="Annual_Income"><b>Annual Income</b></label>
    <input type="number"  name="annual_income" required><br><br>
 



  <p>Address</p>
  <label for="Address Line 1"><b>Address Line 1</b></label>
    <input type="text"  name="address_line_1" required><br><br>
<label for="Address Line 2"><b>Address Line 1</b></label>
    <input type="text"  name="address_line_2" required><br><br>




<label for="City"><b>City</b></label>
    <input type="text"  name="city" required><br><br>

<label for="State"><b>State</b></label>
   <select name="state">
        <option value="select">select</option>
        <option value="Andhra Pradesh">Andhra Pradesh</option>
        <option value="Arunachal Pradesh">Arunachal Pradesh</option>
        <option value="Assam">Assam</option>
        <option value="Bihar">Bihar</option>
        <option value="Chattisgarh">Chattisgarh</option>
        <option value="Goa">Goa</option>
        <option value="Gujrat">Gujrat</option>
        <option value="Haryana">Haryana</option>
 <option value="Himachal Pradesh">Himachal Pradesh</option>
        <option value="Jammu & Kashmir">Jammu & Kashmir</option>
        <option value="Jharkhand">Jharkhand</option>
        <option value="Karnatka">Karnatka</option>
<option value="Kerala">Kerala</option>
        <option value="Madhya Pradesh">Madhya Pradesh</option>
        <option value="Maharashtra">Maharashtra</option>
        <option value="Manipur">Manipur</option>
<option value="Meghalaya">Meghalaya</option>
        <option value="Mizoram">Mizoram</option>
        <option value="Nagaland">Nagaland</option>
        <option value="Orissa">Orissa</option>
<option value="Punjab">Punjab</option>
        <option value="Rajasthan">Rajasthan</option>
        <option value="Sikkim">Sikkim</option>
        <option value="Tamil Nadu">Tamil Nadu</option>
<option value="Telangana">Telangana</option>
        <option value="Tripura">Tripura</option>
        <option value="Uttarakhand">Uttarakhand</option>
        <option value="Uttar Pradesh">Uttar Pradesh</option>
<option value="West Bengal">West Bengal</option> <br> <br>

        

      </select><br><br>
<label for="Pincode"><b>Pincode</b></label>
    <input type="number"  name="pin_code" required><br><br>
  <p1>Debit/ATM Card</p1><br> <br>
  <p2>Do you want a debit card ?</p>
<input type="checkbox" name="Net Banking" value="Net banking">Opt for Net Banking<br>
<input type="checkbox" name="Agree" value="Agree">I agree<br>
   
    <hr>
    <p>By creating an account you agree to our terms and conditions.</p>

    <input type="submit" class="registerbtn" value="Register">
  </div>
  </form>
</body>
</html>