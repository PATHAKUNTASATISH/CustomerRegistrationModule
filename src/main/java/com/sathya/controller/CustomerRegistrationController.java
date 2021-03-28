 package com.sathya.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sathya.dao.ICustomerDao;
import com.sathya.model.CustomerRegistrationBean;
import com.sathya.service.CustomerRegistrationMailService;

@Controller
public class CustomerRegistrationController {
	@Autowired
	ICustomerDao  dao;
	
	@Autowired
	CustomerRegistrationMailService  mailService;
	
	@GetMapping("/index")
	public  String   getIndexPage() {
		return  "index";
	}
	
	
	@GetMapping("/register")
	public  String  getRegistrationPage(Model  model) {
		model.addAttribute("customer",new CustomerRegistrationBean());
		return  "register";
	}
	
	@PostMapping("/saveUser")
	public   String   saveUser(@Valid @ModelAttribute("customer")CustomerRegistrationBean  customerRegistrationBean, BindingResult  result, Model model) {
		if(result.hasErrors()) {
			return  "register";
		}
		else {
			boolean flag=dao.addCustomer(customerRegistrationBean);
			if(flag==false) {
				model.addAttribute("message", "Customer already registered with this MailId");
				return "register";
			}
			else {
				String fullname=customerRegistrationBean.getFirstName()+" "+customerRegistrationBean.getLastName();
				mailService.sendEmail(customerRegistrationBean.getEmail(), fullname);
				return "success";
			}
		}
	
	}


}
