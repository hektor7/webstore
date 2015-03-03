package com.packt.webstore.service;

/**
 * Order Service
 * 
 * @author hector
 *
 */
public interface OrderService {

	/**
	 * Method that allow to process an order based in a 
	 * product Id and a number of products.
	 * 
	 * @param productId product id
	 * @param count number of products
	 */
	public void processOrder(String productId, int count);

}
