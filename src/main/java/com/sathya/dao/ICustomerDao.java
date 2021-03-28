package com.sathya.dao;

import com.sathya.model.CustomerRegistrationBean;

public interface ICustomerDao {
	public boolean loginCustomer(String email,String password);
	public boolean addCustomer(CustomerRegistrationBean customerRegistrationBean);
	void sendEmail(String email, String name);

}
