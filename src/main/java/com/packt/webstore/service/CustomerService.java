package com.packt.webstore.service;

import java.util.List;

import com.packt.webstore.domain.Customer;

/**
 * Customer Service
 * 
 * @author hector
 *
 */
public interface CustomerService {

	/**
	 * Method that obtains all customers.
	 * 
	 * @return list of customers
	 */
	public List<Customer> getAllCustomers();

	
}
