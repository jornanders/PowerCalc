package no.jascorp.powercalc.util;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

/**
 * @author Jørn Anders Svendsen
 *
 */
public class TestUtils {
	@Test
	public void testStringToDate() throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2011);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		assertEquals(cal.getTime(), Utils.stringToDate("01.01.2011"));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testStringToDateEmptyString() throws Exception {
		Utils.stringToDate("");
	}

	@Test(expected=NullPointerException.class)
	public void testStringToDateNullString() throws Exception {
		Utils.stringToDate(null);
	}
	
	@Test
	public void testDateToString() throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2011);
		assertEquals("01.01.2011", Utils.dateToString(cal.getTime()));
	}
	
	@Test
	public void testAssertNotNullEmptyString() throws Exception {
		Utils.assertNotNull("", "ikke exception");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testAssertNotNullWithNull() throws Exception {
		Utils.assertNotNull(null, "ikke exception");
	}
}
