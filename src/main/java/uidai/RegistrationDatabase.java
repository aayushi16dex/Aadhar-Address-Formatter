package uidai;

import java.sql.*;

public class RegistrationDatabase extends RandomAadharNumber {
	public String validate(String mobile, String pass) throws SQLException {
		String url = "jdbc:mysql://localhost/";
		String user = "root";
		String password = "root";
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Class not found");
		} 
		con = DriverManager.getConnection(url,user,password);
	    Statement stmt = con.createStatement();
	    String sql = "create database if not exists aadhar";
	    stmt.executeUpdate(sql);
	    System.out.println("Database created successfully...");  
	    String useDB = "use aadhar";
	    stmt.executeUpdate(useDB);
	    
	    // Creating authentication and address table in database.
	    String create_table = "create table if not exists authentication(mobileNo VARCHAR(10) unique, Password VARCHAR(40), aadharNumber VARCHAR(12) unique, uniqueId VARCHAR(6) unique)";
	    stmt.executeUpdate(create_table);
	    String create_table1 = "create table if not exists address (aadharNo VARCHAR(12) unique, hNo VARCHAR(40), street VARCHAR(40), area VARCHAR(40), landmark VARCHAR(40), town VARCHAR(40), subDistrict VARCHAR(40), district VARCHAR(40), state VARCHAR(40), pin INT(6), finalAddress VARCHAR(1000))";
        stmt.executeUpdate(create_table1);
        
        
	    PreparedStatement pstmt = con.prepareStatement("insert into authentication(mobileNo, Password) values(?,?)");
	    PreparedStatement pstmt1 = con.prepareStatement("UPDATE  authentication SET aadharNumber = ?  WHERE mobileNo = ?;");
	    pstmt.setString(1,mobile);
	    pstmt.setString(2,pass);
	    int status=0;
	    String returningOnly="0";
	    try {
	    	status = pstmt.executeUpdate();
	    }
	    catch(Exception e) {
	    	status=0;
	    }
	    if(status!=0) {
	    	boolean putting = true;
	    	while(putting) {
		    	String aadharNo = RandomAadharNumber.generateRandomNumber();
		    	pstmt1.setString(1, aadharNo);
		    	pstmt1.setString(2, mobile);
		    	int status1=0;
		    	try {
		    		status1 = pstmt1.executeUpdate();
		    	}
		    	catch(Exception e) {
		    		status1=0;
		    	}
		    	if(status1!=0) {
		    		putting=false;
		    		returningOnly=aadharNo;
		    	}
		    	else {
		    		putting=true;
		    	}
	    	}
	    }
	    else {
	    	 
	    	System.out.println("Phone number Already Exists");
	    	returningOnly="0";
	    }
	    return returningOnly; 
	}
	
	public String uniqueNumber(String mobile) throws SQLException {
		String url = "jdbc:mysql://localhost/";
		String user = "root";
		String password = "root";
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Class not found");
		} 
		conn = DriverManager.getConnection(url,user,password);
	    Statement stmt = conn.createStatement();
	    
	    String useDB = "use aadhar";
	    stmt.executeUpdate(useDB);
	    
	    PreparedStatement pstmt1 = conn.prepareStatement("UPDATE  authentication SET uniqueId = ?  WHERE mobileNo = ?;");
	    boolean putting1 = true;
	    String returningId="0";
    	while(putting1) {
	    	String uniqueNo = RandomAadharNumber.generateUniqueNumber();
	    	pstmt1.setString(1, uniqueNo);
	    	pstmt1.setString(2, mobile);
	    	int status1=0;
	    	try {
	    		status1 = pstmt1.executeUpdate();
	    	}
	    	catch(Exception e) {
	    		status1=0;
	    	}
	    	if(status1!=0) {
	    		putting1=false;
	    		returningId=uniqueNo;
	    	}
	    	else {
	    		putting1=true;
	    	}
    	}
    	return returningId;
	}

}
