package com.cg.apps.customerms.exceptions;

public class CustomerNotFoundException extends RuntimeException {
	public CustomerNotFoundException(String msg) {
		super(msg);
	}
}
