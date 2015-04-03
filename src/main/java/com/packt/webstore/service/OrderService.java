package com.packt.webstore.service;

import com.packt.webstore.domain.Order;

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
	
	/**
	 * It allow to save an order.
	 * 
	 * @param order to be saved.
	 * @return a order number
	 */
	public Long saveOrder(Order order);

}
