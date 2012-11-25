package br.com.thoughtworks.hotelreservation.application.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {

	public static final String PATTERN_DDMMMYYYY = "ddMMMyyyy";
	
	/**
	 * Returns a array with total weekends and weekdays in a period.
	 * Array's first position will be weekdays
	 * Array's second position will be weekends
	 * 
	 * @param to
	 * @param from
	 * @return DateDTO with total weekends and weekdays in a period.
	 * @throws Exception
	 */
	public static Integer[] weekdaysAndWeekendsByPeriod(final Date to, final Date from)
			throws Exception {
		Calendar calTo = Calendar.getInstance();
		Calendar calFrom = Calendar.getInstance();

		calTo.setTime(to);
		calFrom.setTime(from);

		int weekdays = 0;
		int weekends = 0;

		while (calFrom.after(calTo)) {
			if (calTo.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || calTo.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
				weekends++;
			} else {
				weekdays++;
			}
			calTo.add(Calendar.DATE, 1);
		}
		
		return new Integer[]{weekdays, weekends};
	}

	/**
	 * Returns a array with total weekends and weekdays in a period.
	 * Array's first position will be weekdays
	 * Array's second position will be weekends
	 * 
	 * @param to
	 * @param from
	 * @return DateDTO with total weekends and weekdays in a period.
	 * @throws Exception
	 */
	public static Integer[] weekdaysAndWeekendsByDates(final List<Date> dates)
			throws Exception {
		Calendar cal = Calendar.getInstance();
		
		int weekdays = 0;
		int weekends = 0;

		for(Date date : dates) {
			cal.setTime(date);
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
				weekends++;
			} else {
				weekdays++;
			}
		}
		
		return new Integer[]{weekdays, weekends};
	}

	public static Date parseStringToDate(String stringDate, String pattern) throws Exception{
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.parse(stringDate.trim());
	}
	
}
