   <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   

<!DOCTYPE html>
<html>
<head>
<%@ page import = "uidai.RetrieveDataUpdate" %>

<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: #FEF5E7;
  overflow-x: hidden;
}

* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

/* Add padding to containers */
.container {
  padding: 15px;
  background-color: white;
}
 
/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}
h1{
font-size: 50px;
font-family: Georgia;

}
/* Set a style for the submit button */
.submitbtn {
  background: linear-gradient(to right, #DC7633,#F9E79F);
  color: white;
  font-size: 30px;
  padding: 12px 16px;
  margin: 2px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.submitbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

.button {
  background: linear-gradient(to right,  #FAEBD7,rgb(255, 128, 64));
  border: none;
  color: black;
  border-radius: 9px;
  padding: 10px 24px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 13.5px;
  cursor: pointer;
  text-decoration: none;
}

</style>
<title>UIDAI</title>
</head>
<body>
<%
int timeout = 15;
HttpSession sessionObj = request.getSession(true);
sessionObj.setMaxInactiveInterval(timeout);
sessionObj.invalidate();
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Cache-Control","no-store");
response.setDateHeader("Expires", 0);
response.setHeader("Refresh", timeout + "; index.jsp");
%>

<% RetrieveDataUpdate rdb = new RetrieveDataUpdate();%>
<form action = "UpdateServlet" method = "post">
  <div class="container">
 <table>
 		<tr>
 			<td>
 				<img src = "https://hranker.com/blog/wp-content/uploads/2021/03/government-of-india.jpg" style = "float: left; width:200px;height:90px; margin-right:231px">
 			</td>
 			<td>
 				<h1 style = "font-size: 30px;margin-right: 130px;">UIDAI - Unique Identification Authority of India</h1>
 			</td>
 	    <td>
 				 <a href= "index.jsp" class = "button"><strong>Log out</strong></a>
 				 
 			</td> 
 			<td>
 				<img src = "https://theindiasaga.com/wp-content/uploads/2020/06/cat_politics183-750x400.png"style = "float: right; width:188px; height:90px; margin-left:120px">
 			</td>
 		</tr>
 	</table>
<p style= "color: white; text-align: center; font-size: 200%; background: linear-gradient(to right, #DC7633,#F9E79F); padding: 10px 14px;"><b>Address Details</b></p>
 
<p style = "color: red; background-color:#F0FFF0; font-size: 100%; padding: 8px 12px;"><marquee> <b>Note: All * are mandatory fields</b></marquee></p>
    
    <label for="aadhar number"><b>Aadhar number <span style="color: #ff0000">*</span></b></label>
    <%
   //get parameters from the request
   String uadharname = request.getParameter("uadhar");
	%>
   <input type="text" name="adhar" disabled value="<%=uadharname%>">
   <%out.println("<input type='hidden' name='uaadhar' value='"+uadharname+"'>"); %>
     	
    <% String hNo1 = rdb.selectHNo(uadharname); %> 		
    <label for="hNo"><b>House No</b></label>
    <input type="text" placeholder="Enter House no" name = "hNo" value="<%=hNo1 %>">

    <% String street1 = rdb.selectStreet(uadharname); %>
    <label for="street"><b>Street/Road/Lane</b></label>
    <input type="text" placeholder="Enter Street/Road/Lane no" name = "street" value="<%= street1%>">

    <% String area1 = rdb.selectArea(uadharname); %>
    <label for="area"><b>Area/Locality/Sector</b></label>
    <input type="text" placeholder="Enter Area/Locality/Sector" name = "area" value="<%=area1 %>">

    <% String landmark1 = rdb.selectLandmark(uadharname); %>
    <label for="lmark"><b>Landmark</b></label>
    <input type="text" placeholder="Enter Landmark" name = "landmark" value="<%= landmark1 %>">
    
     <% String town1 = rdb.selectTown(uadharname); %>
    <label for="vill"><b>Village/Town/City <span style="color: #ff0000">*</span></b></label>
    <input type="text" placeholder="Enter Village/Town/City" name = "town" required value="<%=town1 %>">
    
    <% String subDistrict1 = rdb.selectSubDistrict(uadharname); %>
    <label for="sd"><b>Sub-District <span style="color: #ff0000">*</span></b></label>
    <input type="text" placeholder="Enter Sub-District" name = "subDistrict" required value="<%= subDistrict1 %>">

    <% String district1 = rdb.selectDistrict(uadharname); %>
    <label for="dist"><b>District <span style="color: #ff0000">*</span></b></label>
    <input type="text" placeholder="Enter District" name = "district" required value="<%=district1 %>">
 
    <% String state1 = rdb.selectState(uadharname); %>   
    <label for="state"><b>State <span style="color: #ff0000">*</span></b></label><br>
    <select style="min-height:40px;min-width:100px;" id="state" name="state" required value="<%= state1 %>">
      <option>State/ Union Territory</option>
      <option>Andaman and Nicobar Islands</option>
      <option>Andhra Pradesh</option>
      <option>Arunachal Pradesh</option>
      <option>Assam</option>
      <option>Bihar</option>
      <option>Chandigarh</option>
      <option>Chhattisgarh</option>
      <option>Dadra & Nagar Haveli and Daman & Diu</option>
      <option>Delhi</option>
      <option>Goa</option>
      <option>Gujarat</option>
      <option>Haryana</option>
      <option>Himachal Pradesh</option>
      <option>Jammu and Kashmir</option>
      <option>Jharkhand</option>
      <option>Karnataka</option>
      <option>Kerala</option>
      <option>Ladakh</option>
      <option>Lakshadweep</option>
      <option>Madhya Pradesh</option>
      <option>Maharashtra</option>
      <option>Manipur</option>
      <option>Meghalaya</option>
      <option>Mizoram</option>
      <option>Nagaland</option>
      <option>Odisha</option>
      <option>Puducherry</option>
      <option>Punjab</option>
      <option>Rajasthan</option>
      <option>Sikkim</option>
      <option>Tamil Nadu</option>
      <option>Telangana</option>
      <option>Tripura</option>
      <option>Uttar Pradesh</option>
      <option>Uttarakhand</option>
      <option>West Bengal</option>
    </select>
    <br><br>

    <% String pin1 = rdb.selectPin(uadharname); %>
    <label for="pin"><b>Pincode <span style="color: #ff0000">*</span></b></label>
    <input type="text" placeholder="Enter pincode" name = "pincode" minlength = "6" maxlength = "6" pattern = "[0-9]*"  value="<%=pin1 %>" required>
    <hr>
     
    <button type="submit" class="submitbtn">Submit</button>
  </div>
  
</form>
</body>
</html>