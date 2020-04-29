package br.com.cosati.iattend.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class iAttendUtil {

	public static String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return sdf.format(date);
	}
	
	public static Date formatDate(String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = sdf.parse(str);
		return date;
	}
	
	public static String dayOfWeek(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
		return sdf.format(date);
	}
	
	public static Date setTime(Date date, Integer hours, Integer minutes) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, hours);
		cal.set(Calendar.MINUTE, minutes);
		return cal.getTime();
	}
	
}
