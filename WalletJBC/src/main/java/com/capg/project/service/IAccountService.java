package com.capg.project.service;



import com.capg.project.bean.AccountDetails;

public interface IAccountService {
	public boolean createAccount(AccountDetails account);

	public boolean depositBalance(int deposit, AccountDetails account);

	public void showBalance(AccountDetails account);

	public boolean withdrawBalance(int withdraw, AccountDetails account);

	public boolean FundTransfer(long accountNumber, AccountDetails account);

	public void PrintTransaction(AccountDetails account);
}

