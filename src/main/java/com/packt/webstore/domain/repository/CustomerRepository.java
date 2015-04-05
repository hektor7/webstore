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

	/**
	 * Method for save a new customer.
	 * 
	 * @param customer
	 *            new customer
	 */
	public void addCustomer(Customer customer);

	/**
	 * Retrieve a customer by the given id.
	 * 
	 * @param customerId
	 *            customer's id
	 * @return customer
	 */
	public Customer getCustomer(String customerId);

	/**
	 * Says if exits a customer with the given id.
	 * 
	 * @param customerId
	 *            customer id.
	 * @return true if exists
	 */
	public Boolean isCustomerExist(String customerId);

}
