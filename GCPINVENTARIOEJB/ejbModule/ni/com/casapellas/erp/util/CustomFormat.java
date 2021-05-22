package ni.com.casapellas.erp.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CustomFormat  {

private	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
private DateTimeFormatter timeFommatter = DateTimeFormatter.ofPattern("HH:mm:ss");
private	DateFormat  dateformatter = new SimpleDateFormat("yyyyMMdd");
private	DateFormat  timeformatter = new SimpleDateFormat("HHmmss");
private	SimpleDateFormat commingDate = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
SimpleDateFormat formatterStandar = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");


	public String getActualDate() {
		
		return LocalDate.now().format(formatter).toString();
	}
	
	public String getActualTime() {
		
		return LocalDate.now().format(timeFommatter).toString();
	}
	
	public String formatDate(String fecha) throws ParseException {
		
		 return dateformatter.format(commingDate.parse(fecha));
	}
	
	public String formatTime(String fecha) throws ParseException {
		
		return timeformatter.format(commingDate.parse(fecha));
	}
	
	public String getCurrentStringDate() {
		Date date = new Date();
		return formatterStandar.format(date);
	}
}
