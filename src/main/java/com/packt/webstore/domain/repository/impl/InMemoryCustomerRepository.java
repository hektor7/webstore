package com.packt.webstore.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Address;
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
		customer1.setBillingAddress(this.createDummyAddress());
		customer1.setName("Jhon");

		Customer customer2 = new Customer();
		customer2.setCustomerId("2");
		customer2.setBillingAddress(this.createDummyAddress());
		customer2.setName("Paul");

		Customer customer3 = new Customer();
		customer3.setCustomerId("3");
		customer3.setBillingAddress(this.createDummyAddress());
		customer3.setName("Lucy");

		this.listOfCustomers.add(customer1);
		this.listOfCustomers.add(customer2);
		this.listOfCustomers.add(customer3);

	}

	private Address createDummyAddress() {
		Address newAddress = new Address();
		newAddress.setAreaName(RandomStringUtils.randomAlphabetic(10));
		newAddress.setCountry(RandomStringUtils.randomAlphabetic(10));
		newAddress.setDoorNo(RandomStringUtils.randomNumeric(2));
		newAddress.setState(RandomStringUtils.randomAlphabetic(5));
		newAddress.setStreetName(RandomStringUtils.randomAlphabetic(20));
		newAddress.setZipCode(RandomStringUtils.randomNumeric(5));
		
		return newAddress;
	}

	public List<Customer> getAllCustomers() {
		return this.listOfCustomers;
	}

}