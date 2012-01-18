/**
 * 
 */
package no.jascorp.powercalc.domain.maaleavlesning;

import static junitx.framework.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import no.jascorp.powercalc.domain.common.EqualsHashCodeTestCase;

import org.junit.Test;

/**
 * @author Jørn Anders Svendsen
 *
 */
public class TestMaaleavlesning extends EqualsHashCodeTestCase {

	@Override
	protected Object createInstance() throws Exception {
		return new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.03.2011", 100);
	}

	@Override
	protected Object createNotEqualInstance() throws Exception {
		return new Maaleavlesning(Maalepunkt.HYBELMAALER, new Date(), 200);
	}

	@Override
	protected Object[] createNullValueInstances() {
		return new Object[]{
			new Maaleavlesning(Maalepunkt.HYBELMAALER, "01.01.2011", 0)
		};
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNullMaalepunkt() {
		new Maaleavlesning(null, "01.01.2011", 0);
	}

	@Test
	public void testToString() {
		new Maaleavlesning(Maalepunkt.HOVEDETASJE, "01.01.2011", 0).toString();
	}

	@Test
	public void testUnequalDate() {
		Maaleavlesning compareTo = new Maaleavlesning(Maalepunkt.HOVEDETASJE, "01.02.2011", 10);
		assertNotEquals(new Maaleavlesning(Maalepunkt.HOVEDETASJE, "01.01.2011", 10), compareTo);
	}

	@Test
	public void testUnequalStand() {
		Maaleavlesning compareTo = new Maaleavlesning(Maalepunkt.HOVEDETASJE, "01.01.2011", 20);
		assertNotEquals(new Maaleavlesning(Maalepunkt.HOVEDETASJE, "01.01.2011", 10), compareTo);
	}

	@Test
	public void testUnequalPunkt() {
		Maaleavlesning compareTo = new Maaleavlesning(Maalepunkt.HOVEDETASJE, "01.01.2011", 10);
		assertNotEquals(new Maaleavlesning(Maalepunkt.HYBELMAALER, "01.01.2011", 10), compareTo);
	}

	@Test
	public void testCompareTo() {
		Maaleavlesning first = new Maaleavlesning(Maalepunkt.HYBELMAALER, "01.01.2011", 10);
		Maaleavlesning second = new Maaleavlesning(Maalepunkt.HYBELMAALER, "02.01.2011", 10);
		assertEquals(-1, first.compareTo(second));
		assertEquals(1, second.compareTo(first));
	}
}
