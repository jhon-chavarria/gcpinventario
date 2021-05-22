package ni.com.casapellas.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidTaxValidator.class)
public @interface ValidTax {
	String message() default "El valor del impuesto es invalido";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	String taxName() default "";
}
