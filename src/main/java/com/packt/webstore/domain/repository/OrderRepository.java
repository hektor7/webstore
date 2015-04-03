package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Order;

/**
 * Repository to manage all operations of Order's entity.
 * 
 * @author hector
 *
 */
public interface OrderRepository {

	/**
	 * It saves a new order.
	 * 
	 * @param order
	 *            to be saved
	 * @return order number.
	 */
	public Long saveOrder(Order order);

}
