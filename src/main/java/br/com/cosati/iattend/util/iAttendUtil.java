package br.com.cosati.iattend.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class iAttendUtil {

	public static String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(date);
	}
	
}
