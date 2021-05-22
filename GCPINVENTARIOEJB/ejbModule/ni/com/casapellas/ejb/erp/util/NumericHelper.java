package ni.com.casapellas.ejb.erp.util;

public class NumericHelper {

	public static boolean isNumeric(String str)
	{
	    return str.matches("^(?:(?:\\-{1})?\\d+(?:\\.{1}\\d+)?)$");
	}
}
