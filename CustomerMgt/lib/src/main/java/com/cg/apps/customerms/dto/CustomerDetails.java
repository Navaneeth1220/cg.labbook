package com.cg.apps.customerms.dto;

import java.time.LocalDateTime;

import com.cg.apps.customerms.entity.Account;

public class CustomerDetails {
	private long id;
	private String name;
	private Account account;
	
	public CustomerDetails() {}
	
	public CustomerDetails(long id,String name,Account account) {		
		this.setId(id);
		this.setName(name);
		this.setAccount(account);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
}
