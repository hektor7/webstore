package com.packt.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Order;
import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.OrderRepository;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.CartService;
import com.packt.webstore.service.CustomerService;
import com.packt.webstore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CartService cartService;
	
	@Autowired
	private CustomerService customerService;

	public void processOrder(String productId, int quantity) {
		Product productById = this.productRepository.getProductById(productId);

		if (productById.getUnitsInStock() < quantity) {
			throw new IllegalArgumentException(
					"Out of Stock. Available Units in stock"
							+ productById.getUnitsInStock());
		}

		productById.setUnitsInStock(productById.getUnitsInStock() - quantity);
	}

	//TODO: Improve this method. It isn't using a good way.
	@Override
	public Long saveOrder(Order order) {
		Long orderId = this.orderRepository.saveOrder(order);
		if (this.customerService.isCustomerExist(order.getCustomer().getCustomerId())) {
			this.customerService.saveCustomer(order.getCustomer());
		}
		cartService.delete(order.getCart().getCartId());
		return orderId;
	}

}