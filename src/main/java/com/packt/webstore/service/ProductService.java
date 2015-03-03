package com.packt.webstore.service;

import java.util.List;

import com.packt.webstore.domain.Product;

/**
 * Product Service
 * 
 * @author hector
 *
 */
public interface ProductService {

	/**
	 * Method that obtains all products.
	 * 
	 * @return list of products
	 */
	public List<Product> getAllProducts();

	
}
