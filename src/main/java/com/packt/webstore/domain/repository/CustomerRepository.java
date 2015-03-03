package com.packt.webstore.domain.repository;

import java.util.List;

import com.packt.webstore.domain.Customer;

/**
 * The Customer's repository
 * 
 * @author hector
 *
 */
public interface CustomerRepository {

	/**
	 * Method that returns all customers.
	 * 
	 * @return list of customers
	 */
	public List<Customer> getAllCustomers();

}
