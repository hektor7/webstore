package com.packt.webstore.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE }) // Target where the annotation would be used.
@Retention(RUNTIME) // Scope of the annotation
@Constraint(validatedBy = ProductIdValidator.class) // It defines a validator
@Documented // For processing of JavaDoc documentation.
public @interface ProductId {
	String message() default "{com.packt.webstore.validator.ProductId.message}";

	Class<?>[] groups() default {};

	public abstract Class<? extends Payload>[] payload() default {};
}