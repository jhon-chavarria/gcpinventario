package ni.com.casapellas.ejb.erp.util;

public class StringHelper {
	
	public static String padLeft(String inputString, int length, String appendCharacter) {
	    if (inputString.length() >= length) {
	        return inputString;
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    while (sb.length() < length - inputString.length()) {
	        sb.append(appendCharacter);
	    }
	    
	    sb.append(inputString);

	    return sb.toString();
	}
	
	public static String padRight(String inputString, int length, String appendCharacter) {
	    if (inputString.length() >= length) {
	        return inputString;
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    sb.append(inputString);
	    
	    while (sb.length() < length - inputString.length()) {
	        sb.append(appendCharacter);
	    }

	    return sb.toString();
	}
	
	public static Boolean IsNotNullOrEmpty(String pString) {
		return pString != null && !pString.trim().isEmpty();
	}
	
	public static Integer convertToInteger(String stringNumber) throws Exception {
		if (stringNumber == null) {
			throw new Exception("El prametro no es una cadena numerica valida");
		}
		
		return Integer.parseInt(stringNumber.trim());
	}
}
