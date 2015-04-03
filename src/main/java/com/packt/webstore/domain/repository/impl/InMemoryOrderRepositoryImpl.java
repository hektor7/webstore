package com.packt.webstore.domain.repository.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.packt.webstore.domain.Order;
import com.packt.webstore.domain.repository.OrderRepository;

/**
 * Dummy order's repository implementation
 * 
 * @author hector
 *
 */
@Repository
public class InMemoryOrderRepositoryImpl implements OrderRepository {

	private Map<Long, Order> listOfOrders;
	private long nextOrderId;

	public InMemoryOrderRepositoryImpl() {
		this.listOfOrders = new HashMap<Long, Order>();
		this.nextOrderId = 1000;
	}

	public Long saveOrder(Order order) {
		order.setOrderId(getNextOrderId());
		this.listOfOrders.put(order.getOrderId(), order);
		return order.getOrderId();
	}

	private synchronized long getNextOrderId() {
		return this.nextOrderId++;
	}
}