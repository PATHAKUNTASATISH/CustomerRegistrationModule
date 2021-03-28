package com.sathya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sathya.dao.ICustomerDao;
@Controller
public class CustomerLoginController {
	
	@Autowired
	ICustomerDao dao;
	
	@GetMapping("/login")
	public String getLoginPage() {
		return "login";
		
	}
@PostMapping("/check")
public String checkLogin(@RequestParam String email,@RequestParam String password,Model model) {
	
		boolean flag=dao.loginCustomer(email, password);
		if(flag==false) {
			model.addAttribute("msg", "Bad Credentials");
			return "login";
		}
		else {
			return  "loginSuccess";
		}
	}

}

