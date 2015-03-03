package com.packt.webstore.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;

/**
 * Dummy class to simulate the retrieving data from database.
 * 
 * @author hector
 *
 */
@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

	private List<Customer> listOfCustomers = new ArrayList<Customer>();

	public InMemoryCustomerRepository() {
		Customer customer1 = new Customer();
		customer1.setCustomerId("1");
		customer1.setAddress("Great avenue");
		customer1.setName("Jhon");
		customer1.setNoOfOrdersMade(100);

		Customer customer2 = new Customer();
		customer2.setCustomerId("2");
		customer2.setAddress("Big street");
		customer2.setName("Paul");
		customer2.setNoOfOrdersMade(12);

		Customer customer3 = new Customer();
		customer3.setCustomerId("3");
		customer3.setAddress("Down hill, 3");
		customer3.setName("Lucy");
		customer3.setNoOfOrdersMade(132);

		this.listOfCustomers.add(customer1);
		this.listOfCustomers.add(customer2);
		this.listOfCustomers.add(customer3);

	}

	public List<Customer> getAllCustomers() {
		return this.listOfCustomers;
	}

}