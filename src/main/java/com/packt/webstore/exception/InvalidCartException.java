package com.packt.webstore.exception;

/**
 * Invalid cart exception
 * 
 * @author hector
 *
 */
public class InvalidCartException extends RuntimeException {

	private static final long serialVersionUID = -5192041563033358491L;
	private String cartId;

	public InvalidCartException(String cartId) {
		this.cartId = cartId;
	}

	public String getCartId() {
		return cartId;
	}
}