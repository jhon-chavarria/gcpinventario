package ni.com.casapellas.util;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidTaxValidator implements ConstraintValidator<ValidTax, Number> {

	private String tax;
	@Override
	public void initialize(ValidTax arg0) {
		this.tax = arg0.taxName();
	}
	@Override
	public boolean isValid(Number inputNumber, ConstraintValidatorContext context) {
		List<String> taxList = Arrays.asList("IVA", "ISC");
		
		if (!taxList.contains(tax)) {
			return false;
		}
		
		if (inputNumber.doubleValue() > 0) {
			if (tax.toUpperCase().equals("IVA") && inputNumber.doubleValue() != 15) {
				return false;
			}
		}
		
		return true;
	}
}
