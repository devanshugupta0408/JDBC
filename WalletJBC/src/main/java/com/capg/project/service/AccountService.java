package com.capg.project.service;

import com.capg.project.bean.AccountDetails;
import com.capg.project.dao.AccountDAO;

public class AccountService implements IAccountService {

	AccountDAO dao = new AccountDAO();

	public boolean createAccount(AccountDetails account) {
		return dao.createAccount(account);
	}

	public boolean login(String username, String passowrd) {
		return dao.login(username, passowrd);
	}

	public int depositBalance(int deposit) {
		return dao.depositBalance(deposit);
	}

	public int showBalance() {

		return dao.showBalance();

	}

	public int withdrawBalance(int withdraw) {
		return dao.withdrawBalance(withdraw);
	}

	public int FundTransfer(long accountNumber, int amount) {
		return dao.FundTransfer(accountNumber, amount);
	}

	public void printTransaction() {
		dao.printTransactions();

	}

}
