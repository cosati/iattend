package br.com.cosati.iattend.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class iAttendUtil {

	public static String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(date);
	}
	
	public static Date formatDate(String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = sdf.parse(str);
		return date;
	}
	
}
