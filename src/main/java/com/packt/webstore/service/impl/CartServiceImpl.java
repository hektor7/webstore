package com.packt.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Cart;
import com.packt.webstore.domain.repository.CartRepository;
import com.packt.webstore.exception.InvalidCartException;
import com.packt.webstore.service.CartService;

/**
 * Cart service implementation
 * 
 * @author hector
 *
 */
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	public Cart create(Cart cart) {
		return this.cartRepository.create(cart);
	}

	public Cart read(String cartId) {
		return this.cartRepository.read(cartId);
	}

	public void update(String cartId, Cart cart) {
		this.cartRepository.update(cartId, cart);
	}

	public void delete(String cartId) {
		this.cartRepository.delete(cartId);

	}

	@Override
	public Cart validate(String cartId) {

		Cart cart = this.cartRepository.read(cartId);
		
		if (cart == null || cart.getCartItems().size() == 0) {
			throw new InvalidCartException(cartId);
		}

		return cart;
	}

}