package no.jascorp.powercalc.domain.maaleavlesning;

import no.jascorp.powercalc.domain.common.Datointervall;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestMaalepunkt {
	
	private Maaleavlesninger maaleavlesninger;
	private Datointervall datointervall = new Datointervall("01.01.2011", "01.02.2011");
	
	@Before
	public void setUp() {
		maaleavlesninger = new Maaleavlesninger();
		maaleavlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.01.2011", 0, 0 ));
		maaleavlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.02.2011", 1000, 0));
		maaleavlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "01.01.2011", 0, 0));
		maaleavlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "01.02.2011", 100, 0));
	}
	
	@Test
	public void testNullValue() throws Exception {
		assertEquals(0, Maalepunkt.NULL_VALUE.beregnForbruk(maaleavlesninger, datointervall), 0);
		assertEquals(0, Maalepunkt.NULL_VALUE.beregnProsentandel(maaleavlesninger, datointervall), 0);
	}

	@Test
	public void testHovedmaalerValue() throws Exception {
		assertEquals(1000, Maalepunkt.HOVEDMAALER.beregnForbruk(maaleavlesninger, datointervall), 0);
		assertEquals(1, Maalepunkt.HOVEDMAALER.beregnProsentandel(maaleavlesninger, datointervall), 0);
	}

	@Test
	public void testHybelmaalerValue() throws Exception {
		assertEquals(100, Maalepunkt.HYBELMAALER.beregnForbruk(maaleavlesninger, datointervall), 0);
		assertEquals(0.1, Maalepunkt.HYBELMAALER.beregnProsentandel(maaleavlesninger, datointervall), 0);
	}

	@Test
	public void testHovedetasjeValue() throws Exception {
		assertEquals(900, Maalepunkt.HOVEDETASJE.beregnForbruk(maaleavlesninger, datointervall), 0);
		assertEquals(0.9, Maalepunkt.HOVEDETASJE.beregnProsentandel(maaleavlesninger, datointervall), 0);
	}
}
