package no.jascorp.powercalc.domain.regning;

import static org.junit.Assert.assertEquals;
import no.jascorp.powercalc.domain.maaleavlesning.Maaleavlesning;
import no.jascorp.powercalc.domain.maaleavlesning.Maaleavlesninger;
import no.jascorp.powercalc.domain.maaleavlesning.Maalepunkt;

import org.junit.Test;

/**
 * @author Jørn Anders Svendsen
 *
 */
public class TestAvregning {
	
	@Test
	public void testProsentandelHovedmaaler() {
		assertEquals(1, Maalepunkt.HOVEDMAALER.beregnProsentandel(null, null), 0);
	}
	
	@Test
	public void testAvregningApril2012() throws Exception {
		Regning regning = new Regning("01.04.2012", "01.05.2012");
		regning.addRegningLinje(new RegningLinje(Avsender.LIER_EVERK, 718.97));
		regning.addRegningLinje(new RegningLinje(Avsender.LIER_EVERK, 97.92/2));
		regning.addRegningLinje(new RegningLinje(Avsender.EB, 1102.71));
		
		Maaleavlesninger avlesninger = new Maaleavlesninger();
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "25.03.2012", 31183));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "30.05.2012", 31925));
		
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.04.2012", 102002));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.05.2012", 104436));
		
		Avregning avregning = new Avregning(regning, avlesninger);
		avregning.beregnSum(Maalepunkt.HOVEDMAALER);
		assertEquals(259.21, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(regning.getSum() - 259.21, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}

	@Test
	public void testAvregningMars2012() throws Exception {
		Regning regning = new Regning("01.03.2012", "01.04.2012");
		regning.addRegningLinje(new RegningLinje(Avsender.LIER_EVERK, 863.53));
		regning.addRegningLinje(new RegningLinje(Avsender.LIER_EVERK, 97.92/2));
		regning.addRegningLinje(new RegningLinje(Avsender.EB, 1384.43));
		
		Maaleavlesninger avlesninger = new Maaleavlesninger();
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "18.01.2012", 29614));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "25.03.2012", 31183));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "30.05.2012", 31925));
		
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.03.2012", 98898));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.04.2012", 102002));
		
		Avregning avregning = new Avregning(regning, avlesninger);
		assertEquals(474.12, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(regning.getSum() - 474.12, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}
	
	@Test
	public void testAvregningFebruar2012() throws Exception {
		Regning regning = new Regning("01.02.2012", "01.03.2012");
		regning.addRegningLinje(new RegningLinje(Avsender.LIER_EVERK, 1771.72));
		regning.addRegningLinje(new RegningLinje(Avsender.LIER_EVERK, 96.31/2));
		regning.addRegningLinje(new RegningLinje(Avsender.EB, 1705.82));
		
		Maaleavlesninger avlesninger = new Maaleavlesninger();
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "18.01.2012", 29614));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "25.03.2012", 31183));
		
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.02.2012", 95007));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.03.2012", 98898));
		
		Avregning avregning = new Avregning(regning, avlesninger);
		assertEquals(615.36, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(regning.getSum() - 615.36, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}

	@Test
	public void testAvregningJanuar2012() throws Exception {
		Regning regning = new Regning("01.01.2012", "01.02.2012");
		regning.addRegningLinje(new RegningLinje(Avsender.LIER_EVERK, 1396.36));
		regning.addRegningLinje(new RegningLinje(Avsender.LIER_EVERK, 96.31/2));
		regning.addRegningLinje(new RegningLinje(Avsender.EB, 1715.98));
		
		Maaleavlesninger avlesninger = new Maaleavlesninger();
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "07.12.2011", 28542));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "18.01.2012", 29614));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "25.03.2012", 31183));
		
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.01.2012", 91106));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.02.2012", 95007));
		
		Avregning avregning = new Avregning(regning, avlesninger);
		assertEquals(617.16, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(regning.getSum() - 617.16, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}

	@Test
	public void testAvregningDesember2011() throws Exception {
		Regning regning = new Regning("01.12.2011", "01.01.2012");
		regning.addRegningLinje(new RegningLinje(Avsender.LIER_EVERK, 1365.80));
		regning.addRegningLinje(new RegningLinje(Avsender.LIER_EVERK, 98.18/2));
		regning.addRegningLinje(new RegningLinje(Avsender.EB, 1848.71));
		
		Maaleavlesninger avlesninger = new Maaleavlesninger();
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "07.10.2011", 27397));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "07.12.2011", 28542));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "18.01.2012", 29614));
		
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.12.2011", 86985));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.01.2012", 91106));
		
		Avregning avregning = new Avregning(regning, avlesninger);
		assertEquals(594.53, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(regning.getSum() - 594.53, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}

	@Test
	public void testAvregningNovember2011() throws Exception {
		Regning regning = new Regning("01.11.2011", "01.12.2011");
		regning.addRegningLinje(new RegningLinje(Avsender.LIER_EVERK, 1045.12));
		regning.addRegningLinje(new RegningLinje(Avsender.LIER_EVERK, 98.18/2));
		regning.addRegningLinje(new RegningLinje(Avsender.EB, 1222.75));
		
		Maaleavlesninger avlesninger = new Maaleavlesninger();
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "07.10.2011", 27397));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "07.12.2011", 28542));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "18.01.2012", 29614));
		
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.11.2011", 84333));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.12.2011", 86985));
		
		Avregning avregning = new Avregning(regning, avlesninger);
		assertEquals(491.97, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(regning.getSum() - 491.97, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}
	
	@Test
	public void testAvregningOktober2011() throws Exception {
		Regning regning = new Regning("01.10.2011", "01.11.2011");
		regning.addRegningLinje(new RegningLinje(Avsender.LIER_EVERK, 577.51));
		regning.addRegningLinje(new RegningLinje(Avsender.LIER_EVERK, 98.18/2));
		regning.addRegningLinje(new RegningLinje(Avsender.EB, 1024.69));
		
		Maaleavlesninger avlesninger = new Maaleavlesninger();
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "17.08.2011", 27030));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "07.10.2011", 27397));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "07.12.2011", 28542));
		
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.10.2011", 82034));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.11.2011", 84333));
		
		Avregning avregning = new Avregning(regning, avlesninger);
		assertEquals(368.07, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(regning.getSum() - 368.07, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}

	@Test
	public void testAvregningSeptember2011() throws Exception {
		Regning regning = new Regning("01.09.2011", "01.10.2011");
		regning.addRegningLinje(new RegningLinje(Avsender.LIER_EVERK, 382.05));
		regning.addRegningLinje(new RegningLinje(Avsender.LIER_EVERK, 98.18/2));
		regning.addRegningLinje(new RegningLinje(Avsender.EB, 785.78));
		
		Maaleavlesninger avlesninger = new Maaleavlesninger();
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "17.08.2011", 27030));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "07.10.2011", 27397));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "07.12.2011", 28542));
		
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.09.2011", 80322));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.10.2011", 82034));
		
		Avregning avregning = new Avregning(regning, avlesninger);
		assertEquals(153.45, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(regning.getSum() - 153.45, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}

	@Test
	public void testAvregningAugust2011() throws Exception {
		Regning regning = new Regning("01.08.2011", "01.09.2011");
		regning.addRegningLinje(new RegningLinje(Avsender.LIER_EVERK, 406.87));
		regning.addRegningLinje(new RegningLinje(Avsender.LIER_EVERK, 98.18/2));
		regning.addRegningLinje(new RegningLinje(Avsender.EB, 559.49));
		
		Maaleavlesninger avlesninger = new Maaleavlesninger();
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "24.05.2011", 26676));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "17.08.2011", 27030));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "07.10.2011", 27397));
		
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.08.2011", 79182));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.09.2011", 80322));
		
		Avregning avregning = new Avregning(regning, avlesninger);
		assertEquals(155.5, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(regning.getSum() - 155.5, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}

	@Test
	public void testAvregningJuli2011() throws Exception {
		Regning regning = new Regning("01.07.2011", "01.08.2011");
		regning.addRegningLinje(new RegningLinje(Avsender.LIER_EVERK, 418.64));
		regning.addRegningLinje(new RegningLinje(Avsender.LIER_EVERK, 98.18/2));
		regning.addRegningLinje(new RegningLinje(Avsender.EB, 563.09));
		
		Maaleavlesninger avlesninger = new Maaleavlesninger();
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "24.05.2011", 26676));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "17.08.2011", 27030));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "07.10.2011", 27397));
		
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.07.2011", 78033));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.08.2011", 79182));
		
		Avregning avregning = new Avregning(regning, avlesninger);
		assertEquals(115.8, avregning.beregnSum(Maalepunkt.HYBELMAALER), .03);
		assertEquals(regning.getSum() - 115.8, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .1);
	}

	@Test
	public void testAvregningJuni2011() throws Exception {
		Regning regning = new Regning("01.06.2011", "01.07.2011");
		regning.addRegningLinje(new RegningLinje(Avsender.LIER_EVERK, 509.73));
		regning.addRegningLinje(new RegningLinje(Avsender.LIER_EVERK, 98.18/2));
		regning.addRegningLinje(new RegningLinje(Avsender.EB, 530.90));
		
		Maaleavlesninger avlesninger = new Maaleavlesninger();
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "24.05.2011", 26676));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "17.08.2011", 27030));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "07.10.2011", 27397));
		
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.06.2011", 76956));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.07.2011", 78033));
		
		Avregning avregning = new Avregning(regning, avlesninger);
		assertEquals(126.42, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(963.30, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}
	
	@Test
	public void testAvregningMai2011() throws Exception {
		
		Regning regning = new Regning("01.05.2011", "01.06.2011");
		regning.addRegningLinje(new RegningLinje(Avsender.LIER_EVERK, 767.59));
		regning.addRegningLinje(new RegningLinje(Avsender.LIER_EVERK, 98.18/2));
		regning.addRegningLinje(new RegningLinje(Avsender.EB, 676.69));
		
		Maaleavlesninger avlesninger = new Maaleavlesninger();
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "22.03.2011", 26003));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "24.05.2011", 26676));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "17.08.2011", 27030));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.05.2011", 75524));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.06.2011", 76956));
		
		Avregning avregning = new Avregning(regning, avlesninger);
		assertEquals(19.5, avregning.beregnProsentandel(Maalepunkt.HYBELMAALER) * 100, .1);
		assertEquals(80.5, avregning.beregnProsentandel(Maalepunkt.HOVEDETASJE) * 100, .1);
		
		assertEquals(290.97, avregning.beregnSum(Maalepunkt.HYBELMAALER), 0.004);
		assertEquals(1202.40, avregning.beregnSum(Maalepunkt.HOVEDETASJE), 0.1);
	}
	
	@Test
	public void testAvregningApril2011() throws Exception {
		
		Regning regning = new Regning("01.04.2011", "01.05.2011");
		regning.addRegningLinje(new RegningLinje(Avsender.LIER_EVERK, 897.29));
		regning.addRegningLinje(new RegningLinje(Avsender.LIER_EVERK, 98.18/2));
		regning.addRegningLinje(new RegningLinje(Avsender.EB, 817.10));
		
		Maaleavlesninger avlesninger = new Maaleavlesninger();
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "22.03.2011", 26003));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HYBELMAALER, "24.05.2011", 26676));
		
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.04.2011", 73829));
		avlesninger.addMaaleavlesning(new Maaleavlesning(Maalepunkt.HOVEDMAALER, "01.05.2011", 75524));

		Avregning avregning = new Avregning(regning, avlesninger);
		assertEquals(18.9, avregning.beregnProsentandel(Maalepunkt.HYBELMAALER) * 100, .01);
		assertEquals(81.1, avregning.beregnProsentandel(Maalepunkt.HOVEDETASJE) * 100, .01);
		
		assertEquals(1375, avregning.beregnForbruk(Maalepunkt.HOVEDETASJE), .5);
		
		assertEquals(333.42, avregning.beregnSum(Maalepunkt.HYBELMAALER), .004);
		assertEquals(1430.06, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}
}
