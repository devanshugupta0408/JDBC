package com.capg.project.dao;


import com.capg.project.bean.AccountDetails;


public interface IAccountDAO {
	public boolean createAccount(AccountDetails account);

	public boolean depositBalance(int deposit, AccountDetails account);

	public void showBalance(AccountDetails account);

	public boolean withdrawBalance(int withdraw, AccountDetails account);

	public boolean FundTransfer(long accountNumber, AccountDetails account);


}
