package com.sathya.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sathya.dao.ICustomerDao;
import com.sathya.model.CustomerRegistrationBean;
import com.sathya.model.Gender;

@Repository
public class CustomerDaoImpl implements ICustomerDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean loginCustomer(String email,String password) {
		String sql="select count(*) from customers where email=? and password=?";
		int count=jdbcTemplate.queryForObject(sql,Integer.class,email,password);
		if (count==1) {
			return true;
		}
		else {
			
		return false;
		}
	}

	@Override
	public boolean addCustomer(CustomerRegistrationBean customerRegistrationBean) {
		String sql="select count(*) from customers where email=?";
		int count=jdbcTemplate.queryForObject(sql,Integer.class,customerRegistrationBean.getEmail());		
		if (count==1) {
		return false;
		}
		else {
			String gender=" ";
			if(customerRegistrationBean.getGender()==Gender.MALE) {
				gender="male";
			}
			else if(customerRegistrationBean.getGender()==Gender.FEMALE) {
				gender="female";
				
			}
			else {
				gender="others";
			}
         jdbcTemplate.update("insert into customers(email,firstname,lastname,password,gender,country) values (?,?,?,?,?,?)",customerRegistrationBean.getEmail(),customerRegistrationBean.getFirstName(),customerRegistrationBean.getLastName(),customerRegistrationBean.getPassword(),gender,customerRegistrationBean.getCountry());
return true;
		}
	}

	@Override
	public void sendEmail(String email, String name) {
		// TODO Auto-generated method stub
		
	}

	}


