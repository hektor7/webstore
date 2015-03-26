package com.packt.webstore.validator;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryValidator implements
		ConstraintValidator<Category, String> {

	List<String> allowedCategories;
	
	public void initialize(Category constraintAnnotation) {
		//TODO: It would be better to use a category's service.
		this.allowedCategories = new ArrayList<String>();
		this.allowedCategories.add("Smart Phone");
		this.allowedCategories.add("Tablet");
		this.allowedCategories.add("Laptop");
		// intentionally left blank; this is the place to initialize the
		// constraint annotation for any sensible default values.
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if (this.allowedCategories.contains(value)) {
			return true;
		}else {
			return false;
		}
	}
}