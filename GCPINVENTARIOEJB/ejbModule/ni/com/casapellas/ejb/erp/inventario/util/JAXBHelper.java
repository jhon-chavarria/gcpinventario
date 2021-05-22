package ni.com.casapellas.ejb.erp.inventario.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class JAXBHelper {


	@SuppressWarnings("unused")
	private enum JAXBClass {
		ACTIVITIESCOLLECTION,
		ACTIVITIESORDERCOLLECTION,
		ACTIVITYDETAILCOLLECTION,
		BRANDCOLLECTION,
		MATERIALSCOLLECTION,
		MECHANICCOLLECTION,
		ORDERSCOLLECTION,
		QUOTECOLLECTION,
		VEHICLESCOLLECTION,
		WORKSHOPSCOLLECTION
	}
	
	/**
	 * sDate: Formato YYYY-MM-dd HH:mm:ss.
	 */
	public static Date ConvertToDate2(String sDate){
		Date currentDate = null;
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			currentDate = formatDate.parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return currentDate;
	}
	
	/**
	 * @iDate: Formato YYYYMMDD.
	 */
	public static String FormatDate(int iDate){
		String sResult = "";
		sResult = String.valueOf(iDate);
		sResult = sResult.substring(0, 4) + "-" + sResult.substring(4, 6) + "-" + sResult.substring(6, 8);		
		return sResult;
	}
	
	/**
	 * @iDate: Formato DDMMYYYY.
	 */
	public static String FormatDate2(int iDate){
		String sResult = "";
		sResult = String.valueOf(iDate);
		
		if(sResult.length() == 7)
			sResult = sResult.substring(3, 7) + "-" + sResult.substring(1, 3) + "-" + sResult.substring(0, 1);
		else
			sResult = sResult.substring(4, 8) + "-" + sResult.substring(2, 4) + "-" + sResult.substring(0, 2);
		
		return sResult;
	}
	
	/**
	 * @iDate: Formato YYYY-MM-DD.
	 * @Return: Formato DDMMYYYY
	 */
	public static String FormatDateInt(String iDate){
		String sResult = "";
		sResult = iDate.replace("-", "");

		sResult = sResult.substring(6) + "" + sResult.substring(4, 6) + "" + sResult.substring(0, 4);
			
		return sResult;
	}
	
	/**
	 * @iTime: Formato HHmmss.
	 */
	public static String FormatTime(int iTime){
		String sResult = "";
		sResult = String.valueOf(iTime);
		if(sResult.length() == 6)
			sResult = sResult.substring(0, 2) + ":" + sResult.substring(2, 4) + ":" + sResult.substring(4, 6);
		else
		{
			sResult = "0" + sResult;
			sResult = sResult.substring(0, 2) + ":" + sResult.substring(2, 4) + ":" + sResult.substring(4, 6);
		}
		
		return sResult;
	}
	
	/**
	 * sDate: Formato YYYYMMdd
	 */
	public int getDateToNumeric(Date d)
	{	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return Integer.parseInt(sdf.format(d));
	}
	
	/**
	 * @Return: Formato ddMMYYYY
	 */
	public int getDateToNumeric2(Date d)
	{	
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		return Integer.parseInt(sdf.format(d));
	}
	
	/**
	 * @Return: Formato HHmmss
	 */
	public int getTimeToNumeric(Date d)
	{	
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		return Integer.parseInt(sdf.format(d));
	}
	
	/**
	 * @Return: Formato YYYY-MM-DD
	 */
	public static String getDateToString(Date d)
	{	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(d);
	}
	
	/**
	 * @Return: Formato HH:mm:ss
	 */
	public static String getTimeTString(Date d)
	{	
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(d);
	}
	
	/**
	 * sDate: Formato YYYY-MM-dd HH:mm:ss.
	 */
	public static Date ConvertToDate(String sDate){
		java.util.Date currentDate = null;
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",new Locale("en,EN"));
		
		try {
			currentDate = formatDate.parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return currentDate;
	}
	
	public static int ConvertDateToJulianJDE(Date dt){
		//1000*(year-1900) + dayofyear
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		int yyyy = Integer.parseInt(sdf.format(dt));
		
		sdf = new SimpleDateFormat("D");
		int doy = Integer.parseInt(sdf.format(dt));
		
		return (1000*(yyyy - 1900) + doy);
		
	}
	
	public static boolean isNumber(String string)
	{
		if(string == null || string.isEmpty())
			return false;
		 
		int i = 0;
		if(string.charAt(0) == '-')
		{
			if(string.length() > 1)
				i++;
			else
				return false;
		}
		
		for (; i < string.length(); i++)
		{
			if(!Character.isDigit(string.charAt(i)))
				return false;
		}
		
		return true;
	}
}
