package helpers;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculationHelper {
	
	public static double calculateAmountPayable(int days, int hours, int minutes, int seconds, double priceByHour) {
		double result = 0;
		
		if(days == 0 && hours == 0 && minutes < 15) {
			result = priceByHour/2;
		} else {
			int minutesParked = (days*24*60) + (hours*60) + minutes;
			result = ((minutesParked - 15)/60)*priceByHour + priceByHour ;
		}
		BigDecimal bd = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);
		result = bd.doubleValue();
		return result;
	}
}
