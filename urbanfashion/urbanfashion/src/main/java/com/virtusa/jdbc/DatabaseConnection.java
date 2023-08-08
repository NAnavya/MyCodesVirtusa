package com.virtusa.jdbc;

import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseConnection {

	static Scanner sc;
	private DatabaseConnection(){

	}
	static Logger logger = Logger.getLogger(DatabaseConnection.class.getName());
	private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/uf";
	
	private static Connection connection = null;

	static {
		try {
			sc = new Scanner(System.in);
			Class.forName(DRIVER_CLASS);
			logger.info("Enter Connection username");
			String uname = sc.next();
			logger.info("Enter Connection password");
			String upass = sc.next();
			connection = DriverManager.getConnection(URL,uname,upass);
		}
		catch(ClassNotFoundException | SQLException  e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
	
	public static void closeConnection() throws SQLException {
		connection.close();
	}
	
}
