package uidai;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*; 

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("upass");
		String AbleToAddOrNot = "0";
		RegistrationDatabase checking = new RegistrationDatabase();
		try {
			AbleToAddOrNot = checking.validate(mobile,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		if(!"0".equals(AbleToAddOrNot)) {
			UserDatabase checking1 = new UserDatabase();
			 
			try 
			{
				if(checking1.getConnection()!=null) {
					checking1.insertAadhar(AbleToAddOrNot);
				}
			} 
			catch (Exception e) 
			{
				 response.sendRedirect("ConnectionDown.jsp");
			}
			
			String aadharNo = AbleToAddOrNot;
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
					+ " .button {\r\n"
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
					+ "</style>\r\n"
					+ "\r\n"
					+ "<title>User Detail</title>\r\n"
					+ "</head>\r\n"
					+ "<body >\r\n"
					+ "<table>"
					+ " 		<tr>\r\n"
					+ " 			<td>\r\n"
					+ " 				<img src = \"https://hranker.com/blog/wp-content/uploads/2021/03/government-of-india.jpg\" style = \"float: left; width:200px;height:90px; margin-right:231px\">\r\n"
					+ " 			</td>\r\n"
					+ " 			<td>\r\n"
					+ " 				<h1 style = \"font-size: 30px;margin-right: 130px;\">UIDAI - Unique Identification Authority of India</h1>\r\n"
					+ " 			</td>\r\n"
					+ " 	    <td>\r\n"
					+ " 				 <a href= \"index.jsp\" class = \"button\"><strong>Log out</strong></a>\r\n"
					+ " 				 \r\n"
					+ " 			</td> \r\n"
					+ " 			<td>\r\n"
					+ " 				<img src = \"https://theindiasaga.com/wp-content/uploads/2020/06/cat_politics183-750x400.png\"style = \"float: right; width:188px; height:90px; margin-left:120px\">\r\n"
					+ " 			</td>\r\n"
					+ " 		</tr>\r\n"
					+ " 	</table> "
					+ "	<div class = \"admin\">\r\n"
					+ "		<div class = \"form-box\">\r\n"
					+ "				<h2 style=\"margin-left: 110px; margin-bottom: 1px;font-size: 30px\"><u>User Details</u></h2><br>\r\n"
					+ "			 \r\n"
					+ "				<img src = \"https://images.assetsdelivery.com/compings_v2/salamatik/salamatik1801/salamatik180100019.jpg\" style = \"width: 180px;height: 140px;margin-left: 90px;\"><br><br><br><br>\r\n"
					+ "			 	<br><br><form class = \"input-group\"action=\"UpdateForm.jsp\"> "
					+ "			 		<label for=\"uid\"><b>Your Alloted Aadhaar Number is: </b></label> \r\n"
					+ "	 				<input type=\"text\" class = \"input-field\" value="+aadharNo+"   disabled required>"
					+ "	<!-- Hidden form fields -->  <input type='hidden' name='uadhar' value="+aadharNo+">"   
					+ "		 			<input type='submit' class=\"submitbtn\" value='Proceed'>"
					+ "			 	</form>"
					
					+ "		</div>\r\n"
					+ "	</div>\r\n"
					+ "	 \r\n"
					+ "</body>\r\n"
					+ "</html>");
		}
		else {
			 JOptionPane.showMessageDialog(null,"You are a registered user!", "ERROR" ,JOptionPane.ERROR_MESSAGE);
			 response.sendRedirect("index.jsp");
	
		}
	}
}


