package uidai;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class UserIdServlet
 */
public class UserIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserIdServlet() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String mob = request.getParameter("mob");
		String id = request.getParameter("uid");
		
		UserDatabase db = new UserDatabase();
		try {
			 if(db.getConnection()!=null) {
				 String uid = db.selectUserId(mob);
				 if(id.equals(uid)) {
					  out.println("<html>\r\n"
					  		+ "<head>\r\n"
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
					  		+ "	height: 420px;\r\n"
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
					  		+ "	top: 190px;\r\n"
					  		+ "	margin-left: 5px;\r\n"
					  		+ "	position: absolute;\r\n"
					  		+ "	width: 280px;\r\n"
					  		+ "	transition: .5s;\r\n"
					  		+ "}\r\n"
					  		+ ".input-field{\r\n"
					  		+ "	width: 100%;\r\n"
					  		+ "	padding: 10px 0;\r\n"
					  		+ "	margin: 5px 25px;\r\n"
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
					  		+ "  font-size: 22px;\r\n"
					  		+ "  padding: 10px 15px;\r\n"
					  		+ "  margin-left: 65px;\r\n"
					  		+ "  margin-top: 45px;\r\n"
					  		+ "  cursor: pointer;\r\n"
					  		+ "  width: 85%;\r\n"
					  		+ "  border:0;\r\n"
					  		+ "  border-radius: 30px;\r\n"
					  		+ "  outline: none;\r\n"
					  		+ "  \r\n"
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
					  		+ "</style>\r\n"
					  		+ "\r\n"
					  		+ "<title>User Detail</title>\r\n"
					  		+ "</head>\r\n"
					  		+ "<body>\r\n"
					  		+ "<table>\r\n"
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
					  		+ " 	</table> \r\n"
					  		+ "	<div class = \"admin\">\r\n"
					  		+ "		<div class = \"form-box\">\r\n"
					  		+ "				<h2 style=\"margin-left: 90px; margin-bottom: 1px;font-size: 30px\"><u>Reset Password</u></h2><br>\r\n"
					  		+ "			 \r\n"
					  		+ "				<img src = \"https://images.assetsdelivery.com/compings_v2/salamatik/salamatik1801/salamatik180100019.jpg\" style = \"width: 140px;height: 100px;margin-left: 120px;\"><br><br><br><br>\r\n"
					  		+ "			 	<form class = \"input-group\" action = \"ResetPasswordServlet\" method = \"post\">\r\n"
					  		+ "			 		 \r\n"
					  		+ "			 		<input type=\"password\" class = \"input-field\" placeholder = \"Enter new password\" name =\"pass\" minlength = \"8\" required>\r\n"
					  		+ "			 	  \r\n"
					  		+ "			 		<br><input type=\"password\" class = \"input-field\" placeholder = \"Confirm new password\" name =\"cpass\" minlength = \"8\"  required>\r\n"
					  		+ "				    <input type=\"hidden\"   value = "+mob+" name =\"mobile\"required>\r\n"
					  		+ "				    <button type=\"submit\" class=\"submitbtn\">Confirm</button>\r\n"
					  		+ "			 	</form>\r\n"
					  		+ "		</div>\r\n"
					  		+ "	</div>\r\n"
					  		+ "	 \r\n"
					  		+ "</body>\r\n"
					  		+ "</html>");
				 }
				 else {
					 JOptionPane.showMessageDialog(null,"Incorrect mobile number or user id\nEnter again!!", "ERROR" ,JOptionPane.ERROR_MESSAGE);
					 response.sendRedirect("UserId.jsp");
				 }
			 }
			 else 
			 {
				 response.sendRedirect("ConnectionDown1.jsp");
			 }
		}
		catch(Exception e) {
			response.sendRedirect("ConnectionDown1.jsp");
		}
		
		 
	     
		
		
	}

}