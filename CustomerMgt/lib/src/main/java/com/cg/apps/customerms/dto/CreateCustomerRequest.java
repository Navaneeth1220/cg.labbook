package com.cg.apps.customerms.dto;

import com.cg.apps.customerms.entity.Account;

public class CreateCustomerRequest {
	private String name;
	private Account account;
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
