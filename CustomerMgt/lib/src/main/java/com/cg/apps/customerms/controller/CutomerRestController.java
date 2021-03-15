package com.cg.apps.customerms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.customerms.dto.CreateCustomerRequest;
import com.cg.apps.customerms.dto.CreateAddAmountRequest;
import com.cg.apps.customerms.dto.CustomerDetails;
import com.cg.apps.customerms.entity.Customer;
import com.cg.apps.customerms.service.ICustomerService;
import com.cg.apps.customerms.util.CustomerUtil;

@RequestMapping("/customers")
@RestController
public class CutomerRestController {
	
	@Autowired
	private ICustomerService service;
	
	@Autowired
	private CustomerUtil util;
	
	
	@PostMapping("/add")
	public String addCustomer(@RequestBody CreateCustomerRequest requestData) {
		Customer customer = service.addCutomer(requestData.getName());
		return "Customer added for id = "+customer.getId();
	}
	
	
	@GetMapping("/byid/{id}")
	public CustomerDetails fetchCustomer(@PathVariable("id") long id) {
		Customer customer = service.findById(id);
		CustomerDetails details = util.toDetails(customer);
		return details;
	}
	/*	
	@PutMapping("/addamount")
	public CustomerDetails addAmount(@RequestBody CreateAddAmountRequest requestData) {
		Customer customer = service.addAmount(requestData.getCustomerId(), requestData.getBalance());
		CustomerDetails details = util.toDetails(customer);
		return details;
	}
	*/
	
}
