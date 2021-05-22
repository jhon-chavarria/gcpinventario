package ni.com.casapellas.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidPositiveDecimalValidator implements ConstraintValidator<ValidPositiveDecimal, Number> {

	private Double minValue;
	private Double maxValue;
	
	@Override
	public void initialize(ValidPositiveDecimal arg0) {
		this.minValue = arg0.Min();
		this.maxValue = arg0.Max();
	}

	@Override
	public boolean isValid(Number inputVale, ConstraintValidatorContext context) {
		double value = inputVale.doubleValue();
		
		if (this.minValue != null && value < this.minValue.doubleValue()) {
			return false;
		}
		
		if (this.maxValue != null && value > this.maxValue.doubleValue()) {
			return false;
		}
		
		return true;
	}

}
