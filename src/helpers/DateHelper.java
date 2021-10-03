package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

	public static String getActualDay(Date date) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
		
		return dateFormat.format(date);
	}
	
public static String getActualHour(Date date) {
	
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		
		return dateFormat.format(date);
	}
	
}
