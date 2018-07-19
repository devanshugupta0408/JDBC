package com.capg.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capg.project.bean.AccountDetails;

public class TransactionDAO implements ITransactionDAO {
	Connection conn;
	int value;
	long accountNumber;

	public int addTransactionDetails(AccountDetails account) {

		try {

			conn = JdbcUtil.getConection();
			String Query = "insert into Transaction(transactions,accountNumber) values(?,?)";
			PreparedStatement pstmt = conn.prepareStatement(Query);
			pstmt.setString(1, "Transactions: ");
			pstmt.setLong(2, account.getAccountNumber());

			value = pstmt.executeUpdate();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {

			try {

				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return value;

	}

	public void addTransactions(String transaction) {

		try {

			conn = JdbcUtil.getConection();
			String Query = "Update transaction SET transactions=CONCAT(transactions, ?) where accountNumber=?";
			PreparedStatement pstmt = conn.prepareStatement(Query);
			pstmt.setString(1, "\n" + transaction);
			pstmt.setLong(2, accountNumber);

			value = pstmt.executeUpdate();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {

			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public void printTransactions() {

		try {

			conn = JdbcUtil.getConection();
			String Query = "select * from transaction where accountNumber=?";
			PreparedStatement pstmt = conn.prepareStatement(Query);
			pstmt.setLong(1, accountNumber);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("transactions"));
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {

			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
