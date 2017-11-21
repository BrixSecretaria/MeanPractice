package com.ibm.bluemix.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;



@SuppressWarnings("unused")
public class DataAccessManager {
	
	final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final static String DB_URL = "jdbc:mysql://us-cdbr-sl-dfw-01.cleardb.net/ibmx_839e495583a0d86";
	
	public static boolean verifyLogIn(String userName, String passWord){
		
		Connection conn = null;
		Statement stmt = null;
		
		Map<String,String> credentials = new HashMap<String,String>();
		
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database...");
			
		    conn = DriverManager.getConnection(DB_URL,"b46a6eb7f1b409","401c9177");
		    
		    stmt = conn.createStatement();
		    
		    String sql;
		      sql = "SELECT user_name, user_password FROM user_details";
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      while(rs.next()){
		          //Retrieve by column name
		          String id = rs.getString("user_name");
		          String pwd = rs.getString("user_password");
		          
		          credentials.put(id,pwd);
		       }
		      
		}catch(Exception e){
			 e.printStackTrace();
			
		}finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }
		
		if (credentials.containsKey(userName) && passWord.equals((String)credentials.get(userName)))
		{
			return true;
		}else {
			return false;
		}
	}
	public static boolean registerUser(String userName, String passWord){
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database...");
			
		    conn = DriverManager.getConnection(DB_URL,"b46a6eb7f1b409","401c9177");
		    
		    String sql;
		      sql = "insert into user_details (user_name,user_password) values ('" + userName + "','" + passWord + "')";
		      
		      stmt = conn.createStatement();
		      
		      stmt.executeUpdate(sql);
		      
		}catch(Exception e){
			 e.printStackTrace();
			
		}finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }
		
		return true;

	}
}
