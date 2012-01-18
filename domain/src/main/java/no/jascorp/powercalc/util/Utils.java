package no.jascorp.powercalc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Jørn Anders Svendsen
 */
public class Utils {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	
	public static Date stringToDate(String date) {
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	public static String dateToString(Date date) {
		return sdf.format(date);
	}
	
	public static void assertNotNull(Object object, String text) {
		if (object == null) {
			throw new IllegalArgumentException(text);
		}
	}
}
