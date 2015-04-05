package com.packt.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import com.packt.webstore.service.CustomerService;

/**
 * Customer service implementation
 * 
 * @author hector
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers() {
		return this.customerRepository.getAllCustomers(); 
	}

	@Override
	public void saveCustomer(Customer customer) {
		this.customerRepository.addCustomer(customer);		
	}

	@Override
	public Customer getCustomer(String customerId) {
		return this.customerRepository.getCustomer(customerId);
	}

	@Override
	public Boolean isCustomerExist(String customerId) {
		return this.customerRepository.isCustomerExist(customerId);
	}

}
