package uidai;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

 
public class AuthenticationServlet extends HttpServlet {
	int count = 0;
	private static final long serialVersionUID = 1L;
 
    public AuthenticationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("mobile");
		String upass = request.getParameter("upass");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		UserDatabase database = new UserDatabase();
		
		try{
			if(database.getConnection()!=null)
			{
				String value1 = database.selectPassword(value);
				if(value1!=null){
					if(upass.equals(value1)){
						int timeout = 1000;
			            HttpSession sessionObj = request.getSession(true);
			            sessionObj.setMaxInactiveInterval(timeout);
			            sessionObj.invalidate();
			            response.setHeader("Cache-Control","no-cache"); 
			            response.setHeader("Cache-Control","no-store");
			            response.setDateHeader("Expires", 0);
			            response.setHeader("Refresh", timeout + "; index.jsp");
                   
						String aadharno = database.selectAadhar(value);
						out.println( "<html>\r\n"
								+ "<head>\r\n"
								 
								+ " \r\n"
								+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
								+ "<style>\r\n"
								+ "body {\r\n"
								+ "  overflow-x: hidden;\r\n"
								+ "  overflow-y: hidden;\r\n"
								+ "}\r\n"
								+ "\r\n"
								+ "* {\r\n"
								+ "  margin: 0;\r\n"
								+ "  padding: 0;\r\n"
								+ "}\r\n"
								+ "\r\n"
								+ ".admin{\r\n"
								+ "	height: 100%;\r\n"
								+ "	width: 100%;\r\n"
								+ "	background-image: linear-gradient(rgba(0,0,0,0.4),rgba(0,0,0,0.4)),url(\"https://media.istockphoto.com/vectors/tricolor-brush-stroke-vector-id1009448862?k=20&m=1009448862&s=612x612&w=0&h=eespJdPh6lWxgsxgkpc7Xa7w8BcnHaC9-h89EKUhk1Q=\");\r\n"
								+ " 	background-position: center;\r\n"
								+ " 	background-size: cover;\r\n"
								+ "	\r\n"
								+ " 	position: absolute;\r\n"
								+ "}\r\n"
								+ "\r\n"
								+ ".form-box{\r\n"
								+ "	width: 380px;\r\n"
								+ "	height: 430px;\r\n"
								+ "	position: relative;\r\n"
								+ "	margin: 6% auto;\r\n"
								+ "	background: white;\r\n"
								+ "	padding: 5px;\r\n"
								+ "	border-style: solid;\r\n"
								+ "	border-color:#EC7063;\r\n"
								+ "	border-width: 8px;\r\n"
								+ "}\r\n"
								+ "\r\n"
								+ ".input-group{\r\n"
								+ "	top: 210px;\r\n"
								+ "	margin-left: 5px;\r\n"
								+ "	position: absolute;\r\n"
								+ "	width: 280 px;\r\n"
								+ "	transition: .5s;\r\n"
								+ "}\r\n"
								+ ".input-field{\r\n"
								+ "	width: 100%;\r\n"
								+ "	padding: 10px 0;\r\n"
								+ "	margin: 5px 3px;\r\n"
								+ "	border-left: 0;\r\n"
								+ "	border-top: 0;\r\n"
								+ "	border-right: 0;\r\n"
								+ "	border-bottom: 1px solid #999;\r\n"
								+ "	outline: none;\r\n"
								+ "	background: transparent;\r\n"
								+ "	\r\n"
								+ "}\r\n"
								+ " .submitbtn {\r\n"
								+ "  background: linear-gradient(to right, #ff105f,#ffad06);\r\n"
								+ "  color: black;\r\n"
								+ "  font-size: 25px;\r\n"
								+ "  padding: 10px 30px;\r\n"
								+ "  margin-left: 25px;\r\n"
								+ "  margin-top: 65px;\r\n"
								+ "  cursor: pointer;\r\n"
								+ "  width: 85%;\r\n"
								+ "  border:0;\r\n"
								+ "  border-radius: 30px;\r\n"
								+ "  outline: none;\r\n"
								+ "  \r\n"
								+ "}\r\n"
								+ ".button {\r\n"
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
								+ "</style>\r\n"
								+ "\r\n"
								+ "<title>User Detail</title>\r\n"
								+ "</head>\r\n"
								+ "<body >\r\n"
								+"<table >"
								+ " 		<tr>\r\n"
								+ " 			<td>\r\n"
								+ " 				<img src = \"https://hranker.com/blog/wp-content/uploads/2021/03/government-of-india.jpg\" style = \"float: left; width:200px;height:90px; margin-right:180px\">\r\n"
								+ " 			</td>\r\n"
								+ " 			<td>\r\n"
								+ " 				<h1 style = \"font-size: 30px;margin-right: 120px;\">UIDAI - Unique Identification Authority of India</h1>\r\n"
								+ " 			</td>\r\n"
								+ " 	  <td>\r\n"
								+ " 				 <a href= \"index.jsp\" class = \"button\"><strong>Log out</strong></a>\r\n"
								+ " 				 \r\n"
								+ " 			</td> \r\n"
								+ " 			<td>\r\n"
								+ " 				<img src = \"https://theindiasaga.com/wp-content/uploads/2020/06/cat_politics183-750x400.png\"style = \"float: right; width:188px; height:90px; margin-left:80px\">\r\n"
								+ " 			</td>\r\n"
								+ " 		</tr>\r\n"
								+ " 	</table> "
								+ "	<div class = \"admin\">\r\n"
								+ "		<div class = \"form-box\">\r\n"
								+ "				<h2 style=\"margin-left: 110px; margin-bottom: 1px;font-size: 30px\"><u>User Details</u></h2><br>\r\n"
								+ "			 \r\n"
								+ "				<img src = \"https://images.assetsdelivery.com/compings_v2/salamatik/salamatik1801/salamatik180100019.jpg\" style = \"width: 180px;height: 140px;margin-left: 90px;\"><br><br><br><br>\r\n"
								+ "			 	<br><br><form class = \"input-group\"action=\"UserMenu.jsp\" method = 'post' > "
								+ "			 		<label for=\"uid\"><b>Registered Aadhaar Number is: </b></label> \r\n"
								+ "	 <input type=\"text\" class = \"input-field\" value="+aadharno+" disabled required>"
								+ "	 				<input type='hidden' name='uadhar' value= "+aadharno+">" 
								+ "		 			<input type='submit' class=\"submitbtn\" value='Proceed'>"
								+ "			 	</form>"
								
								+ "		</div>\r\n"
								+ "	</div>\r\n"
								+ "	 \r\n"
								+ "</body>\r\n"
								+ "</html>");
						  
					                                 
						  out.close();
					}
					else{
						count++;
						 if(count<4) {
							 JOptionPane.showMessageDialog(null,"Incorrect password. \nRe-enter the details!!", "WRONG PASSWORD" ,JOptionPane.ERROR_MESSAGE);
							 response.sendRedirect("index.jsp");
						 }
						 else {
							 JOptionPane.showMessageDialog(null,"Too many unsuccessful attempts. \nReset your password!!", "WARNING" ,JOptionPane.ERROR_MESSAGE);
							 response.sendRedirect("UserId.jsp");
						 }
						
						 
					}
				}
				else{
					if(database.getConnection()==null) {
						response.sendRedirect("ConnectionDown1.jsp");
					}
					else {
						JOptionPane.showMessageDialog(null,"You are not a registered user");
						response.sendRedirect("index.jsp");
					}
				}
			}
	 
		}
		catch (Exception e)
		{
			 response.sendRedirect("ConnectionDown.jsp");
		}
		
	}

}
