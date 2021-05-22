package ni.com.casapellas.util;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidPaymentConditionValidator implements ConstraintValidator<ValidPaymentCondition, String> {

	@Override
	public void initialize(ValidPaymentCondition arg0) {
		
	}

	@Override
	public boolean isValid(String inputValue, ConstraintValidatorContext context) {
		List<String> paymentList = Arrays.asList("CO","CR");
		return paymentList.contains(inputValue.toUpperCase());
	}
 
}
