package com.cg.apps.customerms.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {
	
	@GeneratedValue
	@Id
	private Long accountId;
	private Double balance;
	private LocalDateTime created;	
	
	public Account () {}
	
	public Account(Double balance,LocalDateTime date) {
		this.setBalance(balance);
		this.setCreated(date);
	}
	
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

}
