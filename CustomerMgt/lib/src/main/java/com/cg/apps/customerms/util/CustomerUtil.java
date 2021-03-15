package com.cg.apps.customerms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.apps.customerms.dto.CustomerDetails;
import com.cg.apps.customerms.entity.Customer;

@Component
public class CustomerUtil {
	public CustomerDetails toDetails(Customer customer) {
		CustomerDetails details = new CustomerDetails(customer.getId(),customer.getName(),customer.getAccount());
		return details;
	}
	
	public List<CustomerDetails> toDeatils(Collection<Customer> customers){
		List<CustomerDetails> list = new ArrayList<>();
		
		for(Customer customer : customers) {
			CustomerDetails details = toDetails(customer);
			list.add(details);
		}
		return list;
	}
}
