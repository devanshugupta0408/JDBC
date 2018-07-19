package com.capg.project.bean;

public class AccountDetails {

	private long accountNumber;
	private String username;
	private String password;
	private int balance;
	private CustomerDetails CustomerDetails;

	public CustomerDetails getCustomerDetails() {
		return CustomerDetails;
	}

	public void setCustomerDetails(CustomerDetails customerDetails) {
		CustomerDetails = customerDetails;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber2) {
		this.accountNumber = accountNumber2;
	}

	@Override
	public String toString() {
		return "trans";
	}

}
