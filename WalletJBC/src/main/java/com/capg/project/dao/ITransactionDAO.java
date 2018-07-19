package com.capg.project.dao;

import com.capg.project.bean.AccountDetails;

public interface ITransactionDAO {
	public int addTransactionDetails(AccountDetails account);

	public void addTransactions(String transaction);

	public void printTransactions();
}
