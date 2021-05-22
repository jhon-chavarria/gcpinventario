package ni.com.casapellas.ejb.erp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DateTimeHelper {
	
	public static Date GetCurrentDate() {
		return new Date();
	}

	public static Integer CastDateToNumber(Date dt, String format) {
		String strDate = CastDateToString(dt, format);
		
		return Integer.parseInt(strDate);
	}
	
	public static String CastDateToString(Date dt, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		
		return formatter.format(dt);
	}
	
	public static Date CastStringToDate(String dt, String format) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		
		return formatter.parse(dt);
	}
	
	public static Integer CastTimeToNumber(Date dt) {
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		return Integer.parseInt(sdf.format(dt));
	}
	
	/**
	 * Valida si un cadena es una fecha valida segun el formato
	 * @param dt Cadena a validar
	 * @param format Formato contra el que se va a validar
	 * @return true / false
	 */
	public static boolean isValidDate(String dt, String format) {
		try {
			CastStringToDate(dt, format);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Agrega un valor a la fecha actual
	 * @param dt Fecha
	 * @param datePart Parte de fecha a trabajar
	 * @param part Valor a agregar a la fecha
	 * @return
	 */
	public static Date AddDatePartToDate(Date dt, String datePart, Integer part) {
		Calendar calendar = Calendar.getInstance();
		
		calendar.setTime(dt);
		
		switch (datePart) {
		case "y":
			calendar.add(Calendar.YEAR, part);
			break;
		case "m":
			calendar.add(Calendar.MONTH, part);
			break;
		case "d":
			calendar.add(Calendar.DATE, part);
			break;
		case "h":
			calendar.add(Calendar.HOUR, part);
			break;
		case "mi":
			calendar.add(Calendar.MINUTE, part);
			break;
		case "s":
			calendar.add(Calendar.SECOND, part);
			break;
		default:
			break;
		}
		
		return calendar.getTime();
	}
	
	/**
	 * Calcula la diferencia de tiempo entre dos fechas
	 * @param datePart Tipo de diferencia
	 * @param dateBefore Fecha inicial
	 * @param dateAfter Fecha final
	 * @param formatPattern Formato a usar
	 * @return Nuero que indica la diferencia de tiempo
	 */
	public static Long DateDiff(String datePart, String dateBefore, String dateAfter, String formatPattern) {
		Long result = (long) 0;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);
		
		LocalDate _dateBefore = LocalDate.parse(dateBefore, formatter);
		LocalDate _dateAfter = LocalDate.parse(dateAfter, formatter);
		
		switch (datePart) {
		case "d":
			result = ChronoUnit.DAYS.between(_dateBefore, _dateAfter);
			break;
		default:
			break;
		}
		
		return result;
	}
}
