package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Cart;

/**
 * Cart's repository.
 * 
 * @author hector
 *
 */
public interface CartRepository {

	/**
	 * It creates a new cart.
	 * 
	 * @param cart
	 *            that will be created.
	 * @return the new created cart.
	 */
	public Cart create(Cart cart);

	/**
	 * It obtains a cart from an id.
	 * 
	 * @param cartId
	 *            cart's id
	 * @return a cart
	 */
	public Cart read(String cartId);

	/**
	 * It updates a cart from an id and a given cart object
	 * 
	 * @param cartId
	 *            cart id
	 * @param cart
	 *            to update
	 */
	public void update(String cartId, Cart cart);

	/**
	 * It deletes a cart from an id.
	 * 
	 * @param cartId
	 *            cart id.
	 */
	public void delete(String cartId);

}
