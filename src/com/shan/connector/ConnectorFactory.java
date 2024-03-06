package com.shan.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorFactory {
	static Connection con=null;
	
	static String url = "jdbc:mysql://localhost:3306/employeedetails";
	
	static String un = "root";
	static String pwd = "Shankar@123";
	
	static public Connection requestConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection(url, un, pwd);
		 
		 return con;

	}
}


