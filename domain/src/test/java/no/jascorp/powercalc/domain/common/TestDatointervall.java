/**
 * 
 */
package no.jascorp.powercalc.domain.common;

import java.util.Date;

import org.junit.Test;
import static org.junit.Assert.*;
import static junitx.framework.Assert.assertNotEquals;

/**
 * @author Jørn Anders Svendsen
 *
 */
public class TestDatointervall extends EqualsHashCodeTestCase{

	@Override
	protected Object createInstance() throws Exception {
		return new Datointervall("01.01.2011", "01.01.2011");
	}

	@Override
	protected Object createNotEqualInstance() throws Exception {
		return new Datointervall("01.02.2011", "01.02.2011");
	}
	
	@Override
	protected Object[] createNullValueInstances() {
		return null;
	}

	
	@Test
	public void testBeregnAntallDager() {
		assertEquals("Uventet antall dager", 0, new Datointervall("01.01.2011", "01.01.2011").getAntallDagerForIntervall());
		assertEquals("Uventet antall dager", 1, new Datointervall("01.01.2011", "02.01.2011").getAntallDagerForIntervall());
		assertEquals("Uventet antall dager", 30, new Datointervall("01.01.2011", "31.01.2011").getAntallDagerForIntervall());
		assertEquals("Uventet antall dager", 58, new Datointervall("01.01.2011", "28.02.2011").getAntallDagerForIntervall());
		assertEquals("Uventet antall dager", 61, new Datointervall("01.01.2011", "31.02.2011").getAntallDagerForIntervall());
		assertEquals("Uventet antall dager", 61, new Datointervall("01.01.2011", "03.03.2011").getAntallDagerForIntervall());
		assertEquals("Uventet antall dager", 59, new Datointervall("01.02.2011", "01.04.2011").getAntallDagerForIntervall());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTilDatoBeforeFraDato() {
		new Datointervall("10.01.2011", "01.01.2011").getAntallDagerForIntervall();
	}

	@Test(expected=IllegalArgumentException.class)
	public void testFraDatoAsNull() {
		new Datointervall(null, new Date()).getAntallDagerForIntervall();
	}

	@Test(expected=IllegalArgumentException.class)
	public void testTilDatoAsNull() {
		new Datointervall(new Date(), null).getAntallDagerForIntervall();
	}

	@Test
	public void testUnequalDates() {
		assertNotEquals(new Datointervall("01.01.2011", "01.01.2011"), new Datointervall("01.01.2011", "02.01.2011"));
	}
}
