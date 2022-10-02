package com.simplilearn.estore.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtility {

	private final String DB_SCHEMA = "ecommerce_db";
	private final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_SCHEMA;
	private final String DB_USERNAME = "root";
	private final String DB_PASSWORD = "root";

	private Connection connection = null;
	private Statement statement = null;
	
	private static DBUtility db = new DBUtility();

	public static DBUtility getDBUtility() {
		return db;
	}

	// Register the Driver class
	private DBUtility() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("' " + DB_SCHEMA + " ' " + " Driver Loader.");
			init();
		} catch (Exception e) {
			System.out.println("Oops! something went wrong" + e.getMessage());
		}
	}

	// Initialize DB Connection
	public void init() {
		try {
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			statement = connection.createStatement();
			System.out.println("' " + DB_SCHEMA + " ' " + "Connection established.");
		} catch (Exception e) {
			System.out.println("Oops! something went wrong" + e.getMessage());
		}
	}

	// Close DB Connection
	public void destroy() {
		try {
			if(connection!=null) {
				connection.close();
				System.out.println("' " + DB_SCHEMA + " ' " + "Connection closed.");
			}
		} catch (Exception e) {
			System.out.println("Oops! something went wrong" + e.getMessage());
		}
	}
	
   // save , update & delete operations
   public int executeUpdate(String sql) {
	   int result =0;
	   try {
		   System.out.println(" < " + DB_SCHEMA + " Executing SQL " + sql + " > ");
		   result = statement.executeUpdate(sql);
		   System.out.println("Statement was succesful.");
		} catch (Exception e) {
			System.out.println("Something went wrong " + e.getMessage());
		}
	   return result;
   }
	
   // select operations
   public ResultSet executeQuery(String sql) {
	   ResultSet rs = null;
	   try {
		   System.out.println(" < " + DB_SCHEMA + " Executing SQL " + sql + " > ");
		   rs = statement.executeQuery(sql);
		   System.out.println("Statement was succesful.");
		} catch (Exception e) {
			System.out.println("Something went wrong " + e.getMessage());
		}
	   return rs;
   }
}
