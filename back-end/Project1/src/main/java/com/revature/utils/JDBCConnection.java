package com.revature.utils;

import java.io.IOException;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.lang.ClassNotFoundException;

public class JDBCConnection {
	
	
private static Connection conn = null;

public static Connection getConnection() {
	
	// if connection doesn't exist, make one
	
	try {
	
		if (conn == null) {
			
			Class.forName("org.postgresql.Driver");
			
			Properties props = new Properties();
			
			InputStream input = JDBCConnection.class.getClassLoader().getResourceAsStream("connection.properties");
			
			props.load(input);
			
			String url = props.getProperty("url");
			String username = props.getProperty("username");
			String password = props.getProperty("password");
		
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		//have to check if a connection exists. 
		
		} else {
			return conn;
		}
		
	} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
	} 
	
	return null;
	
	
	}

	public static void main(String[] args) {
		
		Connection conn = JDBCConnection.getConnection();
		
		if (conn != null) {
			
			System.out.println("connection successful");
			
		}
		else {
			
			System.out.println("connection unsuccessful");
			
		}
	}


}
