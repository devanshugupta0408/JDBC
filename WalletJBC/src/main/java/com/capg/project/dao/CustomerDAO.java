package com.capg.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.capg.project.bean.AccountDetails;

public class CustomerDAO implements ICustomerDAO {

	boolean flag = false;

	public boolean createAccount(AccountDetails account) {

		try {
			Connection con = JdbcUtil.getConection();
			String Query = "insert into Customer(customerName,age,phoneNumber,gender,customerEmail) values (?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(Query);
			pstmt.setString(1, account.getCustomerDetails().getCustomerName());
			pstmt.setInt(2, account.getCustomerDetails().getAge());
			pstmt.setString(3, account.getCustomerDetails().getPhoneNumber());
			pstmt.setString(4, account.getCustomerDetails().getGender());
			pstmt.setString(5, account.getCustomerDetails().getCustomerEmail());

			flag = pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;

	}
}
