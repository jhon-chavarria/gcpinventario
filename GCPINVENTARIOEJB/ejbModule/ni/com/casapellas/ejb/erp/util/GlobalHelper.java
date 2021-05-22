package ni.com.casapellas.ejb.erp.util;

import java.util.ArrayList;
import java.util.List;

public class GlobalHelper {
	public static List<String> GetJavaTypesFromValue(String value) {
		List<String> generalTypes = new ArrayList<String>();
		
		generalTypes.add("String");
		
		if (NumericHelper.isNumeric(value)) {
			generalTypes.add("Number");			
		}
		
		if (DateTimeHelper.isValidDate(value, "yyyy-MM-dd")) {
			generalTypes.add("DateTime");
		}
		
		return generalTypes;
	}
}
