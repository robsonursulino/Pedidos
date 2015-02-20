package com.algaworks.pedidovenda.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

/**
 * Anotação usada para restringir a digitação no campo SKU.
 * <p/>
 * Deve ser digitado os dois primeiro caracteres como letras maiúsculas ou
 * minúsculas e o restante deve ser números.
 * <p/>
 * Ex: HP520369
 * <p/>
 *
 * @author Robson
 *
 */
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Pattern(regexp = "([a-zA-Z]{2}\\d{4,18})?")
public @interface SKU {

	@OverridesAttribute(constraint = Pattern.class, name = "message")
	String message() default "{com.algaworks.contraints.SKU.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
