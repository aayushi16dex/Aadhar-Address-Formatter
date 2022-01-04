<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 
<meta name='viewport' content=\"width=device-width, initial-scale=1\">
<style>
body {
  overflow-x: hidden;
  overflow-y: hidden;
}
				
* {
  margin: 0;
  padding: 0;
}
.admin{
height: 100%;
width: 100%;
    background-image: linear-gradient(rgba(0,0,0,0.4),rgba(0,0,0,0.4)),url("https://t4.ftcdn.net/jpg/01/30/50/59/360_F_130505941_aHM5DQifhmVGcs80xVUPPMfDjg5BBm3c.jpg");
    background-position: center;
    background-size: cover;
    position: absolute;
}

.form-box{
	width: 380px;
	height: 400px;
	background-image: url("https://media.istockphoto.com/vectors/abstract-white-background-vector-id1142563796?k=20&m=1142563796&s=612x612&w=0&h=kZABOtzW6eQOMZvDuLHiNsh-mM_2o9slZKq6-GN6W64=");
	position: relative;
	margin: 6% auto;
	padding: 5px;
	border-style: solid;
	border-color:#F1C40F;
	border-width: 8px;
}

.button1 {
  background: linear-gradient(to right, #ff105f,#ffad06);
  border: none;
  color: white;
  cursor: pointer;
  padding: 14px 40px;
  text-align: center;
  display: inline-block;
  text-decoration: none;
  font-size: 25px;
  border-radius: 8px;
  transition-duration: 0.4s;
  width: 70%;
  margin-left: 60px;

}

.button2 {
  background: linear-gradient(to right, #ff105f,#ffad06);
  border: none;
  color: white;
  cursor: pointer;
  padding: 14px 40px;
  text-align: center;
  display: inline-block;
  text-decoration: none;
  font-size: 25px;
  border-radius: 8px;
  transition-duration: 0.4s;
  width: 70%;
  margin-left: 60px;

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
	<div class = 'admin'>
		<div class = 'form-box'>
				<h1 style= "margin-left: 110px;margin-bottom: 20px;font-size: 35px; margin-top: 20px;">User Menu</h1><br><br><br><br>
<% String aadharNo = request.getParameter("uadhar"); %>
<form action='UpdateLoginForm.jsp'>
<input type='hidden' name='uadhar' value="<%=aadharNo%>">
<input type='submit' class="button1" value='Format Address'>
</form><br><br><br>
 
<form action='UserViewServlet' method='post'>
<input type='hidden' name='uadhar' value='<%= aadharNo%>'>
<input type='submit' class='button2' value='View Address'>

</form><br><br><br>
	</div>
</div>

</body>
</html>
