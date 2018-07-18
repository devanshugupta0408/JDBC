package com.capg.project.service;

import com.capg.project.bean.CustomerDetails;

import com.capg.project.dao.CustomerDAO;

public class CustomerService implements ICustomerService {
	CustomerDAO dao = new CustomerDAO();

	public boolean createAccount(CustomerDetails customer) {
		return dao.createAccount(customer);
	}
}
