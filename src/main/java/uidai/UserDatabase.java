package uidai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
 

public class UserDatabase {
	private String url = "jdbc:mysql://localhost/";
	private String user = "root";
	private String password = "root";

	// Declare and initialise sql query for inserting data and printing the final address 
	private static final String insert_query = "insert into address(aadharNo) values (?)";
	private static final String update_query = "UPDATE address SET hNo = ?, street = ?, area = ?, landmark = ?, town = ?, subDistrict = ?, district = ?, state = ?, pin = ?, finalAddress = ? WHERE aadharNo = ?;";
	private static final String select_query = "Select finalAddress from address where aadharNo = ?";

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
	 
	public int insertAadhar(String aadharNo) throws SQLException {
		int status = 0;
		try (Connection conn = getConnection();) {
	        PreparedStatement pstmt = conn.prepareStatement(insert_query);
	        pstmt.setString(1, aadharNo);
	        status = pstmt.executeUpdate();
	        
		} catch (Exception e) {
			System.out.println("Connection not established");
		}
		return status;
	}
	
	// Inserts the data into table and formats the address
	public void updateAndFormatting(AddressInput user) throws SQLException {

		try (Connection conn = getConnection()) {
			
			PreparedStatement pstmt = conn.prepareStatement(update_query);

			pstmt.setString(11, user.getAadharNo());
			pstmt.setString(1, user.gethNo());
			pstmt.setString(2, user.getStreet());
			pstmt.setString(3, user.getArea());
			pstmt.setString(4, user.getLandmark());
			pstmt.setString(5, user.getTown());
			pstmt.setString(6, user.getSubDistrict());
			pstmt.setString(7, user.getDistrict());
			pstmt.setString(8, user.getState());
			pstmt.setString(9, user.getPin());

			// It only takes the unique values. Therefore all the duplicates will be removed. 
			LinkedHashSet<String> set = new LinkedHashSet<>();

			set.add(user.gethNo());
			set.add(user.getStreet());
			set.add(user.getArea().toLowerCase());
			set.add(user.getLandmark().toLowerCase());
			set.add(user.getTown().toLowerCase());
			set.add(user.getSubDistrict().toLowerCase());
			set.add(user.getDistrict().toLowerCase());
			set.add(user.getState());
			set.add(user.getPin());

			// Checks extra commas and removes square brackets
			String value = set.toString();
			int length = value.length();
			String value1 = value.substring(1, length - 1);
			String finalAddress = value1.replaceAll(" , ", " ");
			String ch = finalAddress.substring(0, 1);

			if (ch.equals(",")) {
				int length1 = finalAddress.length();
				String finalAddress1 = finalAddress.substring(2, length1);
				String formatAddress = capitalizeWord(finalAddress1);
				pstmt.setString(10, formatAddress);  //Adds the formatted address to the table in column 11
				pstmt.executeUpdate();  
			} else {
				String formatAddress1 = capitalizeWord(finalAddress);
				pstmt.setString(10, formatAddress1);
				pstmt.executeUpdate();

			}
		} catch (Exception e) {
			System.out.println("Connection not established! "+e);

		}
	}
	 
	public String capitalizeWord(String str){  
	    String words[]=str.split("\\s");  
	    String capitalizeWord="";  
	    for(String w:words){  
	        String first=w.substring(0,1);  
	        String afterfirst=w.substring(1);  
	        capitalizeWord+=first.toUpperCase()+afterfirst+" ";  
	    }  
	    return capitalizeWord.trim();  
	}  
	
	// Login validation
	public String selectPassword(String mob) {
		String pass = null;
		try(Connection conn = getConnection()) 
		{
			String select_authquery = "select password from authentication where mobileNo = ?";
			PreparedStatement pstmt = conn.prepareStatement(select_authquery);
			pstmt.setString(1,mob);
			pstmt.execute();
			ResultSet rst = pstmt.executeQuery();
			rst.next();
			pass = rst.getString("password");
			return pass;
		}
		catch (SQLException e) {
			return pass;	
		}	
	}
	
	// Selecting aadhar number
	public String selectAadhar(String mobile) {
		String aadhar = null;
		try(Connection conn = getConnection()) 
		{
			String select_aadhquery = "select aadharNumber from authentication where mobileNo = ?";
			PreparedStatement pstmt = conn.prepareStatement(select_aadhquery);
			pstmt.setString(1,mobile);
			pstmt.execute();
			ResultSet rst = pstmt.executeQuery();
			rst.next();
			aadhar = rst.getString("aadharNumber");
			return aadhar;
		}
		catch (SQLException e) {
			return aadhar;	
		}	
	}
	// It returns the formatted address 
	public String selectAddress(String aadharNo) {
		 
		String add = null;
		try(Connection conn = getConnection()){
			 
			PreparedStatement pstmt = conn.prepareStatement(select_query);
			pstmt.setString(1,aadharNo);
			
			ResultSet rst = pstmt.executeQuery();
			rst.next();
			add = rst.getString("finalAddress"); 
			return add;
		}
		 
		catch (SQLException e) {
			return add;	
		}	
	}
}