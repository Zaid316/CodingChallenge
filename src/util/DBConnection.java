package util;
import java.sql.*;

public class DBConnection {


private static Connection conn = null;
	
	private  DBConnection() {
     try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
 
           
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "zaid");
 
            System.out.println("Connected to the database");
           
 
        }
        catch(Exception e)
        {
        	System.out.println(e);
        }
 
	}
 
	public static Connection  getConnect()
	 {
		 DBConnection d1= new DBConnection();
		 return conn;
		
	 }
    }