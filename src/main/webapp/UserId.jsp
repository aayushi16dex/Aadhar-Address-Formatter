<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
 
<meta name="viewport" content="width=device-width, initial-scale=1">
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
	background-image: linear-gradient(rgba(0,0,0,0.4),rgba(0,0,0,0.4)),url("https://media.istockphoto.com/vectors/tricolor-brush-stroke-vector-id1009448862?k=20&m=1009448862&s=612x612&w=0&h=eespJdPh6lWxgsxgkpc7Xa7w8BcnHaC9-h89EKUhk1Q=");
 	background-position: center;
 	background-size: cover;
	
 	position: absolute;
}

.form-box{
	width: 380px;
	height: 420px;
	position: relative;
	margin: 6% auto;
	background: white;
	padding: 5px;
	border-style: solid;
	border-color:#EC7063;
	border-width: 8px;
}

.input-group{
	top: 190px;
	margin-left: 5px;
	position: absolute;
	width: 280px;
	transition: .5s;
}
.input-field{
	width: 100%;
	padding: 10px 0;
	margin: 5px 25px;
	border-left: 0;
	border-top: 0;
	border-right: 0;
	border-bottom: 1px solid #999;
	outline: none;
	background: transparent;
	
}
 .submitbtn {
  background: linear-gradient(to right, #ff105f,#ffad06);
  color: black;
  font-size: 22px;
  padding: 10px 15px;
  margin-left: 65px;
  margin-top: 45px;
  cursor: pointer;
  width: 85%;
  border:0;
  border-radius: 30px;
  outline: none;
  
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

<title>User Detail</title>
</head>
<body>
<table>
 		<tr>
 			<td>
 				<img src = "https://hranker.com/blog/wp-content/uploads/2021/03/government-of-india.jpg" style = "float: left; width:160px;height:90px; margin-right:250px">
 			</td>
 			<td>
 				<h1 style = "font-size: 30px;margin-right: 120px;">UIDAI - Unique Identification Authority of India</h1>
 			</td>
 	  <td>
 				 <a href= "index.jsp" class = "button"><strong>Log out</strong></a>
 				 
 			</td> 
 			<td>
 				<img src = "https://theindiasaga.com/wp-content/uploads/2020/06/cat_politics183-750x400.png"style = "float: right; width:188px; height:90px; margin-left:70px">
 			</td>
 		</tr>
 	</table> 
<% 
	
%>
 
	<div class = "admin">
		<div class = "form-box">
				<h2 style="margin-left: 110px; margin-bottom: 1px;font-size: 30px"><u>User Detail</u></h2><br>
			 
				<img src = "https://images.assetsdelivery.com/compings_v2/salamatik/salamatik1801/salamatik180100019.jpg" style = "width: 140px;height: 100px;margin-left: 120px;"><br><br><br><br>
			 	<form class = "input-group" action = "UserIdServlet" method = "post">
			 		 
			 		<input type="text" class = "input-field" placeholder = "Enter registered number" name ="mob" minlength = "10" maxlength = "10" pattern="[0-9]*"required>
			 	  
			 		<br><input type="password" class = "input-field" placeholder = "Auto-Generated Unique User Id " name ="uid" minlength = "6" maxlength = "6" pattern="[0-9]*" required>
				    <button type="submit" class="submitbtn">Submit</button>
			 	</form>
		</div>
	</div>
	 
</body>
</html>