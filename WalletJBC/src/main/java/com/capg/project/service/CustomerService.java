package com.capg.project.service;

import com.capg.project.bean.AccountDetails;

import com.capg.project.dao.CustomerDAO;

public class CustomerService implements ICustomerService {
	CustomerDAO dao = new CustomerDAO();

	public boolean createAccount(AccountDetails account) {
		return dao.createAccount(account);
	}
}
