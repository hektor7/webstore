package com.packt.webstore.exception;


public class CustomerNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -6628425777802305362L;
	
	private String customerId;

	public CustomerNotFoundException(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerId() {
		return customerId;
	}
}
