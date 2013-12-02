package no.jascorp.powercalc.domain.regning;

import static no.jascorp.powercalc.domain.regning.RegningLinje.fraEB;
import static no.jascorp.powercalc.domain.regning.RegningLinje.fraLierEverk;
import static org.junit.Assert.assertEquals;

import java.util.List;

import no.jascorp.powercalc.domain.maaleavlesning.Maaleavlesning;
import no.jascorp.powercalc.domain.maaleavlesning.Maaleavlesninger;
import no.jascorp.powercalc.domain.maaleavlesning.Maalepunkt;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 * @author Jørn Anders Svendsen
 *
 */
public class TestAvregning {

	
	private static Maaleavlesninger maaleavlesninger;
	
	@BeforeClass
	public static void setup() {
		List<Maaleavlesning> avlesninger = Lists.newArrayList();
		avlesninger.addAll(hybel());
		avlesninger.addAll(hoved());
		maaleavlesninger = new Maaleavlesninger(avlesninger);
	}

	
	private static List<Maaleavlesning> hybel() {
		return ImmutableList.of(
				Maaleavlesning.forHybel().dato("22.03.2011").stand(26003).build(),
				Maaleavlesning.forHybel().dato("24.05.2011").stand(26676).build(),
				Maaleavlesning.forHybel().dato("17.08.2011").stand(27030).build(),
				Maaleavlesning.forHybel().dato("07.10.2011").stand(27397).build(),
				Maaleavlesning.forHybel().dato("07.12.2011").stand(28542).build(),
				Maaleavlesning.forHybel().dato("18.01.2012").stand(29614).build(),
				Maaleavlesning.forHybel().dato("25.03.2012").stand(31183).build(),
				Maaleavlesning.forHybel().dato("30.05.2012").stand(31925).build(),
				Maaleavlesning.forHybel().dato("28.08.2012").stand(32278).build(),
				Maaleavlesning.forHybel().dato("17.10.2012").stand(32801).build(),
				Maaleavlesning.forHybel().dato("22.01.2013").stand(35733).build(),
				Maaleavlesning.forHybel().dato("17.03.2013").stand(37486).build(),
				Maaleavlesning.forHybel().dato("29.06.2013").stand(38886).build(),
				Maaleavlesning.forHybel().dato("18.08.2013").stand(39102).build(),
				Maaleavlesning.forHybel().dato("01.10.2013").stand(39493).build(),
				Maaleavlesning.forHybel().dato("02.12.2013").stand(40736).build());
	}

	private static List<Maaleavlesning> hoved() {
		return ImmutableList.of(
				Maaleavlesning.forHoved().dato("01.04.2011").stand(73829).build(),
				Maaleavlesning.forHoved().dato("01.05.2011").stand(75524).build(),
				Maaleavlesning.forHoved().dato("01.06.2011").stand(76956).build(),
				Maaleavlesning.forHoved().dato("01.07.2011").stand(78033).build(),
				Maaleavlesning.forHoved().dato("01.08.2011").stand(79182).build(),
				Maaleavlesning.forHoved().dato("01.09.2011").stand(80322).build(),
				Maaleavlesning.forHoved().dato("01.10.2011").stand(82034).build(),
				Maaleavlesning.forHoved().dato("01.11.2011").stand(84333).build(),
				Maaleavlesning.forHoved().dato("01.12.2011").stand(86985).build(),
				Maaleavlesning.forHoved().dato("01.01.2012").stand(91106).build(),
				Maaleavlesning.forHoved().dato("01.02.2012").stand(95007).build(),
				Maaleavlesning.forHoved().dato("01.03.2012").stand(98898).build(),
				Maaleavlesning.forHoved().dato("01.04.2012").stand(102002).build(),
				Maaleavlesning.forHoved().dato("01.05.2012").stand(104436).build(),
				Maaleavlesning.forHoved().dato("01.06.2012").stand(106559).build(),
				Maaleavlesning.forHoved().dato("01.07.2012").stand(107912).build(),
				Maaleavlesning.forHoved().dato("01.08.2012").stand(109012).build(),
				Maaleavlesning.forHoved().dato("01.09.2012").stand(110477).build(),
				Maaleavlesning.forHoved().dato("01.10.2012").stand(112025).build(),
				Maaleavlesning.forHoved().dato("01.11.2012").stand(114663).build(),
				Maaleavlesning.forHoved().dato("01.12.2012").stand(118816).build(),
				Maaleavlesning.forHoved().dato("01.01.2013").stand(123414).build(),
				Maaleavlesning.forHoved().dato("01.02.2013").stand(129174).build(),
				Maaleavlesning.forHoved().dato("01.03.2013").stand(132268).build(),
				Maaleavlesning.forHoved().dato("01.04.2013").stand(136895).build(),
				Maaleavlesning.forHoved().dato("01.05.2013").stand(139457).build(),
				Maaleavlesning.forHoved().dato("01.06.2013").stand(141207).build(),
				Maaleavlesning.forHoved().dato("01.07.2013").stand(142797).build(),
				Maaleavlesning.forHoved().dato("01.08.2013").stand(143648).build(),
				Maaleavlesning.forHoved().dato("01.09.2013").stand(145041).build(),
				Maaleavlesning.forHoved().dato("01.10.2013").stand(146657).build(),
				Maaleavlesning.forHoved().dato("01.11.2013").stand(149112).build());
	}
	
	
	@Test
	public void testAvregningOktober2013() throws Exception {
		Avregning avregning = Regning
				.fra("01.10.2013").til("01.11.2013")
				.linje(fraLierEverk().medSum(954.94))
				.linje(fraLierEverk().medSum(98.18/2))
				.linje(fraEB().medSum(892.63))
				.medAvlesninger(maaleavlesninger);

		assertEquals(480.15d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(avregning.getRegning().getSum() - 480.15, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}

	@Test
	public void testAvregningSeptember2013() throws Exception {
		Avregning avregning = Regning
				.fra("01.09.2013").til("01.10.2013")
				.linje(fraLierEverk().medSum(597.74))
				.linje(fraLierEverk().medSum(98.18/2))
				.linje(fraEB().medSum(613.85))
				.medAvlesninger(maaleavlesninger);
		
		assertEquals(207.97d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(avregning.getRegning().getSum() - 207.97, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}
	
	@Test
	public void testAvregningAugust2013() throws Exception {
		Avregning avregning = Regning
				.fra("01.08.2013").til("01.09.2013")
				.linje(fraLierEverk().medSum(471.41))
				.linje(fraLierEverk().medSum(99.79/2))
				.linje(fraEB().medSum(543.23))
				.medAvlesninger(maaleavlesninger);
		
		assertEquals(151.20d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(avregning.getRegning().getSum() - 151.20, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}

	@Test
	public void testAvregningJuli2013() throws Exception {
		Avregning avregning = Regning
				.fra("01.07.2013").til("01.08.2013")
				.linje(fraLierEverk().medSum(288.52))
				.linje(fraLierEverk().medSum(99.79/2))
				.linje(fraEB().medSum(364.91))
				.medAvlesninger(maaleavlesninger);
		
		assertEquals(110.68, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(avregning.getRegning().getSum() - 110.68, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}

	@Test
	public void testAvregningJuni2013() throws Exception {
		Avregning avregning = Regning
				.fra("01.06.2013").til("01.07.2013")
				.linje(fraLierEverk().medSum(531.07))
				.linje(fraLierEverk().medSum(98.18/2))
				.linje(fraEB().medSum(605.31))
				.medAvlesninger(maaleavlesninger);
		
		assertEquals(287.46, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(avregning.getRegning().getSum() - 287.46, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}

	@Test
	public void testAvregningMai2013() throws Exception {
		Avregning avregning = Regning
				.fra("01.05.2013").til("01.06.2013")
				.linje(fraLierEverk().medSum(649.52))
				.linje(fraLierEverk().medSum(98.18/2))
				.linje(fraEB().medSum(660.69))
				.medAvlesninger(maaleavlesninger);
		
		assertEquals(324.14, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(avregning.getRegning().getSum() - 324.14, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}

	@Test
	public void testAvregningApril2013() throws Exception {
		Avregning avregning = Regning
				.fra("01.04.2013").til("01.05.2013")
				.linje(fraLierEverk().medSum(1200.77))
				.linje(fraLierEverk().medSum(98.18/2))
				.linje(fraEB().medSum(982.74))
				.medAvlesninger(maaleavlesninger);
		
		assertEquals(351.92, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(avregning.getRegning().getSum() - 351.92, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}

	@Test
	public void testAvregningMars2013() throws Exception {
		Avregning avregning = Regning
				.fra("01.03.2013").til("01.04.2013")
				.linje(fraLierEverk().medSum(2029.93))
				.linje(fraLierEverk().medSum(98.18/2))
				.linje(fraEB().medSum(1711.32))
				.medAvlesninger(maaleavlesninger);
		
		assertEquals(590.90, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(avregning.getRegning().getSum() - 590.90, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}

	@Test
	public void testAvregningFebruar2013() throws Exception {
		Avregning avregning = Regning
				.fra("01.02.2013").til("01.03.2013")
				.linje(fraLierEverk().medSum(1188.76))
				.linje(fraLierEverk().medSum(94.97/2))
				.linje(fraEB().medSum(1164.26))
				.medAvlesninger(maaleavlesninger);
		
		assertEquals(705.23, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(avregning.getRegning().getSum() - 705.23, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}

	@Test
	public void testAvregningJanuar2013() throws Exception {
		Avregning avregning = Regning
				.fra("01.01.2013").til("01.02.2013")
				.linje(fraLierEverk().medSum(2388.02))
				.linje(fraLierEverk().medSum(94.97/2))
				.linje(fraEB().medSum(2109.57))
				.medAvlesninger(maaleavlesninger);
		
		assertEquals(757.03, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(avregning.getRegning().getSum() - 757.03, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}

	@Test
	public void testAvregningDesember2012() throws Exception {
		Avregning avregning = Regning
				.fra("01.12.2012").til("01.01.2013")
				.linje(fraLierEverk().medSum(1838.23))
				.linje(fraLierEverk().medSum(97.92/2))
				.linje(fraEB().medSum(1687.11))
				.medAvlesninger(maaleavlesninger);
		
		assertEquals(728.41, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(avregning.getRegning().getSum() - 728.41, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}

	@Test
	public void testAvregningNovember2012() throws Exception {
		Avregning avregning = Regning
				.fra("01.11.2012").til("01.12.2012")
				.linje(fraLierEverk().medSum(1328.33))
				.linje(fraLierEverk().medSum(97.92/2))
				.linje(fraEB().medSum(1529.28))
				.medAvlesninger(maaleavlesninger);
		
		assertEquals(634.65, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(avregning.getRegning().getSum() - 634.65, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}

	@Test
	public void testAvregningOktober2012() throws Exception {
		Avregning avregning = Regning
				.fra("01.10.2012").til("01.11.2012")
				.linje(fraLierEverk().medSum(859.83))
				.linje(fraLierEverk().medSum(49.76))
				.linje(fraEB().medSum(1131.22))
				.medAvlesninger(maaleavlesninger);
		
		assertEquals(480.23, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(avregning.getRegning().getSum() - 480.23, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}

	@Test
	public void testAvregningSeptember2012() throws Exception {
		Avregning avregning = Regning
				.fra("01.09.2012").til("01.10.2012")
				.linje(fraLierEverk().medSum(279.43))
				.linje(fraLierEverk().medSum(48.16))
				.linje(fraEB().medSum(699.30))
				.medAvlesninger(maaleavlesninger);
		
		assertEquals(208.16, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(avregning.getRegning().getSum() - 208.16, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}
	
	@Test
	public void testAvregningAugust2012() throws Exception {
		Avregning avregning = Regning
				.fra("01.08.2012").til("01.09.2012")
				.linje(fraLierEverk().medSum(279.23))
				.linje(fraLierEverk().medSum(99.52/2))
				.linje(fraEB().medSum(669.65))
				.medAvlesninger(maaleavlesninger);
		
		assertEquals(100.71, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(avregning.getRegning().getSum() - 100.71, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}

	@Test
	public void testAvregningJuli2012() throws Exception {
		Avregning avregning = Regning
				.fra("01.07.2012").til("01.08.2012")
				.linje(fraLierEverk().medSum(143.15))
				.linje(fraLierEverk().medSum(99.52/2))
				.linje(fraEB().medSum(526.02))
				.medAvlesninger(maaleavlesninger);
		
		assertEquals(79.47, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(avregning.getRegning().getSum() - 79.47, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}

	@Test
	public void testAvregningJuni2012() throws Exception {
		Avregning avregning = Regning
				.fra("01.06.2012").til("01.07.2012")
				.linje(fraLierEverk().medSum(309.55))
				.linje(fraLierEverk().medSum(97.92/2))
				.linje(fraEB().medSum(622.56))
				.medAvlesninger(maaleavlesninger);
		
		assertEquals(85.32, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(avregning.getRegning().getSum() - 85.32, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}

	@Test
	public void testAvregningMai2012() throws Exception {
		Avregning avregning = Regning
				.fra("01.05.2012").til("01.06.2012")
				.linje(fraLierEverk().medSum(554.14))
				.linje(fraLierEverk().medSum(97.92/2))
				.linje(fraEB().medSum(928.57))
				.medAvlesninger(maaleavlesninger);
		
		assertEquals(240.88, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(avregning.getRegning().getSum() - 240.88, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}
	
	@Test
	public void testAvregningApril2012() throws Exception {
		Avregning avregning = Regning
				.fra("01.04.2012").til("01.05.2012")
				.linje(fraLierEverk().medSum(718.97))
				.linje(fraLierEverk().medSum(97.92/2))
				.linje(fraEB().medSum(1102.71))
				.medAvlesninger(maaleavlesninger);
		
		assertEquals(259.21, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(avregning.getRegning().getSum() - 259.21, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}

	@Test
	public void testAvregningMars2012() throws Exception {
		Avregning avregning = Regning
				.fra("01.03.2012").til("01.04.2012")
				.linje(fraLierEverk().medSum(863.53))
				.linje(fraLierEverk().medSum(97.92/2))
				.linje(fraEB().medSum(1384.43))
				.medAvlesninger(maaleavlesninger);
		
		assertEquals(474.12, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(avregning.getRegning().getSum() - 474.12, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}
	
	@Test
	public void testAvregningFebruar2012() throws Exception {
		Avregning avregning = Regning
				.fra("01.02.2012").til("01.03.2012")
				.linje(fraLierEverk().medSum(1771.72))
				.linje(fraLierEverk().medSum(96.31/2))
				.linje(fraEB().medSum(1705.82))
				.medAvlesninger(maaleavlesninger);
		
		assertEquals(615.36, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(avregning.getRegning().getSum() - 615.36, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}

	@Test
	public void testAvregningJanuar2012() throws Exception {
		Avregning avregning = Regning
				.fra("01.01.2012").til("01.02.2012")
				.linje(fraLierEverk().medSum(1396.36))
				.linje(fraLierEverk().medSum(96.31/2))
				.linje(fraEB().medSum(1715.98))
				.medAvlesninger(maaleavlesninger);

		assertEquals(617.16, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(avregning.getRegning().getSum() - 617.16, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}

	@Test
	public void testAvregningDesember2011() throws Exception {
		Avregning avregning = Regning
				.fra("01.12.2011").til("01.01.2012")
				.linje(fraLierEverk().medSum(1365.80))
				.linje(fraLierEverk().medSum(98.18/2))
				.linje(fraEB().medSum(1848.71))
				.medAvlesninger(maaleavlesninger);
		
		assertEquals(594.53, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(avregning.getRegning().getSum() - 594.53, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}

	@Test
	public void testAvregningNovember2011() throws Exception {
		Avregning avregning = Regning
				.fra("01.11.2011").til("01.12.2011")
				.linje(fraLierEverk().medSum(1045.12))
				.linje(fraLierEverk().medSum(98.18/2))
				.linje(fraEB().medSum(1222.75))
				.medAvlesninger(maaleavlesninger);
		
		assertEquals(491.97, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(avregning.getRegning().getSum() - 491.97, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}
	
	@Test
	public void testAvregningOktober2011() throws Exception {
		Avregning avregning = Regning
				.fra("01.10.2011").til("01.11.2011")
				.linje(fraLierEverk().medSum(577.51))
				.linje(fraLierEverk().medSum(98.18/2))
				.linje(fraEB().medSum(1024.69))
				.medAvlesninger(maaleavlesninger);
		
		assertEquals(368.07, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(avregning.getRegning().getSum() - 368.07, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}

	@Test
	public void testAvregningSeptember2011() throws Exception {
		Avregning avregning = Regning
				.fra("01.09.2011").til("01.10.2011")
				.linje(fraLierEverk().medSum(382.05))
				.linje(fraLierEverk().medSum(98.18/2))
				.linje(fraEB().medSum(785.78))
				.medAvlesninger(maaleavlesninger);

		assertEquals(153.46, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(avregning.getRegning().getSum() - 153.45, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}

	@Test
	public void testAvregningAugust2011() throws Exception {
		Avregning avregning = Regning
				.fra("01.08.2011").til("01.09.2011")
				.linje(fraLierEverk().medSum(406.87))
				.linje(fraLierEverk().medSum(98.18/2))
				.linje(fraEB().medSum(559.49))
				.medAvlesninger(maaleavlesninger);

		assertEquals(155.5, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(avregning.getRegning().getSum() - 155.5, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}

	@Test
	public void testAvregningJuli2011() throws Exception {
		Avregning avregning = Regning
				.fra("01.07.2011").til("01.08.2011")
				.linje(fraLierEverk().medSum(418.64))
				.linje(fraLierEverk().medSum(98.18/2))
				.linje(fraEB().medSum(563.09))
				.medAvlesninger(maaleavlesninger);

		assertEquals(115.8, avregning.beregnSum(Maalepunkt.HYBELMAALER), .03);
		assertEquals(avregning.getRegning().getSum() - 115.8, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .1);
	}

	@Test
	public void testAvregningJuni2011() throws Exception {
		Avregning avregning = Regning
				.fra("01.06.2011").til("01.07.2011")
				.linje(fraLierEverk().medSum(509.73))
				.linje(fraLierEverk().medSum(98.18/2))
				.linje(fraEB().medSum(530.90))
				.medAvlesninger(maaleavlesninger);

		assertEquals(126.42, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
		assertEquals(963.30, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}
	
	@Test
	public void testAvregningMai2011() throws Exception {
		Avregning avregning = Regning
				.fra("01.05.2011").til("01.06.2011")
				.linje(fraLierEverk().medSum(767.59))
				.linje(fraLierEverk().medSum(98.18/2))
				.linje(fraEB().medSum(676.69))
				.medAvlesninger(maaleavlesninger);
		
		assertEquals(19.5, avregning.beregnProsentandel(Maalepunkt.HYBELMAALER) * 100, .1);
		assertEquals(80.5, avregning.beregnProsentandel(Maalepunkt.HOVEDETASJE) * 100, .1);
		
		assertEquals(290.97, avregning.beregnSum(Maalepunkt.HYBELMAALER), 0.004);
		assertEquals(1202.40, avregning.beregnSum(Maalepunkt.HOVEDETASJE), 0.1);
	}
	
	@Test
	public void testAvregningApril2011() throws Exception {
		Avregning avregning = Regning
				.fra("01.04.2011").til("01.05.2011")
				.linje(fraLierEverk().medSum(897.29))
				.linje(fraLierEverk().medSum(98.18/2))
				.linje(fraEB().medSum(817.10))
				.medAvlesninger(maaleavlesninger);
		
		assertEquals(18.9, avregning.beregnProsentandel(Maalepunkt.HYBELMAALER) * 100, .01);
		assertEquals(81.1, avregning.beregnProsentandel(Maalepunkt.HOVEDETASJE) * 100, .01);
		
		assertEquals(1375, avregning.beregnForbruk(Maalepunkt.HOVEDETASJE), .5);
		
		assertEquals(333.42, avregning.beregnSum(Maalepunkt.HYBELMAALER), .004);
		assertEquals(1430.06, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
	}
	
	@Test
	public void testProsentandelHovedmaaler() {
		assertEquals(1, Maalepunkt.HOVEDMAALER.beregnProsentandel(null, null), 0);
	}

}
