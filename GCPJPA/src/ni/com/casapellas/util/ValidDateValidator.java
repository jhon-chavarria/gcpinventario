package ni.com.casapellas.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidDateValidator implements ConstraintValidator<ValidDate, String> {
private Boolean isOptional;
	
	@Override
	public void initialize(ValidDate validDate) {
		this.isOptional = validDate.optional();
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Boolean validDate = isValidFormat("yyyy-MM-dd HH:mm:ss", value);
			
		return isOptional ? (validDate || value == null || value.length() == 0 || value.trim().isEmpty()) : validDate;
	}
	
	private static Boolean isValidFormat(String format, String value) {
		Date date = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			if (value != null) {
				date = sdf.parse(value);
				if (!value.equals(sdf.format(date))) {
					date = null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return date != null;
	}
}
