package com.packt.webstore.domain.repository;

import java.util.List;

import com.packt.webstore.domain.Product;

/**
 * The Product's repository
 * 
 * @author hector
 *
 */
public interface ProductRepository {

	/**
	 * Method that returns all products.
	 * 
	 * @return list of products
	 */
	public List<Product> getAllProducts();
}
