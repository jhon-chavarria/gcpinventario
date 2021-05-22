package ni.com.casapellas.gcpfmu.pojo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;


import ni.com.casapellas.util.CollectionScheme;

public class FMUUtil {

	// CONSTANTS CATALOG
	public final static String TYPE_PRICES_CATALOG_ID = "47";
	public final static String MEASURE_CATALOG = "12";
	public final static String INVENTORY_MOVEMENT_TYPE_CATALOG = "04";
	public final static String PAY_CONDITION_CATALOG = "91";
	public final static String RETURN_CANCEL_DOCUMENT_CATALOG = "53";
	public final static String INVENTORY_CATALOG = "35";
	public final static String BRAND_CATALOG = "22";
	public final static String DAY_WEEK_CATALOG = "24";
	public final static String CLIENT_SEGMENT_CATALOG = "08";
	public final static String COMPANY_ID = "01";
	public final static String LINES_ID = "20";
	public final static String BRANCHES_ID = "02";	

	// Constants BILL MANAGER
	public final static String CANCEL_BILL_CODE = "AF";
    public final static String DEV_CREDIT_LETTER = "E";
    public final static String DEV_CASH_LETTER = "D";
    public final static String CREDIT_LETTER = "C";
    public final static String CPD_BRANCH_CODE = "00";
    public final static String MAKE_BILL_ACTION_ID = "21";
    
    
    // Cash Constants
    public final static String CASH_TYPE = "001";
	public final static String CREDIT_TYPE = "002";
	public final static String CASH_LETTER= "CO";
	public final static String CREDIT_LETTER_CASH= "CR";
	public final static String SOBRANTE_LETTER= "S";
	
	
	public final static String CHECK_PAYMENT_METHOD = "!";
	public final static String TRANSFER_PAYMENT_METHOD = "T";
	public final static String CASH_PAYMENT_METHOD = ".";
	public final static String CREDIT_CARD_PAYMENT_METHOD = "?";
	
	
	public final static String DEPOSIT_PAYMENT_METHOD = "N";
	
	// Constants Accounting
	public static final String ICICUT = "G";
	public static final String ICICUT_CREDIT_PAY = "RB";
	public static final String ICICUT_CREDIT_BILL = "IB";
	public static final String ICICUT_SURPLUS_BILL = "G";

	public static final String ICBAL = "N";
	public static final String ICBALJ = "Y";

	// BATCH DETAIL
	public static final String GLDCT = "P9";
	public static final String GLICUT = "G";
	
	// Config 
	public final static String US_COIN_ID = "USD";
	public final static String COR_COIN_ID = "COR";
	
	public final static String COR_AA_LETTER = "AA";
	public final static String DOL_CA_LETTER = "CA";
	
	public final static String F_CA_LETTER = "F";
	public final static String D_CA_LETTER = "D";
	
	public final static String SBR_LABEL = "SBR";
	
	
	// Error Logs Codes
	public final static String BILL_CODE = "F";
	public final static String RECEIPT_CODE = "R";
	public final static String ORDER_CODE = "O";

	// ROLES ACTIONS
	public final static int CREATE_BILL_ROLE_ID = 12;
	public final static int DEV_BILL_ROLE_ID = 13;
	public final static int CANCEL_BILL_ROLE_ID = 14;

	public final static int CLIENT_ACTIVITIES_ROLE_ID = 5;
	public final static int CASH_ACTIVITY = 17;
	public final static int ORDER_ACTIVITY = 36;

	public final static int CXC_ROLE_SECTION = 25;
	public final static int VIEW_BILL = 18;

	public static int dateToJulian(java.util.Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR) - 1900;
		int month = calendar.get(Calendar.DAY_OF_YEAR);
		return Integer.parseInt(String.format("%03d%03d", year, month));
	}

	public static int dateToJulian(String dateString) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
		java.util.Date date = null;
		try {
			date = formatter.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dateToJulian(date);
	}

	public static int getIntegerDate() {
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		return Integer.parseInt(df.format(cal.getTime()));
	}

	public static int getIntegerDateFromDays(int days) {
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -days); // number of days to add
		return Integer.parseInt(df.format(cal.getTime()));
	}

	public static float getRound(double d, int decimalPlace) {
		return Math.round(d);
	}

	public static int getIntegerHour(java.util.Date date) {
		DateFormat df = new SimpleDateFormat("HHmmss");

		return Integer.parseInt(df.format(date));
	}

	public static int getMonthInt(java.util.Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
		return Integer.parseInt(dateFormat.format(date));
	}

	public static int getYearInt(java.util.Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		return Integer.parseInt(dateFormat.format(date));
	}

	public static String getParallelRateFormat() {
		SimpleDateFormat dateFormatYear = new SimpleDateFormat("yyyy");
		SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MM");

		String year = String.valueOf(dateFormatYear.format(new java.util.Date()));

		int monthNumber = Integer.parseInt(dateFormatMonth.format(new java.util.Date()));
		String month = (String) (monthNumber < 10 ? "0" + monthNumber : String.valueOf(monthNumber));		
		
		String date = "01" + month + year;
			
		return date;
	}

	
	public static String getFeeCreditNumber(int sequence) {

		if (sequence > 0 && sequence < 10) {
			return "00" + sequence;
		} else if (sequence >= 10 && sequence < 99) {
			return "0" + sequence;
		}

		return String.valueOf(sequence);
	}

	public static String getJdLineNumberSpace(String jdLine) {
		
		int total = (12 - jdLine.length());
		return String.format("%1$" + total + "s", "");
	}
		
	public static String getSubsString(String value) {
		String newSearch = value.replaceAll("(?=[]\\[+&|!(){}^\"~*?:\\\\-])", "\\\\");
		newSearch = newSearch.replaceAll("'", "\\\\");
		return newSearch.length() > 1000 ? (newSearch.substring(0, 999)) : newSearch;
	}
	

}
