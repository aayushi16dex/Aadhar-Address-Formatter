package uidai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrieveDataUpdate {
	
	private String url = "jdbc:mysql://localhost/";
	private String user = "root";
	private String password = "root";
	
	//It establishes the connection with MySql and creates database and table in it
		protected Connection getConnection() throws SQLException {
			Connection conn = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Class not found");
			} 
			
		    // Open a connection and creates database
		    conn = DriverManager.getConnection(url,user,password);
		    Statement stmt = conn.createStatement();
		     
		    String useDB = "use aadhar";
		    stmt.executeUpdate(useDB);
		     
			return conn;
		        
		}	
		
		public String selectHNo(String aadharNo) {
			String hNo1 = "";
			try(Connection conn = getConnection()){
				 
				String finalQuery = "Select hNo from address where aadharNo = ?";
				PreparedStatement pstmt = conn.prepareStatement(finalQuery);
				pstmt.setString(1,aadharNo);
				
				ResultSet rst = pstmt.executeQuery();
				rst.next();
				hNo1 = rst.getString("hNo");
				
				return hNo1;
			}
			catch (SQLException e) {
				return hNo1;	
			}
		}
		
		public String selectStreet(String aadharNo) {
			String street1 = "";
			try(Connection conn = getConnection()){
				 
				String finalQuery = "Select street from address where aadharNo = ?";
				PreparedStatement pstmt = conn.prepareStatement(finalQuery);
				pstmt.setString(1,aadharNo);
				
				ResultSet rst = pstmt.executeQuery();
				rst.next();
				street1 = rst.getString("street");
				
				return street1;
			}
			catch (SQLException e) {
				return street1;	
			}
		}
		
		public String selectArea(String aadharNo) {
			String area1 = "";
			try(Connection conn = getConnection()){
				 
				String finalQuery = "Select area from address where aadharNo = ?";
				PreparedStatement pstmt = conn.prepareStatement(finalQuery);
				pstmt.setString(1,aadharNo);
				
				ResultSet rst = pstmt.executeQuery();
				rst.next();
				area1 = rst.getString("area");
				
				return area1;
			}
			catch (SQLException e) {
				return area1;	
			}
		}
		
		public String selectLandmark(String aadharNo) {
			String landmark1 = "";
			try(Connection conn = getConnection()){
				 
				String finalQuery = "Select landmark from address where aadharNo = ?";
				PreparedStatement pstmt = conn.prepareStatement(finalQuery);
				pstmt.setString(1,aadharNo);
				
				ResultSet rst = pstmt.executeQuery();
				rst.next();
				landmark1 = rst.getString("landmark");
				
				return landmark1;
			}
			catch (SQLException e) {
				return landmark1;	
			}
		}
		
		public String selectTown(String aadharNo) {
			String town1 = "";
			try(Connection conn = getConnection()){
				 
				String finalQuery = "Select town from address where aadharNo = ?";
				PreparedStatement pstmt = conn.prepareStatement(finalQuery);
				pstmt.setString(1,aadharNo);
				
				ResultSet rst = pstmt.executeQuery();
				rst.next();
				town1 = rst.getString("town");
				
				return town1;
			}
			catch (SQLException e) {
				return town1;	
			}
		}
		
		public String selectSubDistrict(String aadharNo) {
			String subDistrict1 = "";
			try(Connection conn = getConnection()){
				 
				String finalQuery = "Select subDistrict from address where aadharNo = ?";
				PreparedStatement pstmt = conn.prepareStatement(finalQuery);
				pstmt.setString(1,aadharNo);
				
				ResultSet rst = pstmt.executeQuery();
				rst.next();
				subDistrict1 = rst.getString("subDistrict");
				
				return subDistrict1;
			}
			catch (SQLException e) {
				return subDistrict1;	
			}
		}
		
		public String selectDistrict(String aadharNo) {
			String district1 = "";
			try(Connection conn = getConnection()){
				 
				String finalQuery = "Select district from address where aadharNo = ?";
				PreparedStatement pstmt = conn.prepareStatement(finalQuery);
				pstmt.setString(1,aadharNo);
				
				ResultSet rst = pstmt.executeQuery();
				rst.next();
				district1 = rst.getString("district");
				
				return district1;
			}
			catch (SQLException e) {
				return district1;	
			}
		}
		
		public String selectState(String aadharNo) {
			String state1 = "";
			try(Connection conn = getConnection()){
				 
				String finalQuery = "Select state from address where aadharNo = ?";
				PreparedStatement pstmt = conn.prepareStatement(finalQuery);
				pstmt.setString(1,aadharNo);
				
				ResultSet rst = pstmt.executeQuery();
				rst.next();
				state1 = rst.getString("subDistrict");
				
				return state1;
			}
			catch (SQLException e) {
				return state1;	
			}
		}
		
		public String selectPin(String aadharNo) {
			String pin1 = "";
			try(Connection conn = getConnection()){
				 
				String finalQuery = "Select pin from address where aadharNo = ?";
				PreparedStatement pstmt = conn.prepareStatement(finalQuery);
				pstmt.setString(1,aadharNo);
				
				ResultSet rst = pstmt.executeQuery();
				rst.next();
				pin1 = rst.getString("pin");
				
				return pin1;
			}
			catch (SQLException e) {
				return pin1;	
			}
		}
}
