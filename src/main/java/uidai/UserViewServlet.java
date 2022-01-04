package uidai;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserViewServlet
 */
public class UserViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String number = request.getParameter("uadhar");
		PrintWriter out = response.getWriter();
		 
		UserDatabase database = new UserDatabase();
		
		try 
		{
			if (database.getConnection() != null) //This loop is only executed if connection is established properly
			{

				String fadd = database.selectAddress(number);  //Returns formatted address
				
				if(fadd!=null)    //Prints the formatted address alongwith aadhar number
				{
					out.println("<html>"
							+"<head>"
							 
							+"<style>"
							+ "body {\r\n"
							+ "  overflow-x: hidden;\r\n"
							+ "  overflow-y: hidden;\r\n"
							+ "}\r\n"
							+ "\r\n"
							+ "* {\r\n"
							+ "  margin: 0;\r\n"
							+ "  padding: 0;\r\n"
							+ "}\r\n"
							+ ".admin{\r\n"
							+ "	height: 100%;\r\n"
							+ "	width: 100%;\r\n"
							+ "	background-image: linear-gradient(rgba(0,0,0,0.4),rgba(0,0,0,0.4)),url(\"https://t4.ftcdn.net/jpg/01/30/50/59/360_F_130505941_aHM5DQifhmVGcs80xVUPPMfDjg5BBm3c.jpg\");\r\n"
							+ " 	background-position: center;\r\n"
							+ " 	background-size: cover;\r\n"
							+ " 	position: absolute;\r\n"
							+ "}\r\n"
							+ ".form-box{\r\n"
							+ "	width: 35%;\r\n"
							+ "	height: 295px;\r\n"
							+ "	position: relative;\r\n"
							+ "	margin-left: 35%;\r\n"
							+ "	margin-right: 50%;\r\n"
							+ "	margin-top: 6%;\r\n"
							+ "	background: linear-gradient(to right, #FFDAB9,  #FFE4E1);"
							+"font-family: \"Times New Roman\", Times, serif;\r\n"
							+ "	font-size: 12px;"
							 
							+ "	border-style: solid;\r\n"
							+ "	border-color: #FF7F50;\r\n"
							+ "	border-width: 6px;\r\n"
							+ "}\r\n"
							+ ".input-field{\r\n"
							+ "	width: 100%;\r\n"
							+ "	padding: 7px 0;\r\n"
							+"  font-size: 14px;"
							+ "	border-left: 0;\r\n"
							+ "	border-top: 0;\r\n"
							+ "	border-right: 0;\r\n"
							+ "	border-bottom: 1px solid #999;\r\n"
							+ "	outline: none;\r\n"
							+ "	background: transparent;\r\n"
							+ "	\r\n"
							+ "}\r\n"
							+".button {\r\n"
							+ "  background: linear-gradient(to right,  #FAEBD7,rgb(255, 128, 64));"
							+ "  border: none;\r\n"
							+ "  color: black;\r\n"
							+ "  border-radius: 9px;\r\n"
							+ "  padding: 10px 24px;\r\n"
							+ "  text-align: center;\r\n"
							+ "  text-decoration: none;\r\n"
							+ "  display: inline-block;\r\n"
							+ "  font-size: 13.5px;\r\n"
							+ "  cursor: pointer;\r\n"
							+ "  text-decoration: none;\r\n"
							+ "}"
							+".h5{\r\n"
							+ "  background-color: #FFFFFF; /* Green */\r\n"
							+ "  border: 1px solid;\r\n"
							+ "  color: black;\r\n"
							//+ "  margin-left: 696px;\r\n"
							+ "  padding: 10px 20px;;\r\n"
							+ "  text-align: center;\r\n"
							+ "  text-decoration: none;\r\n"
							+ "  display: inline-block;\r\n"
							+ "  font-size: 14px;\r\n"
							+ "  border-radius: 9px;\r\n"
							+ "  cursor: pointer;\r\n"
							+ "}"
							+ "</style>"
							+"<title>"
							+"Address"
							+"</title>"
							+"</head>"
							+"<body id = \"body\">"
							+"<table>\r\n"
							+ " 		<tr>\r\n"
							+ " 			<td>\r\n"
							+ " 				<img src = \"https://hranker.com/blog/wp-content/uploads/2021/03/government-of-india.jpg\" style = \"float: left; width:160px;height:90px; margin-right:250px\">\r\n"
							+ " 			</td>\r\n"
							+ " 			<td>\r\n"
							+ " 				<h1 style = \"font-size: 30px;margin-right: 120px;\">UIDAI - Unique Identification Authority of India</h1>\r\n"
							+ " 			</td>\r\n"
							+ " 	  <td>\r\n"
							+ " 				 <a href= \"index.jsp\" class = \"button\"><strong>Log out</strong></a>\r\n"
							+ " 				 \r\n"
							+ " 			</td> \r\n"
							+ " 			<td>\r\n"
							+ " 				<img src = \"https://theindiasaga.com/wp-content/uploads/2020/06/cat_politics183-750x400.png\"style = \"float: right; width:188px; height:90px; margin-left:70px\">\r\n"
							+ " 			</td>\r\n"
							+ " 		</tr>\r\n"
							+ " 	</table> "
							+ "	<div class = \"admin\">\r\n"
							+ "		<div class = \"form-box\" id = \"data\">\r\n"
							+"<table>\r\n"
							+ " 		<tr>\r\n"
							+ " 			<td>\r\n"
							+ " 				<img src = \" https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2qxfjUuiytuGXBolQQ4KUgM9fYEYGWGZVEv89rsqH0PzbHVkEXZIos7Z1xWdwoAaSsA&usqp=CAU\" style = \"float: left;  width:445px;height:80px; \">\r\n"
							+ " 			</td>\r\n"		 
							+ " 		</tr>\r\n"
							+ " 	</table>\r\n"
							+ "<hr style = \"border-color:	#FFA500; border-width: 2px solid;\">"
							
							+"<br><br><table>\r\n"
							+ " 		<tr>\r\n"
							+ " 			<td>\r\n"
							+ " 				<img src = \"http://www.alakehome.com/wp-content/uploads/2020/01/person-transparent-red-6.png\" style = \"float: left;  width:90px;height:40px; margin-left: 10px;margin-right: 30px; \">\r\n"
							+ " 			</td>\r\n"
							+ " 			<td>\r\n"
							+ " 		 <label for=\"area\"><strong style = \"font-size: 15px;\">Aadhar Number:</strong></label>"
							+ "		 	<input type=\"text\" class = \"input-field\"value="+number+" disabled><br>"	
							+ " 			</td>\r\n"
							+ " 		</tr>\r\n"
							+ " 	</table>\r\n"
							 
							+ "<p style = \"font-size: 16px; margin-left: 131px;\"><strong>Address:</strong><br>"+fadd+"</p><br>"
							+ "<br><br><br><hr style = \"border-color:	#FFA500; border-width: 2px solid;\">"
							 
							+ "<p style = \"color: black;  text-align: center; font-size:16px;  \"><b>MERA AADHAAR, MERI PEHACHAN</b></p>\r\n"
						 
							+ "		</div>\r\n"
							+"<br><br><center><button onclick = \"printPage()\" class = \"h5\">Print Aadhaar Card</button></center>"
							+ "	</div>\r\n"
							+"<script>\r\n"
							+ "	function printPage(){\r\n"
							+ "		var body = document.getElementById('body').innerHTML;\r\n"
							+ "		var data = document.getElementById('data').innerHTML;\r\n"
							+ "		document.getElementById('body').innerHTML = data;\r\n"
							+ "		window.print();\r\n"
							+ "	}\r\n"
							+ "</script>"
							+"</body>"
							+"</html>");
				} 
				
				else      // It is printed if finalAddress value is not found
				{	
					out.println("<html>"
							+"<head>"
							+"<style>"
							+ "body {\r\n"
							+ "  overflow-x: hidden;\r\n"
							+ "  overflow-y: hidden;\r\n"
							+ "}\r\n"
							+ "\r\n"
							+ "* {\r\n"
							+ "  margin: 0;\r\n"
							+ "  padding: 0;\r\n"
							+ "}\r\n"
							+ ".admin{\r\n"
							+ "	height: 100%;\r\n"
							+ "	width: 100%;\r\n"
							+ "	background-image: linear-gradient(rgba(0,0,0,0.4),rgba(0,0,0,0.4)),url(\"https://t4.ftcdn.net/jpg/01/30/50/59/360_F_130505941_aHM5DQifhmVGcs80xVUPPMfDjg5BBm3c.jpg\");\r\n"
							+ " 	background-position: center;\r\n"
							+ " 	background-size: cover;\r\n"
							+ " 	position: absolute;\r\n"
							+ "}\r\n"
							+ ".form-box{\r\n"
							+ "	width: 28%;\r\n"
							+ "	height: 200px;\r\n"
							+ "	background-image: url(\"https://media.istockphoto.com/vectors/abstract-white-background-vector-id1142563796?k=20&m=1142563796&s=612x612&w=0&h=kZABOtzW6eQOMZvDuLHiNsh-mM_2o9slZKq6-GN6W64=\");\r\n"
							+ "	position: relative;\r\n"
							+ "	margin: 6% auto;\r\n"
							+ "	/background: white;/\r\n"
							+"font-family: \"Times New Roman\", Times, serif;\r\n"
							+ "	font-size: 12px;"
							+ "	padding: 5px;\r\n"
							+ "	border-style: solid;\r\n"
							+ "	border-color:#F1C40F;\r\n"
							+ "	border-width: 8px;\r\n"
							+ "}\r\n"
							+ ".button {\r\n"
							+ "  background: linear-gradient(to right,  #FAEBD7,rgb(255, 128, 64));\r\n"
							+ "  border: none;\r\n"
							+ "  color: black;\r\n"
							+ "  border-radius: 9px;\r\n"
							+ "  padding: 10px 24px;\r\n"
							+ "  text-align: center;\r\n"
							+ "  text-decoration: none;\r\n"
							+ "  display: inline-block;\r\n"
							+ "  font-size: 13.5px;\r\n"
							+ "  cursor: pointer;\r\n"
							+ "  text-decoration: none;\r\n"
							+ "}"
							+".button1 {\r\n"
							+ "  background: linear-gradient(to right,  #FAEBD7,rgb(255, 128, 64));\r\n"
							+ "  border: none;\r\n"
							+ "  color: black;\r\n"
							+ "  cursor: pointer;\r\n"
							+ "  padding: 12px 10px;\r\n"
							+ "  text-align: center;\r\n"
							+ "  text-decoration: none;\r\n"
							+ "  display: inline-block;\r\n"
							+ "  font-size: 17.5px;\r\n"
							+ "  border-radius: 6px;\r\n"
							+ "  transition-duration: 0.4s;\r\n"
							+ "  width: 40%;\r\n"
							+ "  \r\n"
							+ "}\r\n"
							+ ".button1:hover {\r\n"
							+ "  background-color:  #EDBB99; /* Green */\r\n"
							+ "  color: white;\r\n"
							+ "}"
							+ "</style>"
							+"<title>"
							+"Address"
							+"</title>"
							+"</head>"
							+"<body>"
							+"<table>\r\n"
							+ " 		<tr>\r\n"
							+ " 			<td>\r\n"
							+ " 				<img src = \"https://hranker.com/blog/wp-content/uploads/2021/03/government-of-india.jpg\" style = \"float: left; width:160px;height:90px; margin-right:250px\">\r\n"
							+ " 			</td>\r\n"
							+ " 			<td>\r\n"
							+ " 				<h1 style = \"font-size: 30px;margin-right: 120px;\">UIDAI - Unique Identification Authority of India</h1>\r\n"
							+ " 			</td>\r\n"
							+ " 	  <td>\r\n"
							+ " 				 <a href= \"index.jsp\" class = \"button\"><strong>Log out</strong></a>\r\n"
							+ " 				 \r\n"
							+ " 			</td> \r\n"
							+ " 			<td>\r\n"
							+ " 				<img src = \"https://theindiasaga.com/wp-content/uploads/2020/06/cat_politics183-750x400.png\"style = \"float: right; width:188px; height:90px; margin-left:70px\">\r\n"
							+ " 			</td>\r\n"
							+ " 		</tr>\r\n"
							+ " 	</table> "
							+ "	<div class = \"admin\">\r\n"
							+ "		<div class = \"form-box\">\r\n"
							+"<br><br><br><p><center><font size = 5.5px;family: \"Times New Roman\", Times, serif><b>No address found </b></font></center></p>"
							+"<br><br><p><center><font size = 5.5px;family: 'Times New Roman', Times, serif><a href='UpdateForm.jsp?uadhar="+number+"' class = \"button1\">Enter the details</a></center></p>"
							+ "		</div>\r\n"
							+ "	</div>\r\n"
							+"</body>"
							+"</html>");
				}
			}
			
		}
		
		catch(Exception e) {
			 response.sendRedirect("ConnectionDown1.jsp");
		}
	}

}