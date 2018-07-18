package com.capg.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.capg.project.bean.CustomerDetails;


public class CustomerDAO implements ICustomerDAO {
	
	boolean flag=false;
	public boolean createAccount(CustomerDetails customer)
	{
		
		try {
			Connection con = JdbcUtil.getConection();
			String Query = "insert into Customer(customerName,age,phoneNumber,gender,customerEmail) values (?,?,?,?,?)";
			PreparedStatement pstmt= con.prepareStatement(Query);
			pstmt.setString(1, customer.getCustomerName());
			pstmt.setInt(2,customer.getAge());
			pstmt.setString(3, customer.getPhoneNumber());
			pstmt.setString(4, customer.getGender());
			pstmt.setString(5, customer.getCustomerEmail());
			
			flag = pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
		
		
	}
}
