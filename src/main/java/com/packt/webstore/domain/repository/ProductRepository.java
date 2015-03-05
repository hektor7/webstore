package com.packt.webstore.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
	
	/**
	 * Method that returns a Product from a product's id.
	 * 
	 * @param productId product's id
	 * @return product
	 */
	public Product getProductById(String productId);
	
	/**
	 * Method that returns a list of products from a category 
	 * passed as parameter.
	 * @param category
	 * @return list of products
	 */
	public List<Product> getProductsByCategory(String category);
	
	/**
	 * Method that returns a set of products by filter
	 * @param filterParams params
	 * @return set of products
	 */
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	
}
