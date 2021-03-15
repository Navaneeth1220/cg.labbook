/*
package com.cg.apps.customerms.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.apps.customerms.entity.Account;
import com.cg.apps.customerms.entity.Customer;
import com.cg.apps.customerms.exceptions.CustomerNotFoundException;

@Repository
public class CustomerDaoImpl implements ICustomerDao{
	
	@PersistenceContext
	private EntityManager entity;

	@Override
	public Customer add(Customer customer) {
		entity.persist(customer);
		return customer;
	}

	@Override
	public Customer findById(long customerId) {
		Customer customer = entity.find(Customer.class, customerId);
		if(customer==null) {
			throw new CustomerNotFoundException("No customer exists for id="+customerId);
		}
		return customer;
	}

	@Override
	public Customer update(Customer customer) {
		customer=entity.merge(customer);
		return entity.find(Customer.class,customer.getId());
	}

	@Override
	public Account addAccount(Account account) {
		entity.persist(account);
		return account;
	}

	@Override
	public Account updateAccount(Account account) {
		entity.merge(account);
		return account;
	}
	
	
}

*/