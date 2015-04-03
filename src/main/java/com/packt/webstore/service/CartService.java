package com.packt.webstore.service;

import com.packt.webstore.domain.Cart;

/**
 * Service for Cart entity.
 * 
 * @author hector
 *
 */
public interface CartService {

	/**
	 * It creates a new Cart.
	 * 
	 * @param cart
	 *            cart to be created
	 * @return the new cart
	 */
	public Cart create(Cart cart);

	/**
	 * It obtains a cart from a given id.
	 * 
	 * @param cartId
	 *            cart id
	 * @return cart
	 */
	public Cart read(String cartId);

	/**
	 * It updates a cart from a given id and cart.
	 * 
	 * @param cartId
	 *            cart id
	 * @param cart
	 *            to be updated
	 */
	public void update(String cartId, Cart cart);

	/**
	 * It deletes a cart with the given id.
	 * 
	 * @param cartId
	 *            cart id
	 */
	public void delete(String cartId);
	
	/**
	 * It validates a cart with the given id.
	 * 
	 * @param cartId id whose cart will be validated.
	 * @return validated cart.
	 */
	public Cart validate(String cartId);

}