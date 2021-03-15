package com.cg.apps.customerms.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.customerms.dao.IAccountRepository;
import com.cg.apps.customerms.dao.ICustomerRepository;
import com.cg.apps.customerms.entity.Account;
import com.cg.apps.customerms.entity.Customer;
import com.cg.apps.customerms.exceptions.CustomerNotFoundException;
import com.cg.apps.customerms.exceptions.InvalidIdException;
import com.cg.apps.itemms.entity.Item;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	
	@Autowired
	ICustomerRepository cRepo;
	
	@Autowired
	IAccountRepository aRepo;
	
	
	@Transactional
	@Override
	public Customer addCutomer(String name) {
		LocalDateTime date = LocalDateTime.now();
		Account account = new Account(0.0,date);
		aRepo.save(account);
		Customer customer = new Customer(name);
		customer.setAccount(account);
		customer=cRepo.save(customer);
		return customer;
	}

	@Override
	public Customer findById(long id) {
		validateId(id);
		Optional<Customer> customer = cRepo.findById(id);
		if(!customer.isPresent()) {
			throw new CustomerNotFoundException("Customer not found");
		}
		return customer.get();
	}
	
	
	@Override
	public Set<Item> itemBoughtByCustomer(Long customerId) {
		validateId(customerId);
		Optional<Customer> customer = cRepo.findById(customerId);
		if (!customer.isPresent()) {
			throw new CustomerNotFoundException("Customer not available for given id ");
		}
		Customer c = customer.get();
		Set<Item> items=c.getBoughtItems();
		return items;
	}
	
	
	@Transactional
	@Override
	public Customer addAmount(long customerId, double amount) {
		
		
		Optional<Customer> customer = cRepo.findById(customerId);
		if(!customer.isPresent()) {
			throw new CustomerNotFoundException("Customer not found");
		}
	
		Account acc = customer.get().getAccount();
		acc.setBalance(amount);
		aRepo.save(acc);
		return customer.get();
	}

	
	
	void validateId(long id) {
		if(id<0) {
			throw new InvalidIdException("Id is invalid");
		}
	}

	





		
	
	

}
