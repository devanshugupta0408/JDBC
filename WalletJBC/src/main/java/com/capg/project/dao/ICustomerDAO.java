package com.capg.project.dao;

import com.capg.project.bean.AccountDetails;
import com.capg.project.bean.CustomerDetails;

public interface ICustomerDAO {
	public boolean createAccount(CustomerDetails customer);
}
