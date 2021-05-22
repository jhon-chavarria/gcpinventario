package ni.com.casapellas.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;


public class DateFormatUtil {

	
	 public String getTimesStampDate()
	   {  
		 try {
			    long startDate = System.currentTimeMillis() ;
				long startNanoseconds = System.nanoTime() ; 
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
				long microSeconds = (System.nanoTime() - startNanoseconds) / 1000;
				long date =  startDate + (microSeconds / 1000);
				return  dateFormat.format(date) + String.format("%03d", microSeconds % 1000) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Timestamp(0).toString();
	   }
}
