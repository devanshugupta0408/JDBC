package com.capg.project.service;

import com.capg.project.bean.AccountDetails;

public interface IAccountService {
	public boolean createAccount(AccountDetails account);

	public int depositBalance(int deposit);

	public int showBalance();

	public int withdrawBalance(int withdraw);

	public int FundTransfer(long accountNumber, int amount);



	public boolean login(String username, String passowrd);
	public void printTransaction();
}
