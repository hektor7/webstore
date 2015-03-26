package com.packt.webstore.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.packt.webstore.domain.Product;

public class ProductImageValidator implements Validator {

	@Override
	public boolean supports(Class<?> classs) {
		return Product.class.isAssignableFrom(classs);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product productTarget = (Product) target;
		
		if (productTarget.getProductImage() != null
				&& productTarget.getProductImage().getSize() > 10000) {
			errors.rejectValue("productImage",
					"com.packt.webstore.validator.ProductImageValidator.message");
		}
		
	}

}
