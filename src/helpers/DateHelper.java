package helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import model.domain.TimeParked;

public class DateHelper {

	public static String getActualDay(Date date) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");

		return dateFormat.format(date);
	}

	public static String getActualHour(Date date) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

		return dateFormat.format(date);
	}

	public static TimeParked getTimeParked(String admissionDate, String admissionTime) {

		// 5/02/2021
		String[] admissionDateArray = admissionDate.split("/");
		int admissionDay = Integer.valueOf(admissionDateArray[0]);
		int admissionMonth = Integer.valueOf(admissionDateArray[1]);
		int admissionYear = Integer.valueOf(admissionDateArray[2]);

		String[] admissionTimeArray = admissionTime.split(":");
		int admissionHour = Integer.valueOf(admissionTimeArray[0]);
		int admissionMinutes = Integer.valueOf(admissionTimeArray[1]);
		int admissionSeconds = Integer.valueOf(admissionTimeArray[2]);

		Calendar admissionCalendar = Calendar.getInstance();
		admissionCalendar.set(admissionYear, admissionMonth - 1, admissionDay, admissionHour, admissionMinutes,
				admissionSeconds);

		Calendar actualCalendar = Calendar.getInstance();
		Date actualDate = actualCalendar.getTime();

		double result = Math.abs(actualDate.getTime() - admissionCalendar.getTimeInMillis()) / 1000;

		int secondsResult = 0;
		int minutesResult = 0;
		int hoursResult = 0;
		int daysResult = 0;

		if (result >= 60) {

			if (result >= 3600) {

				if (result >= 86400) {

					result = result / 86400;
					String[] expresion = (result + "").split("\\.");
					daysResult = Integer.valueOf(expresion[0]);

					if (expresion[1].equals("0")) {
						// end
					} else {
						result = (Double.valueOf("0." + expresion[1]) * 86400) / 3600;
						expresion = (result + "").split("\\.");
						hoursResult = Integer.valueOf(expresion[0]);

						if (("0." + expresion[1]).contains("0.00")) {
							// end
						} else {

							result = (Double.valueOf("0." + expresion[1]) * 60) + 0.0001;
							expresion = (result + "").split("\\.");
							minutesResult = Integer.valueOf(expresion[0]);

							if (("0." + expresion[1]).contains("0.00")) {
								// end
							} else {

								result = (Double.valueOf("0." + expresion[1]) * 60) + 0.0001;
								expresion = (result + "").split("\\.");
								secondsResult = Integer.valueOf(expresion[0]);

							}

						}
					}

				} else {

					result = result / 3600;
					String[] expresion = (result + "").split("\\.");
					hoursResult = Integer.valueOf(expresion[0]);
					result = (Double.valueOf("0." + expresion[1]) * 60) + 0.001;
					expresion = (result + "").split("\\.");
					minutesResult = Integer.valueOf(expresion[0]);
					secondsResult = (int) (Double.valueOf("0." + expresion[1]) * 60);

				}

			} else {
				result = result / 60;
				String[] expresion = (result + "").split("\\.");
				minutesResult = Integer.valueOf(expresion[0]);
				secondsResult = (int) (Double.valueOf("0." + expresion[1]) * 60);
			}

		} else {
			secondsResult = (int) result;
		}

		return new TimeParked(daysResult, hoursResult, minutesResult, secondsResult);

	}

}
