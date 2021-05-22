package ni.com.casapellas.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidPositiveDecimalValidator.class)
public @interface ValidPositiveDecimal {
	String message() default "El valor del campo es invalido";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	double Min() default 0;
	double Max() default Double.MAX_VALUE;
}
