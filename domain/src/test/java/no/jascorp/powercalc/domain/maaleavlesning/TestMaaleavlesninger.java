package no.jascorp.powercalc.domain.maaleavlesning;

import static org.junit.Assert.assertEquals;
import no.jascorp.powercalc.domain.common.Datointervall;
import no.jascorp.powercalc.domain.maaleavlesning.Maaleavlesning;
import no.jascorp.powercalc.domain.maaleavlesning.Maaleavlesninger;
import no.jascorp.powercalc.domain.maaleavlesning.Maalepunkt;

import org.junit.Test;

/**
 * @author Jørn Anders Svendsen
 */
public class TestMaaleavlesninger {
	
	@Test(expected=IllegalArgumentException.class)
	public void testIntervallStandUgyldig() {
		Maaleavlesninger avlesninger = new Maaleavlesninger();
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDETASJE, "01.01.2011", 100));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDETASJE, "01.02.2011", 50));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testIntervallMedSammeDato() {
		Maaleavlesninger avlesninger = new Maaleavlesninger();
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDETASJE, "01.01.2011", 100));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDETASJE, "01.01.2011", 100));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testAddNullAvlesning() {
		Maaleavlesninger avlesninger = new Maaleavlesninger();
		avlesninger.addMaaleavlesning(null);
	}
	
	@Test
	public void testBeregnForbrukWhenIntervallIsCompletelyBeforeAvlesningsintervall() {
		Maaleavlesninger avlesninger = new Maaleavlesninger();
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.02.2011", 1000));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.03.2011", 2000));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.04.2011", 3000));
		
		assertEquals(1000d, avlesninger.beregnForbrukForIntervall(new Datointervall("01.01.2011", "29.01.2011"), Maalepunkt.HOVEDMAALER), 0);
	}

	@Test
	public void testBeregnForbrukWhenIntervallIsAdjacentAvlesningsintervallBefore() {
		Maaleavlesninger avlesninger = new Maaleavlesninger();
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.02.2011", 1000));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.03.2011", 2000));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.04.2011", 3000));
		
		assertEquals(1000d, avlesninger.beregnForbrukForIntervall(new Datointervall("04.01.2011", "01.02.2011"), Maalepunkt.HOVEDMAALER), 0);
	}

	@Test
	public void testBeregnForbrukWhenIntervallIsCompletelyAfterAvlesningsintervall() {
		Maaleavlesninger avlesninger = new Maaleavlesninger();
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.02.2011", 1000));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.03.2011", 2000));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.04.2011", 3000));
		
		assertEquals(1000d, avlesninger.beregnForbrukForIntervall(new Datointervall("01.05.2011", "01.06.2011"), Maalepunkt.HOVEDMAALER), 0);
	}
	
	@Test
	public void testBeregnForbrukWhenIntervallIsAdjacentAvlesningsintervallAfter() {
		Maaleavlesninger avlesninger = new Maaleavlesninger();
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.02.2011", 1000));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.03.2011", 2000));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.04.2011", 3000));
		
		assertEquals(1000d, avlesninger.beregnForbrukForIntervall(new Datointervall("01.04.2011", "02.05.2011"), Maalepunkt.HOVEDMAALER), 0);
	}
	
	@Test
	public void testBeregnForbruk() {
		Maaleavlesninger avlesninger = new Maaleavlesninger();
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.02.2011", 66498));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.03.2011", 70334));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.04.2011", 73829));
		
		assertEquals(3836d, avlesninger.beregnForbrukForIntervall(new Datointervall("01.02.2011", "01.03.2011"), Maalepunkt.HOVEDMAALER), 0);
		assertEquals(3989d, avlesninger.beregnForbrukForIntervall(new Datointervall("04.02.2011", "06.03.2011"), Maalepunkt.HOVEDMAALER), 0.3);
		assertEquals(3495d, avlesninger.beregnForbrukForIntervall(new Datointervall("01.03.2011", "01.04.2011"), Maalepunkt.HOVEDMAALER), 0);
		assertEquals(7331d, avlesninger.beregnForbrukForIntervall(new Datointervall("01.02.2011", "01.04.2011"), Maalepunkt.HOVEDMAALER), 0);
	}

	@Test
	public void testBeregnForbrukHybelMarsApril2011() {
		Maaleavlesninger avlesninger = new Maaleavlesninger();
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "25.01.2011", 24256));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "22.03.2011", 26003));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "24.05.2011", 26676));
		
		assertEquals(1747d, avlesninger.beregnForbrukForIntervall(new Datointervall("25.01.2011", "22.03.2011"), Maalepunkt.HYBELMAALER), 0);
		assertEquals(673d, avlesninger.beregnForbrukForIntervall(new Datointervall("22.03.2011", "24.05.2011"), Maalepunkt.HYBELMAALER), 0);
		
		assertEquals(762d, avlesninger.beregnForbrukForIntervall(new Datointervall("01.03.2011", "01.04.2011"), Maalepunkt.HYBELMAALER), 0.1);
		assertEquals(320d, avlesninger.beregnForbrukForIntervall(new Datointervall("01.04.2011", "01.05.2011"), Maalepunkt.HYBELMAALER), 0.48);
	}

	@Test
	public void testBeregnForbrukHybelMaiJuni2011() {
		Maaleavlesninger avlesninger = new Maaleavlesninger();
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "25.01.2011", 24256));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "22.03.2011", 26003));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "24.05.2011", 26676));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "17.08.2011", 27030));
		
		assertEquals(354d, avlesninger.beregnForbrukForIntervall(new Datointervall("24.05.2011", "17.08.2011"), Maalepunkt.HYBELMAALER), 0);

		assertEquals(279d, avlesninger.beregnForbrukForIntervall(new Datointervall("01.05.2011", "01.06.2011"), Maalepunkt.HYBELMAALER), 0.1);
		assertEquals(125d, avlesninger.beregnForbrukForIntervall(new Datointervall("01.06.2011", "01.07.2011"), Maalepunkt.HYBELMAALER), 0.1);
		
	}

	@Test
	public void testBeregnForbrukHybelJanuarFebruar2011() {
		Maaleavlesninger avlesninger = new Maaleavlesninger();
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "15.12.2010", 22695));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "25.01.2011", 24256));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "22.03.2011", 26003));
		
		assertEquals(1561d, avlesninger.beregnForbrukForIntervall(new Datointervall("15.12.2010", "25.01.2011"), Maalepunkt.HYBELMAALER), 0);
		assertEquals(1747d, avlesninger.beregnForbrukForIntervall(new Datointervall("25.01.2011", "22.03.2011"), Maalepunkt.HYBELMAALER), 0);
		
		assertEquals(1132d, avlesninger.beregnForbrukForIntervall(new Datointervall("01.01.2011", "01.02.2011"), Maalepunkt.HYBELMAALER), 0.2);
		assertEquals(873.5d, avlesninger.beregnForbrukForIntervall(new Datointervall("01.02.2011", "01.03.2011"), Maalepunkt.HYBELMAALER), 0);
	}

	@Test
	public void testBeregnForbrukHybelNovemberDesember2010() {
		Maaleavlesninger avlesninger = new Maaleavlesninger();
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "20.11.2010", 21663));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "15.12.2010", 22695));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "25.01.2011", 24256));
		
		assertEquals(1032d, avlesninger.beregnForbrukForIntervall(new Datointervall("20.11.2010", "15.12.2010"), Maalepunkt.HYBELMAALER), 0);
		assertEquals(1561d, avlesninger.beregnForbrukForIntervall(new Datointervall("15.12.2010", "25.01.2011"), Maalepunkt.HYBELMAALER), 0);
		
		assertEquals(1238.4d, avlesninger.beregnForbrukForIntervall(new Datointervall("01.11.2010", "01.12.2010"), Maalepunkt.HYBELMAALER), 0);
		assertEquals(1225d, avlesninger.beregnForbrukForIntervall(new Datointervall("01.12.2010", "01.01.2011"), Maalepunkt.HYBELMAALER), .2);
	}
	
}
