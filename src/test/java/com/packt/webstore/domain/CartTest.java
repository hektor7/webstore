package com.packt.webstore.domain;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Class for testing of Cart entity.
 * 
 * @author hector
 *
 *///TODO: Randomize with any mock.
public class CartTest {

	private Cart cart;

	@Before
	public void setup() {
		cart = new Cart();
	}

	@Test
	public void cart_total_price_should_be_equal_to_sum_of_each_product_unit_price() {
		// Arrange
		this.populateCart();

		// Act
		BigDecimal totalPrice = this.calculateTotalPrice();

		// Assert
		Assert.assertEquals(cart.getGrandTotal(), totalPrice);
	}

	private BigDecimal calculateTotalPrice() {
		BigDecimal totalPrice = new BigDecimal(0);
		
		Iterator<Entry<String, CartItem>> entries = this.cart.getCartItems().entrySet().iterator();
		
		while (entries.hasNext()) {
			Entry<String, CartItem> entry = entries.next();
			totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
		}
		
		return totalPrice;
	}

	private void populateCart() {
		int itemsQuantity = 3; //TODO: Randomize
		
		CartItem cartItem;
		for(int i=0;i<itemsQuantity;i++) {
			cartItem = new CartItem();
			cartItem.setProduct(this.createProduct());
			cartItem.setQuantity(1);
			
			this.cart.addCartItem(cartItem);
		}
		
	}

	private Product createProduct() {
		Product product = new Product();
		
		product.setCategory(RandomStringUtils.randomAlphabetic(4));
		product.setCondition(RandomStringUtils.randomAlphabetic(4));
		product.setDescription(RandomStringUtils.randomAlphabetic(40));
		product.setDiscontinued(false);
		product.setManufacturer(RandomStringUtils.randomAlphabetic(10));
		product.setName(RandomStringUtils.randomAlphabetic(20));
		product.setProductId(RandomStringUtils.randomAlphabetic(4));
		product.setUnitPrice(new BigDecimal(100));
		product.setUnitsInOrder(1);
		product.setUnitsInStock(10);
		
		return product;
	}
}