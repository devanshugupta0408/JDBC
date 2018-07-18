package com.capg.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcUtil {

	 static Connection conn ;
	public static Connection getConection() {
	
	try {
		
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/wallet","root","Capgemini123");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return conn;
		
	}
}
