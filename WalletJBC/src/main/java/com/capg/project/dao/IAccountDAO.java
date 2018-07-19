package com.capg.project.dao;

import com.capg.project.bean.AccountDetails;

public interface IAccountDAO {
	public boolean createAccount(AccountDetails account);

	public int depositBalance(int deposit);

	public boolean login(String username, String passowrd);

	public int showBalance();

	public int withdrawBalance(int withdraw);

	public int FundTransfer(long accountNumber, int amount);
}
