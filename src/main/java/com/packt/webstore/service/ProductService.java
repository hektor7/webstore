package com.packt.webstore.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
	
	/**
	 * Method that obtains all product from a category.
	 * 
	 * @param category
	 * @return list of product
	 */
	public List<Product> getProductsByCategory(String category);
	
	/**
	 * Method that obtains a set of products by a filter
	 * @param filterParams params
	 * @return set of products
	 */
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);

	/**
	 * It obtains a Product through its id
	 * @param productId id
	 * @return a product
	 */
	public Product getProductById(String productId);

	
}
