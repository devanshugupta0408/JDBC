package com.capg.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

import com.capg.project.bean.AccountDetails;

public class AccountDAO implements IAccountDAO {

	boolean flag = false;
	int value;
	int bal;
	static int accountNumber;
	Scanner sc = new Scanner(System.in);

	public boolean login(String username, String password) {
		Connection conn = JdbcUtil.getConection();
		PreparedStatement st;
		try {

			String selectQuery = "Select * from Account where username=? and password =?";
			st = conn.prepareStatement(selectQuery);
			st.setString(1, username);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				accountNumber = rs.getInt("accountNumber");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean createAccount(AccountDetails account)

	{

		try {
			Connection con = JdbcUtil.getConection();
			String Query = "insert into Account(username,password,accountNumber,balance) values (?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(Query);
			pstmt.setString(1, account.getUsername());
			pstmt.setString(2, account.getPassword());
			pstmt.setLong(3, account.getAccountNumber());
			pstmt.setInt(4, account.getBalance());

			flag = pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;

	}

	public int depositBalance(int deposit) {

		try {
			Connection con = JdbcUtil.getConection();
			String Query = "update Account SET balance = balance+? where accountNumber=?";
			PreparedStatement pstmt = con.prepareStatement(Query);
			pstmt.setInt(1, deposit);
			pstmt.setLong(2, accountNumber);
			value = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;

	}

	public int showBalance() {

		try {
			Connection conn = JdbcUtil.getConection();
			String Query = "select balance from Account where accountNumber=?";
			PreparedStatement pstmt;

			pstmt = conn.prepareStatement(Query);
			pstmt.setLong(1, accountNumber);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bal = rs.getInt("balance");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bal;
	}

	public int withdrawBalance(int withdraw) {
		try {
			Connection con = JdbcUtil.getConection();

			if (showBalance() >= withdraw) {

				String Query = "update Account SET balance = balance-? where accountNumber=?";
				PreparedStatement pstmt = con.prepareStatement(Query);

				pstmt.setInt(1, withdraw);
				pstmt.setLong(2, accountNumber);
				value = pstmt.executeUpdate();
			} else
				value = 0;
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	public int FundTransfer(long ReceiverAccountNumber, int amount) {
		try {
			Connection con = JdbcUtil.getConection();
			if (showBalance() >= amount) {

				String RQuery = "select * from Account where accountNumber=?";
				String SQuery = "update Account SET balance = balance-? where accountNumber=?";

				PreparedStatement recieverPstmt = con.prepareStatement(RQuery);
				PreparedStatement senderPstmt = con.prepareStatement(SQuery);

				recieverPstmt.setLong(1, ReceiverAccountNumber);
				senderPstmt.setInt(1, amount);
				senderPstmt.setLong(2, accountNumber);

				ResultSet rs = recieverPstmt.executeQuery();
				while (rs.next()) {
					flag = true;

					String recieverQuery1 = "update Account SET balance=balance+? where accountNumber=?";
					PreparedStatement recieverPstmt1 = con.prepareStatement(recieverQuery1);

					recieverPstmt1.setInt(1, amount);
					recieverPstmt1.setLong(2, ReceiverAccountNumber);

					recieverPstmt1.executeUpdate();

					value = senderPstmt.executeUpdate();

				}
			} else
				value = 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!flag) {
			System.out.println("Wrong Reciever account number");
		}

		return value;
	}

}
