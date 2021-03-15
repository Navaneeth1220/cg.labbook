package com.cg.apps.customerms.dto;

public class CreateAddAmountRequest {
	private int customerId;
	private double balance;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
