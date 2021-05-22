package ni.com.casapellas.util;

import java.util.Arrays;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidCurrencyValidator implements ConstraintValidator<ValidCurrency, String> {

	@Override
	public void initialize(ValidCurrency arg0) {
		// Parametros iniciales
	}

	@Override
	public boolean isValid(String inputValue, ConstraintValidatorContext context) {
		List<String> currencyList = Arrays.asList(new String[] {"COR", "USD"});
		
		return currencyList.contains(inputValue);
	}

}
