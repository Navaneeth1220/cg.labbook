package com.cg.apps.customerms.service;

import java.time.LocalDateTime;
import java.util.Set;

import com.cg.apps.itemms.entity.Item;

import com.cg.apps.customerms.entity.Account;
import com.cg.apps.customerms.entity.Customer;

public interface ICustomerService {
	Customer addCutomer(String name);	
	Customer findById(long id);
	Customer addAmount(long id,double amount);
	Set<Item> itemBoughtByCustomer(Long customerId);
	
}
