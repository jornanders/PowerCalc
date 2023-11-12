package no.jascorp.powercalc.domain.regning;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import no.jascorp.powercalc.domain.maaleavlesning.Maaleavlesning;
import no.jascorp.powercalc.domain.maaleavlesning.Maaleavlesninger;
import no.jascorp.powercalc.domain.maaleavlesning.Maalepunkt;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

import static no.jascorp.powercalc.domain.regning.RegningLinje.*;
import static org.junit.Assert.assertEquals;

/**
 * @author Jørn Anders Svendsen
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
                Maaleavlesning.forHybel().dato("02.12.2013").stand(40736).build(),
                Maaleavlesning.forHybel().dato("23.02.2014").stand(43191).build(),
                Maaleavlesning.forHybel().dato("15.06.2014").stand(44618).build(),
                Maaleavlesning.forHybel().dato("01.09.2014").stand(44909).build(),
                Maaleavlesning.forHybel().dato("26.03.2015").stand(49231).build(),
                Maaleavlesning.forHybel().dato("09.06.2015").stand(50322).build(),
                Maaleavlesning.forHybel().dato("06.04.2016").stand(55771).build(),
                Maaleavlesning.forHybel().dato("31.07.2016").stand(56553).build(),
                Maaleavlesning.forHybel().dato("21.11.2016").stand(57809).build(),
                Maaleavlesning.forHybel().dato("12.01.2017").stand(59074).build(),
                Maaleavlesning.forHybel().dato("01.04.2017").stand(61048).build(),
                Maaleavlesning.forHybel().dato("26.05.2017").stand(61925).build(),
                Maaleavlesning.forHybel().dato("26.07.2017").stand(62111).build(),
                Maaleavlesning.forHybel().dato("13.12.2017").stand(63928).build(),
                Maaleavlesning.forHybel().dato("05.02.2018").stand(65464).build(),
                Maaleavlesning.forHybel().dato("18.03.2018").stand(66619).build(),
                Maaleavlesning.forHybel().dato("16.12.2018").stand(69157).build(),
                Maaleavlesning.forHybel().dato("30.12.2018").stand(69564).build(),
                Maaleavlesning.forHybel().dato("15.01.2019").stand(70103).build(),
                Maaleavlesning.forHybel().dato("04.03.2019").stand(71601).build(),
                Maaleavlesning.forHybel().dato("20.03.2019").stand(72037).build(),
                Maaleavlesning.forHybel().dato("15.06.2019").stand(73183).build(),
                Maaleavlesning.forHybel().dato("25.12.2019").stand(76085).build(),

                Maaleavlesning.forHybel().dato("01.03.2020").stand(77795).build(),
                Maaleavlesning.forHybel().dato("22.04.2020").stand(78722).build(),
                Maaleavlesning.forHybel().dato("06.05.2020").stand(78861).build(),
                Maaleavlesning.forHybel().dato("01.06.2020").stand(79080).build(),
                Maaleavlesning.forHybel().dato("06.07.2020").stand(79242).build(),
                Maaleavlesning.forHybel().dato("17.08.2020").stand(79437).build(),
                Maaleavlesning.forHybel().dato("01.09.2020").stand(79517).build(),
                Maaleavlesning.forHybel().dato("02.10.2020").stand(79715).build(),
                Maaleavlesning.forHybel().dato("01.11.2020").stand(80038).build(),
                Maaleavlesning.forHybel().dato("03.12.2020").stand(80520).build(),
                Maaleavlesning.forHybel().dato("08.01.2021").stand(81240).build(),
                Maaleavlesning.forHybel().dato("01.02.2021").stand(82006).build(),
                Maaleavlesning.forHybel().dato("01.03.2021").stand(82846).build(),
                Maaleavlesning.forHybel().dato("09.04.2021").stand(83580).build(),
                Maaleavlesning.forHybel().dato("11.05.2021").stand(84094).build(),
                Maaleavlesning.forHybel().dato("01.06.2021").stand(84325).build(),
                Maaleavlesning.forHybel().dato("15.06.2021").stand(84436).build(),
                //Julia
                Maaleavlesning.forHybel().dato("16.08.2021").stand(84886).build(),
                Maaleavlesning.forHybel().dato("01.09.2021").stand(85009).build(),
                Maaleavlesning.forHybel().dato("01.10.2021").stand(85317).build(),
                Maaleavlesning.forHybel().dato("01.11.2021").stand(85755).build(),
                Maaleavlesning.forHybel().dato("01.12.2021").stand(86516).build(),
                Maaleavlesning.forHybel().dato("02.01.2022").stand(87147).build(),
                Maaleavlesning.forHybel().dato("31.01.2022").stand(88054).build(),
                Maaleavlesning.forHybel().dato("24.04.2022").stand(89931).build(),
                Maaleavlesning.forHybel().dato("02.05.2022").stand(90076).build(),
                Maaleavlesning.forHybel().dato("30.05.2022").stand(90448).build(),
                Maaleavlesning.forHybel().dato("01.08.2022").stand(90927).build(),
                Maaleavlesning.forHybel().dato("01.09.2022").stand(91130).build(),
                Maaleavlesning.forHybel().dato("01.10.2022").stand(91363).build(),
                Maaleavlesning.forHybel().dato("04.11.2022").stand(91833).build(),
                Maaleavlesning.forHybel().dato("04.01.2023").stand(93399).build(),
                Maaleavlesning.forHybel().dato("09.03.2023").stand(95644).build(),
                Maaleavlesning.forHybel().dato("09.04.2023").stand(96766).build(),
                Maaleavlesning.forHybel().dato("06.05.2023").stand(97255).build(),
                Maaleavlesning.forHybel().dato("01.06.2023").stand(97717).build(),
                Maaleavlesning.forHybel().dato("15.08.2023").stand(98298).build(),
                Maaleavlesning.forHybel().dato("02.09.2023").stand(98436).build(),
                Maaleavlesning.forHybel().dato("03.10.2023").stand(98776).build(),
                Maaleavlesning.forHybel().dato("04.11.2023").stand(99588).build()
        );
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
                Maaleavlesning.forHoved().dato("01.11.2013").stand(149112).build(),
                Maaleavlesning.forHoved().dato("01.12.2013").stand(152849).build(),
                Maaleavlesning.forHoved().dato("01.01.2014").stand(156519).build(),
                Maaleavlesning.forHoved().dato("01.02.2014").stand(160487).build(),
                Maaleavlesning.forHoved().dato("01.03.2014").stand(164859).build(),
                Maaleavlesning.forHoved().dato("01.04.2014").stand(167786).build(),
                Maaleavlesning.forHoved().dato("01.05.2014").stand(170128).build(),
                Maaleavlesning.forHoved().dato("01.06.2014").stand(172389).build(),
                Maaleavlesning.forHoved().dato("01.07.2014").stand(173673).build(),
                Maaleavlesning.forHoved().dato("01.08.2014").stand(174594).build(),
                Maaleavlesning.forHoved().dato("01.09.2014").stand(176033).build(),
                Maaleavlesning.forHoved().dato("01.10.2014").stand(177503).build(),
                Maaleavlesning.forHoved().dato("01.11.2014").stand(180195).build(),
                Maaleavlesning.forHoved().dato("08.12.2014").stand(184199).build(),
                Maaleavlesning.forHoved().dato("01.01.2015").stand(187683).build(),
                Maaleavlesning.forHoved().dato("09.02.2015").stand(193547).build(),
                Maaleavlesning.forHoved().dato("01.03.2015").stand(196261).build(),
                Maaleavlesning.forHoved().dato("06.04.2015").stand(200221).build(),
                Maaleavlesning.forHoved().dato("01.05.2015").stand(202416).build(),
                Maaleavlesning.forHoved().dato("01.06.2015").stand(204839).build(),
                Maaleavlesning.forHoved().dato("01.07.2015").stand(206379).build(),
                Maaleavlesning.forHoved().dato("01.08.2015").stand(207662).build(),
                Maaleavlesning.forHoved().dato("01.09.2015").stand(208916).build(),
                Maaleavlesning.forHoved().dato("01.10.2015").stand(210472).build(),
                Maaleavlesning.forHoved().dato("01.11.2015").stand(213263).build(),
                Maaleavlesning.forHoved().dato("01.12.2015").stand(217322).build(),
                Maaleavlesning.forHoved().dato("01.01.2016").stand(221213).build(),
                Maaleavlesning.forHoved().dato("01.02.2016").stand(226129).build(),
                Maaleavlesning.forHoved().dato("01.03.2016").stand(230090).build(),
                Maaleavlesning.forHoved().dato("01.04.2016").stand(235306).build(),
                Maaleavlesning.forHoved().dato("25.04.2016").stand(237516).build(),
                Maaleavlesning.forHoved().dato("01.05.2016").stand(238105).build(),
                Maaleavlesning.forHoved().dato("01.06.2016").stand(239891).build(),
                Maaleavlesning.forHoved().dato("13.06.2016").stand(240425).build(),
                Maaleavlesning.forHoved().dato("01.07.2016").stand(241337).build(),
                Maaleavlesning.forHoved().dato("01.08.2016").stand(242470).build(),
                Maaleavlesning.forHoved().dato("01.09.2016").stand(243878).build(),
                Maaleavlesning.forHoved().dato("12.09.2016").stand(244543).build(),
                Maaleavlesning.forHoved().dato("01.10.2016").stand(246207).build(),
                Maaleavlesning.forHoved().dato("01.11.2016").stand(247786).build(),
                Maaleavlesning.forHoved().dato("22.11.2016").stand(250396).build(),
                Maaleavlesning.forHoved().dato("01.12.2016").forbruk(909).build(),
                Maaleavlesning.forHoved().dato("01.01.2017").forbruk(3424).build(),
                Maaleavlesning.forHoved().dato("01.02.2017").forbruk(3937).build(),
                Maaleavlesning.forHoved().dato("01.03.2017").forbruk(3425).build(),
                Maaleavlesning.forHoved().dato("01.04.2017").forbruk(3392).build(),
                Maaleavlesning.forHoved().dato("01.05.2017").forbruk(2894).build(),
                Maaleavlesning.forHoved().dato("01.06.2017").forbruk(2208).build(),
                Maaleavlesning.forHoved().dato("01.07.2017").forbruk(1699).build(),
                Maaleavlesning.forHoved().dato("01.08.2017").forbruk(1245).build(),
                Maaleavlesning.forHoved().dato("01.09.2017").forbruk(1664).build(),
                Maaleavlesning.forHoved().dato("01.10.2017").forbruk(1935).build(),
                Maaleavlesning.forHoved().dato("01.11.2017").forbruk(2644).build(),
                Maaleavlesning.forHoved().dato("01.12.2017").forbruk(3465).build(),
                Maaleavlesning.forHoved().dato("01.01.2018").forbruk(5135).build(),
                Maaleavlesning.forHoved().dato("01.02.2018").forbruk(5434).build(),
                Maaleavlesning.forHoved().dato("01.03.2018").forbruk(4786).build(),

                Maaleavlesning.forHoved().dato("01.04.2018").forbruk(4555).build(),
                Maaleavlesning.forHoved().dato("01.05.2018").forbruk(3256).build(),
                Maaleavlesning.forHoved().dato("01.06.2018").forbruk(2226).build(),
                Maaleavlesning.forHoved().dato("01.07.2018").forbruk(1842).build(),
                Maaleavlesning.forHoved().dato("01.08.2018").forbruk(1051).build(),
                Maaleavlesning.forHoved().dato("01.09.2018").forbruk(1710).build(),
                Maaleavlesning.forHoved().dato("01.10.2018").forbruk(2252).build(),
                Maaleavlesning.forHoved().dato("01.11.2018").forbruk(3057).build(),
                Maaleavlesning.forHoved().dato("01.12.2018").forbruk(4042).build(),
                Maaleavlesning.forHoved().dato("30.12.2018").forbruk(4883).build(),

                Maaleavlesning.forHoved().dato("01.02.2019").forbruk(5737).build(),
                Maaleavlesning.forHoved().dato("01.03.2019").forbruk(4527).build(),
                Maaleavlesning.forHoved().dato("01.04.2019").forbruk(4252).build(),
                Maaleavlesning.forHoved().dato("01.05.2019").forbruk(2809).build(),
                Maaleavlesning.forHoved().dato("01.06.2019").forbruk(2601).build(),
                Maaleavlesning.forHoved().dato("01.07.2019").forbruk(1960).build(),
                Maaleavlesning.forHoved().dato("01.08.2019").forbruk(1605).build(),
                Maaleavlesning.forHoved().dato("01.09.2019").forbruk(1822).build(),
                Maaleavlesning.forHoved().dato("01.10.2019").forbruk(2208).build(),
                Maaleavlesning.forHoved().dato("01.11.2019").forbruk(3420).build(),
                Maaleavlesning.forHoved().dato("01.12.2019").forbruk(4094).build(),

                Maaleavlesning.forHoved().dato("01.01.2020").forbruk(4814).build(),
                Maaleavlesning.forHoved().dato("01.02.2020").forbruk(4029).build(),
                Maaleavlesning.forHoved().dato("01.03.2020").forbruk(3741).build(),
                Maaleavlesning.forHoved().dato("01.04.2020").forbruk(3767).build(),
                Maaleavlesning.forHoved().dato("01.05.2020").forbruk(2845).build(),
                Maaleavlesning.forHoved().dato("01.06.2020").forbruk(2548).build(),
                Maaleavlesning.forHoved().dato("01.07.2020").forbruk(1810).build(),
                Maaleavlesning.forHoved().dato("01.08.2020").forbruk(1418).build(),
                Maaleavlesning.forHoved().dato("01.09.2020").forbruk(1710).build(),
                Maaleavlesning.forHoved().dato("01.10.2020").forbruk(1943).build(),
                Maaleavlesning.forHoved().dato("01.11.2020").forbruk(2816).build(),
                Maaleavlesning.forHoved().dato("01.12.2020").forbruk(3292).build(),
                Maaleavlesning.forHoved().dato("01.01.2021").forbruk(4144).build(),
                Maaleavlesning.forHoved().dato("01.02.2021").forbruk(5471).build(),
                Maaleavlesning.forHoved().dato("01.03.2021").forbruk(4932).build(),
                Maaleavlesning.forHoved().dato("01.04.2021").forbruk(3651).build(),
                Maaleavlesning.forHoved().dato("01.05.2021").forbruk(2998).build(),
                Maaleavlesning.forHoved().dato("01.06.2021").forbruk(2841).build(),
                Maaleavlesning.forHoved().dato("01.07.2021").forbruk(2122).build(),
                Maaleavlesning.forHoved().dato("01.08.2021").forbruk(1260).build(),
                Maaleavlesning.forHoved().dato("01.09.2021").forbruk(1919).build(),
                Maaleavlesning.forHoved().dato("01.10.2021").forbruk(2166).build(),
                Maaleavlesning.forHoved().dato("01.11.2021").forbruk(2608).build(),
                Maaleavlesning.forHoved().dato("01.12.2021").forbruk(3564).build(),
                Maaleavlesning.forHoved().dato("01.01.2022").forbruk(4028).build(),
                Maaleavlesning.forHoved().dato("01.02.2022").forbruk(3574).build(),
                Maaleavlesning.forHoved().dato("01.03.2022").forbruk(3181).build(),
                Maaleavlesning.forHoved().dato("01.04.2022").forbruk(3294).build(),
                Maaleavlesning.forHoved().dato("01.05.2022").forbruk(2491).build(),
                Maaleavlesning.forHoved().dato("01.06.2022").forbruk(2053).build(),
                Maaleavlesning.forHoved().dato("01.07.2022").forbruk(1756).build(),
                Maaleavlesning.forHoved().dato("01.08.2022").forbruk(1075).build(),
                Maaleavlesning.forHoved().dato("01.09.2022").forbruk(1312).build(),
                Maaleavlesning.forHoved().dato("01.10.2022").forbruk(1685).build(),
                Maaleavlesning.forHoved().dato("01.11.2022").forbruk(2366).build(),
                Maaleavlesning.forHoved().dato("01.12.2022").forbruk(3252).build(),
                Maaleavlesning.forHoved().dato("01.01.2023").forbruk(4562).build(),
                Maaleavlesning.forHoved().dato("01.02.2023").forbruk(4857).build(),
                Maaleavlesning.forHoved().dato("01.03.2023").forbruk(4103).build(),
                Maaleavlesning.forHoved().dato("01.04.2023").forbruk(4708).build(),
                Maaleavlesning.forHoved().dato("01.05.2023").forbruk(2971).build(),
                Maaleavlesning.forHoved().dato("01.06.2023").forbruk(2856).build(),
                Maaleavlesning.forHoved().dato("01.07.2023").forbruk(1675).build(),
                Maaleavlesning.forHoved().dato("01.08.2023").forbruk(1383).build(),
                Maaleavlesning.forHoved().dato("25.08.2023").forbruk(1343).build(),
                //vibb
                Maaleavlesning.forHoved().dato("01.09.2023").forbruk(427).build(),
                Maaleavlesning.forHoved().dato("01.10.2023").forbruk(2293).build(),
                Maaleavlesning.forHoved().dato("01.11.2023").forbruk(3558).build()

        );
    }

    @Test
    public void testAvregningOktober2023() {
        Avregning avregning = Regning
                .fra("01.10.2023").til("01.11.2023")
                .linje(fraGlitreStrøm().medSum(4508))
                .medAvlesninger(maaleavlesninger);

        assertEquals(960.15, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 960.15, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningSeptember2023() {
        Avregning avregning = Regning
                .fra("01.09.2023").til("01.10.2023")
                .linje(fraGlitreStrøm().medSum(1849))
                .medAvlesninger(maaleavlesninger);

        assertEquals(262.66, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 262.66, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningAugust2023() {
        Avregning avregning = Regning
                .fra("01.08.2023").til("01.09.2023")
                .linje(fraGlitreStrøm().medSum(519+1519))
                .medAvlesninger(maaleavlesninger);

        assertEquals(274.94, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 274.94, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningJuli2023() {
        Avregning avregning = Regning
                .fra("01.07.2023").til("01.08.2023")
                .linje(fraGlitreStrøm().medSum(2022))
                .medAvlesninger(maaleavlesninger);

        assertEquals(351.10, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 351.10, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningJuni2023() {
        Avregning avregning = Regning
                .fra("01.06.2023").til("01.07.2023")
                .linje(fraGlitreStrøm().medSum(3002))
                .medAvlesninger(maaleavlesninger);

        assertEquals(416.52, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 416.52, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningMai2023() {
        Avregning avregning = Regning
                .fra("01.05.2023").til("01.06.2023")
                .linje(fraGlitreStrøm().medSum(4948))
                .medAvlesninger(maaleavlesninger);

        assertEquals(957.30, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 957.30, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningApril2023() {
        Avregning avregning = Regning
                .fra("01.04.2023").til("01.05.2023")
                .linje(fraGlitreStrøm().medSum(5836))
                .medAvlesninger(maaleavlesninger);

        assertEquals(1351.44, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 1351.44, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }
    @Test
    public void testAvregningMars2023() {
        Avregning avregning = Regning
                .fra("01.03.2023").til("01.04.2023")
                .linje(fraGlitreStrøm().medSum(7217))
                .medAvlesninger(maaleavlesninger);

        assertEquals(1706.26, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 1706.26, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningFebruar2023() {
        Avregning avregning = Regning
                .fra("01.02.2023").til("01.03.2023")
                .linje(fraGlitreStrøm().medSum(6289))
                .medAvlesninger(maaleavlesninger);

        assertEquals(1505.48, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 1505.48, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }
    @Test
    public void testAvregningJanuar2023() {
        Avregning avregning = Regning
                .fra("01.01.2023").til("01.02.2023")
                .linje(fraGlitreStrøm().medSum(7625))
                .medAvlesninger(maaleavlesninger);

        assertEquals(1662.84, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 1662.84, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }


    @Test
    public void testAvregningDesember2022() {
        Avregning avregning = Regning
                .fra("01.12.2022").til("01.01.2023")
                .linje(fraGlitreStrøm().medSum(9353))
                .medAvlesninger(maaleavlesninger);

        assertEquals(1631.62, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 1631.62, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningNovember2022() {
        Avregning avregning = Regning
                .fra("01.11.2022").til("01.12.2022")
                .linje(fraGlitreStrøm().medSum(5839))
                .medAvlesninger(maaleavlesninger);

        assertEquals(1319.01, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 1319.01, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningOktober2022() {
        Avregning avregning = Regning
                .fra("01.10.2022").til("01.11.2022")
                .linje(fraGlitreStrøm().medSum(4500))
                .linje(fraGlitreNett().medSum(135))
                .medAvlesninger(maaleavlesninger);

        assertEquals(549.94, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 549.94, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningSeptember2022() {
        Avregning avregning = Regning
                .fra("01.09.2022").til("01.10.2022")
                .linje(fraGlitreStrøm().medSum(7989))
                .linje(fraGlitreNett().medSum(-4012))
                .medAvlesninger(maaleavlesninger);

        assertEquals(549.94, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 549.94, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningAugust2022() {
        Avregning avregning = Regning
                .fra("01.08.2022").til("01.09.2022")
                .linje(fraGlitreStrøm().medSum(6082))
                .linje(fraGlitreNett().medSum(-2602))
                .medAvlesninger(maaleavlesninger);

        assertEquals(538.45, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 538.45, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningMai2022() {
        Avregning avregning = Regning
                .fra("01.05.2022").til("01.06.2022")
                .linje(fraGlitreStrøm().medSum(4743))
                .linje(fraGlitreNett().medSum(-1185))
                .medAvlesninger(maaleavlesninger);

        assertEquals(722.17, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 722.17, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningApril2022() {
        Avregning avregning = Regning
                .fra("01.04.2022").til("01.05.2022")
                .linje(fraGlitreStrøm().medSum(5822))
                .linje(fraGlitreNett().medSum(-1454))
                .medAvlesninger(maaleavlesninger);

        assertEquals(1134.54, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 1134.54, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningMars2022() {
        Avregning avregning = Regning
                .fra("01.03.2022").til("01.04.2022")
                .linje(fraGlitreStrøm().medSum(8299))
                .linje(fraGlitreNett().medSum(-2616))
                .medAvlesninger(maaleavlesninger);

        assertEquals(1209.49, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 1209.49, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningFebruar2022() {
        Avregning avregning = Regning
                .fra("01.02.2022").til("01.03.2022")
                .linje(fraGlitreStrøm().medSum(5186))
                .linje(fraGlitreNett().medSum(-409))
                .medAvlesninger(maaleavlesninger);

        assertEquals(950.90, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 950.90, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningJanuar2022() {
        Avregning avregning = Regning
                .fra("01.01.2022").til("01.02.2022")
                .linje(fraGlitreStrøm().medSum(6771))
                .linje(fraGlitreNett().medSum(-1183))
                .medAvlesninger(maaleavlesninger);

        assertEquals(1484.30, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 1484.30, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningDesember2021() {
        Avregning avregning = Regning
                .fra("01.12.2021").til("01.01.2022")
                .linje(fraGlitreStrøm().medSum(9301))
                .linje(fraGlitreNett().medSum(-1077))
                .medAvlesninger(maaleavlesninger);

        assertEquals(1248.06, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 1248.06, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningNovember2021() {
        Avregning avregning = Regning
                .fra("01.11.2021").til("01.12.2021")
                .linje(fraGlitreStrøm().medSum(5481))
                .linje(fraGlitreNett().medSum(1695))
                .medAvlesninger(maaleavlesninger);

        assertEquals(1532.25, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 1532.25, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningOktober2021() {
        Avregning avregning = Regning
                .fra("01.10.2021").til("01.11.2021")
                .linje(fraGlitreStrøm().medSum(3563))
                .linje(fraGlitreNett().medSum(1302))
                .medAvlesninger(maaleavlesninger);

        assertEquals(817.05, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 817.05, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningSeptember2021() {
        Avregning avregning = Regning
                .fra("01.09.2021").til("01.10.2021")
                .linje(fraGlitreStrøm().medSum(3250))
                .linje(fraGlitreNett().medSum(1001))
                .medAvlesninger(maaleavlesninger);

        assertEquals(604.48, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 604.48, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningAugust2021() {
        Avregning avregning = Regning
                .fra("16.08.2021").til("01.09.2021")
                .linje(fraGlitreStrøm().medSum(2096/31*16))
                .linje(fraGlitreNett().medSum(922/31*16))
                .medAvlesninger(maaleavlesninger);

        assertEquals(190.75, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 190.75, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningJuni2021() {
        Avregning avregning = Regning
                .fra("01.06.2021").til("16.06.2021")
                .linje(fraGlitreStrøm().medSum(1519/2))
                .linje(fraGlitreNett().medSum(983/2))
                .medAvlesninger(maaleavlesninger);

        assertEquals(108.14, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 108.14, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningMai2021() {
        Avregning avregning = Regning
                .fra("01.05.2021").til("01.06.2021")
                .linje(fraGlitreStrøm().medSum(2113))
                .linje(fraGlitreNett().medSum(1262))
                .medAvlesninger(maaleavlesninger);

        assertEquals(465.24, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 465.24, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningApril2021() {
        Avregning avregning = Regning
                .fra("01.04.2021").til("01.05.2021")
                .linje(fraGlitreStrøm().medSum(2116))
                .linje(fraGlitreNett().medSum(1306))
                .medAvlesninger(maaleavlesninger);

        assertEquals(575.21, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 575.21, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningMars2021() {
        Avregning avregning = Regning
                .fra("01.03.2021").til("01.04.2021")
                .linje(fraGlitreStrøm().medSum(2395))
                .linje(fraGlitreNett().medSum(1700))
                .medAvlesninger(maaleavlesninger);

        assertEquals(654.39, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 654.39, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningFebruar2021() {
        Avregning avregning = Regning
                .fra("01.02.2021").til("01.03.2021")
                .linje(fraGlitreStrøm().medSum(4285))
                .linje(fraGlitreNett().medSum(2234))
                .medAvlesninger(maaleavlesninger);

        assertEquals(1110.29, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 1110.29, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningJanuar2021() {
        Avregning avregning = Regning
                .fra("01.01.2021").til("01.02.2021")
                .linje(fraGlitreStrøm().medSum(4287))
                .linje(fraGlitreNett().medSum(2478))
                .medAvlesninger(maaleavlesninger);

        assertEquals(1120.29, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 1120.29, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningDesember2020() {
        Avregning avregning = Regning
                .fra("01.12.2020").til("01.01.2021")
                .linje(fraGlitreStrøm().medSum(1632))
                .linje(fraGlitreNett().medSum(2016))
                .medAvlesninger(maaleavlesninger);

        assertEquals(537.10, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 537.10, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningNovember2020() {
        Avregning avregning = Regning
                .fra("01.11.2020").til("01.12.2020")
                .linje(fraGlitreStrøm().medSum(781))
                .linje(fraGlitreNett().medSum(1630))
                .medAvlesninger(maaleavlesninger);

        assertEquals(330.94, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 330.94, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningOktober2020() {
        Avregning avregning = Regning
                .fra("01.10.2020").til("01.11.2020")
                .linje(fraGlitreStrøm().medSum(1030))
                .linje(fraGlitreNett().medSum(1505))
                .medAvlesninger(maaleavlesninger);

        assertEquals(296.52, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 296.52, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningSeptember2020() {
        Avregning avregning = Regning
                .fra("01.09.2020").til("01.10.2020")
                .linje(fraGlitreStrøm().medSum(593))
                .linje(fraGlitreNett().medSum(1024))
                .medAvlesninger(maaleavlesninger);

        assertEquals(159.46, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 159.46, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningAugust2020() {
        Avregning avregning = Regning
                .fra("01.08.2020").til("01.09.2020")
                .linje(fraGlitreStrøm().medSum(378))
                .linje(fraGlitreNett().medSum(917))
                .medAvlesninger(maaleavlesninger);

        assertEquals(116.84, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 116.84, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningJuli2020() {
        Avregning avregning = Regning
                .fra("01.07.2020").til("01.08.2020")
                .linje(fraGlitreStrøm().medSum(275))
                .linje(fraGlitreNett().medSum(779))
                .medAvlesninger(maaleavlesninger);

        assertEquals(106.93, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 106.93, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningJuni2020() {
        Avregning avregning = Regning
                .fra("01.06.2020").til("01.07.2020")
                .linje(fraGlitreStrøm().medSum(338))
                .linje(fraGlitreNett().medSum(961))
                .medAvlesninger(maaleavlesninger);

        assertEquals(99.65, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 99.65, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningMai2020() {
        Avregning avregning = Regning
                .fra("01.05.2020").til("01.06.2020")
                .linje(fraGlitreStrøm().medSum(673))
                .linje(fraGlitreNett().medSum(1315))
                .medAvlesninger(maaleavlesninger);

        assertEquals(209.60, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 209.60, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningApril2020() {
        Avregning avregning = Regning
                .fra("01.04.2020").til("01.05.2020")
                .linje(fraGlitreStrøm().medSum(604))
                .linje(fraGlitreNett().medSum(1452))
                .medAvlesninger(maaleavlesninger);

        assertEquals(335.12, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 335.12, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningMars2020() {
        Avregning avregning = Regning
                .fra("01.03.2020").til("01.04.2020")
                .linje(fraGlitreStrøm().medSum(965))
                .linje(fraGlitreNett().medSum(1833))
                .medAvlesninger(maaleavlesninger);

        assertEquals(410.48, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 410.48, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningFebruar2020() {
        Avregning avregning = Regning
                .fra("01.02.2020").til("01.03.2020")
                .linje(fraGlitreStrøm().medSum(1121))
                .linje(fraGlitreNett().medSum(1958))
                .medAvlesninger(maaleavlesninger);

        assertEquals(609.17, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 609.17, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningJanuar2020() {
        Avregning avregning = Regning
                .fra("01.01.2020").til("01.02.2020")
                .linje(fraGlitreStrøm().medSum(1795))
                .linje(fraGlitreNett().medSum(2108))
                .medAvlesninger(maaleavlesninger);

        assertEquals(766.45, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 766.45, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningDesember2019() {
        Avregning avregning = Regning
                .fra("01.12.2019").til("01.01.2020")
                .linje(fraGlitreStrøm().medSum(2954))
                .linje(fraGlitreNett().medSum(2391))
                .medAvlesninger(maaleavlesninger);

        assertEquals(599.04, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 599.04, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }


    @Test
    public void testAvregningNovember2019() {
        Avregning avregning = Regning
                .fra("01.11.2019").til("01.12.2019")
                .linje(fraGlitreStrøm().medSum(2900))
                .linje(fraGlitreNett().medSum(2122))
                .medAvlesninger(maaleavlesninger);

        assertEquals(553.34, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 553.34, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningOktober2019() {
        Avregning avregning = Regning
                .fra("01.10.2019").til("01.11.2019")
                .linje(fraGlitreStrøm().medSum(2190))
                .linje(fraGlitreNett().medSum(1793))
                .medAvlesninger(maaleavlesninger);

        assertEquals(542.86, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 542.86, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningSeptember2019() {
        Avregning avregning = Regning
                .fra("01.09.2019").til("01.10.2019")
                .linje(fraGlitreStrøm().medSum(1210))
                .linje(fraGlitreNett().medSum(1142))
                .medAvlesninger(maaleavlesninger);

        assertEquals(480.51, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 480.51, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningAugust2019() {
        Avregning avregning = Regning
                .fra("01.08.2019").til("01.09.2019")
                .linje(fraGlitreStrøm().medSum(1065))
                .linje(fraGlitreNett().medSum(964))
                .medAvlesninger(maaleavlesninger);

        assertEquals(519.08, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 519.08, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningJuli2019() {
        Avregning avregning = Regning
                .fra("01.07.2019").til("01.08.2019")
                .linje(fraGlitreStrøm().medSum(914))
                .linje(fraGlitreNett().medSum(862))
                .medAvlesninger(maaleavlesninger);

        assertEquals(515.79, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 515.79, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningJuni2019() {
        Avregning avregning = Regning
                .fra("01.06.2019").til("01.07.2019")
                .linje(fraGlitreStrøm().medSum(996))
                .linje(fraGlitreNett().medSum(1025))
                .medAvlesninger(maaleavlesninger);

        assertEquals(438.22, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 438.22, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningMai2019() {
        Avregning avregning = Regning
                .fra("01.05.2019").til("01.06.2019")
                .linje(fraGlitreStrøm().medSum(1560))
                .linje(fraGlitreNett().medSum(1327))
                .medAvlesninger(maaleavlesninger);

        assertEquals(453.25, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 453.25, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningApril2019() {
        Avregning avregning = Regning
                .fra("01.04.2019").til("01.05.2019")
                .linje(fraGlitreStrøm().medSum(1732))
                .linje(fraGlitreNett().medSum(1425))
                .medAvlesninger(maaleavlesninger);

        assertEquals(444.13, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 444.13, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningMars2019() {
        Avregning avregning = Regning
                .fra("01.03.2019").til("01.04.2019")
                .linje(fraGlitreStrøm().medSum(2709))
                .linje(fraGlitreNett().medSum(2212))
                .medAvlesninger(maaleavlesninger);

        assertEquals(795.89, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 795.89, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningFebruar2019() {
        Avregning avregning = Regning
                .fra("01.02.2019").til("01.03.2019")
                .linje(fraGlitreStrøm().medSum(3125))
                .linje(fraGlitreNett().medSum(2329))
                .medAvlesninger(maaleavlesninger);

        assertEquals(1052.77, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 1052.77, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningJanuar2019() {
        Avregning avregning = Regning
                .fra("15.01.2019").til("01.02.2019")
                .linje(fraGlitreStrøm().medSum(4499 / 2)) //deler på 2 fordi summen kun gjelder halve måneden
                .linje(fraGlitreNett().medSum(2936 / 2))
                .medAvlesninger(maaleavlesninger);

        assertEquals(667.25, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 667.25, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningDesember2018() {
        Avregning avregning = Regning
                .fra("01.12.2018").til("01.01.2019")
                .linje(fraGlitreStrøm().medSum(3485))
                .linje(fraGlitreNett().medSum(2517))
                .medAvlesninger(maaleavlesninger);

        assertEquals(704.34, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 704.34, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningNovember2018() {
        Avregning avregning = Regning
                .fra("01.11.2018").til("01.12.2018")
                .linje(fraGlitreStrøm().medSum(2777.99))
                .linje(fraGlitreNett().medSum(2134.48))
                .medAvlesninger(maaleavlesninger);

        assertEquals(338.96, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 338.96, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningOktober2018() {
        Avregning avregning = Regning
                .fra("01.10.2018").til("01.11.2018")
                .linje(fraGlitreStrøm().medSum(1870.34))
                .linje(fraGlitreNett().medSum(1574.08))
                .medAvlesninger(maaleavlesninger);

        assertEquals(324.72, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 324.72, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningSeptember2018() {
        Avregning avregning = Regning
                .fra("01.09.2018").til("01.10.2018")
                .linje(fraGlitreStrøm().medSum(1516.97))
                .linje(fraGlitreNett().medSum(1184.20))
                .medAvlesninger(maaleavlesninger);

        assertEquals(334.53, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 334.53, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningAugust2018() {
        Avregning avregning = Regning
                .fra("01.08.2018").til("01.09.2018")
                .linje(fraGlitreStrøm().medSum(1258.23))
                .linje(fraGlitreNett().medSum(926.99))
                .medAvlesninger(maaleavlesninger);

        assertEquals(368.29, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 368.29, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningJuli2018() {
        Avregning avregning = Regning
                .fra("01.07.2018").til("01.08.2018")
                .linje(fraGlitreStrøm().medSum(794.90))
                .linje(fraGlitreNett().medSum(610.63))
                .medAvlesninger(maaleavlesninger);

        assertEquals(385.42, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 385.42, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningJuni2018() {
        Avregning avregning = Regning
                .fra("01.06.2018").til("01.07.2018")
                .linje(fraGlitreStrøm().medSum(821.60))
                .linje(fraGlitreNett().medSum(884.22))
                .medAvlesninger(maaleavlesninger);

        assertEquals(258.28, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 258.28, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningAprilMai2018() {
        Avregning avregning = Regning
                .fra("01.04.2018").til("01.06.2018")
                .linje(fraGlitreStrøm().medSum(2423.27))
                .linje(fraTibber().medSum(670))
                .linje(fraGlitreNett().medSum(1171.70))
                .linje(fraGlitreNett().medSum(1742.47))
                .medAvlesninger(maaleavlesninger);

        assertEquals(621.45, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 621.45, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningMars2018() {
        Avregning avregning = Regning
                .fra("01.03.2018").til("01.04.2018")
                .linje(fraGlitreStrøm().medSum(2704.96))
                .linje(fraGlitreNett().medSum(2392.21))
                .medAvlesninger(maaleavlesninger);

        assertEquals(681.55, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 681.55, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningFebruar2018() {
        Avregning avregning = Regning
                .fra("01.02.2018").til("01.03.2018")
                .linje(fraGlitreStrøm().medSum(2445.54))
                .linje(fraGlitreNett().medSum(2511.75))
                .medAvlesninger(maaleavlesninger);

        assertEquals(818.14, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 818.14, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningJanuar2018() {
        Avregning avregning = Regning
                .fra("01.01.2018").til("01.02.2018")
                .linje(fraGlitreStrøm().medSum(2379.28))
                .linje(fraGlitreNett().medSum(2827.14))
                .medAvlesninger(maaleavlesninger);

        assertEquals(844.85, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 844.85, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningDesember2017() {
        Avregning avregning = Regning
                .fra("01.12.2017").til("01.01.2018")
                .linje(fraGlitreStrøm().medSum(2166.49))
                .linje(fraGlitreNett().medSum(2670.21))
                .medAvlesninger(maaleavlesninger);

        assertEquals(655.74, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 655.74, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningNovember2017() {
        Avregning avregning = Regning
                .fra("01.11.2017").til("01.12.2017")
                .linje(fraGlitreStrøm().medSum(1439.54))
                .linje(fraGlitreNett().medSum(1836.40))
                .medAvlesninger(maaleavlesninger);

        assertEquals(368.11, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 368.11, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningOktober2017() {
        Avregning avregning = Regning
                .fra("01.10.2017").til("01.11.2017")
                .linje(fraGlitreStrøm().medSum(969.89))
                .linje(fraGlitreNett().medSum(1363.47))
                .medAvlesninger(maaleavlesninger);

        assertEquals(355.07, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 355.07, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningSeptember2017() {
        Avregning avregning = Regning
                .fra("01.09.2017").til("01.10.2017")
                .linje(fraGlitreStrøm().medSum(771.20))
                .linje(fraGlitreNett().medSum(1028.68))
                .medAvlesninger(maaleavlesninger);

        assertEquals(362.17, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 362.17, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningAugust2017() {
        Avregning avregning = Regning
                .fra("01.08.2017").til("01.09.2017")
                .linje(fraGlitreStrøm().medSum(605.09))
                .linje(fraGlitreNett().medSum(896.00))
                .medAvlesninger(maaleavlesninger);

        assertEquals(362.95, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 362.95, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningJuli2017() {
        Avregning avregning = Regning
                .fra("01.07.2017").til("01.08.2017")
                .linje(fraGlitreStrøm().medSum(458.41))
                .linje(fraGlitreNett().medSum(699.66))
                .medAvlesninger(maaleavlesninger);

        assertEquals(143.34, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 143.34, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningJuni2017() throws Exception {
        Avregning avregning = Regning
                .fra("01.06.2017").til("01.07.2017")
                .linje(fraGlitreStrøm().medSum(560.01))
                .linje(fraGlitreNett().medSum(916.26))
                .medAvlesninger(maaleavlesninger);

        assertEquals(79.48, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 79.48, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningMai2017() throws Exception {
        Avregning avregning = Regning
                .fra("01.05.2017").til("01.06.2017")
                .linje(fraGlitreStrøm().medSum(838.79))
                .linje(fraGlitreNett().medSum(1105.37))
                .medAvlesninger(maaleavlesninger);

        assertEquals(367.11, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 367.11, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningApril2017() throws Exception {
        Avregning avregning = Regning
                .fra("01.04.2017").til("01.05.2017")
                .linje(fraGlitreStrøm().medSum(1103.08))
                .linje(fraGlitreNett().medSum(1464.06))
                .medAvlesninger(maaleavlesninger);

        assertEquals(424.34, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 424.34, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningMars2017() throws Exception {
        Avregning avregning = Regning
                .fra("01.03.2017").til("01.04.2017")
                .linje(fraGlitreStrøm().medSum(1322.45))
                .linje(fraGlitreNett().medSum(1698.92))
                .medAvlesninger(maaleavlesninger);

        assertEquals(689.97, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 689.97, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }


    @Test
    public void testAvregningFebruar2017() throws Exception {
        Avregning avregning = Regning
                .fra("01.02.2017").til("01.03.2017")
                .linje(fraGlitreStrøm().medSum(1329.96))
                .linje(fraGlitreNett().medSum(1717.21))
                .medAvlesninger(maaleavlesninger);

        assertEquals(622.46, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 622.46, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningJanuar2017() throws Exception {
        Avregning avregning = Regning
                .fra("01.01.2017").til("01.02.2017")
                .linje(fraGlitreStrøm().medSum(1571.45))
                .linje(fraGlitreNett().medSum(1952.16))
                .medAvlesninger(maaleavlesninger);

        assertEquals(686.77, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 686.77, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningDesember2016() throws Exception {
        Avregning avregning = Regning
                .fra("01.12.2016").til("01.01.2017")
                .linje(fraGlitreStrøm().medSum(1449.79))
                .linje(fraGlitreNett().medSum(1703.04))
                .medAvlesninger(maaleavlesninger);

        assertEquals(694.41, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 694.41, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningNovember2016() throws Exception {
        Avregning avregning = Regning
                .fra("01.11.2016").til("01.12.2016")
                .linje(fraGlitreStrøm().medSum(1777.75))
                .linje(fraGlitreNett().medSum(1733.19))
                .medAvlesninger(maaleavlesninger);

        assertEquals(464.50, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 464.50, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningOktober2016() throws Exception {
        Avregning avregning = Regning
                .fra("01.10.2016").til("01.11.2016")
                .linje(fraGlitreStrøm().medSum(697.05))
                .linje(fraGlitreNett().medSum(778.38))
                .medAvlesninger(maaleavlesninger);

        assertEquals(321.97, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 321.97, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningSeptember2016() throws Exception {
        Avregning avregning = Regning
                .fra("01.09.2016").til("01.10.2016")
                .linje(fraGlitreStrøm().medSum(768.52))
                .linje(fraGlitreNett().medSum(1048.34))
                .medAvlesninger(maaleavlesninger);

        assertEquals(260.13, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 260.13, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningAugust2016() throws Exception {
        Avregning avregning = Regning
                .fra("01.08.2016").til("01.09.2016")
                .linje(fraGlitreStrøm().medSum(401.85))
                .linje(fraGlitreStrøm().medSum(99.52 / 2))
                .linje(fraGlitreNett().medSum(1281.27 / 2))
                .medAvlesninger(maaleavlesninger);

        assertEquals(267.29d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 267.29, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningJuli2016() throws Exception {
        Avregning avregning = Regning
                .fra("01.07.2016").til("01.08.2016")
                .linje(fraGlitreStrøm().medSum(345.97))
                .linje(fraGlitreStrøm().medSum(99.52 / 2))
                .linje(fraGlitreNett().medSum(1281.27 / 2))
                .medAvlesninger(maaleavlesninger);

        assertEquals(195.16d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 195.16, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningJuni2016() throws Exception {
        Avregning avregning = Regning
                .fra("01.06.2016").til("01.07.2016")
                .linje(fraLierEverk().medSum(453.82))
                .linje(fraLierEverk().medSum(97.92 / 2))
                .linje(fraEB().medSum(1624.20 / 2))
                .medAvlesninger(maaleavlesninger);

        assertEquals(183.90d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 183.90, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningMai2016() throws Exception {
        Avregning avregning = Regning
                .fra("01.05.2016").til("01.06.2016")
                .linje(fraLierEverk().medSum(521.99))
                .linje(fraLierEverk().medSum(97.92 / 2))
                .linje(fraEB().medSum(1624.20 / 2))
                .medAvlesninger(maaleavlesninger);

        assertEquals(161.83d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 161.83, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningApril2016() throws Exception {
        Avregning avregning = Regning
                .fra("01.04.2016").til("01.05.2016")
                .linje(fraLierEverk().medSum(794.68))
                .linje(fraLierEverk().medSum(97.92 / 2))
                .linje(fraEB().medSum(3954.76 / 2))
                .medAvlesninger(maaleavlesninger);

        assertEquals(260.79d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 260.79, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningMars2016() throws Exception {
        Avregning avregning = Regning
                .fra("01.03.2016").til("01.04.2016")
                .linje(fraLierEverk().medSum(1467.87))
                .linje(fraLierEverk().medSum(97.92 / 2))
                .linje(fraEB().medSum(3954.76 / 2))
                .medAvlesninger(maaleavlesninger);

        assertEquals(374.70d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 374.70, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningFebruar2016() throws Exception {
        Avregning avregning = Regning
                .fra("01.02.2016").til("01.03.2016")
                .linje(fraLierEverk().medSum(1025.73))
                .linje(fraLierEverk().medSum(96.31 / 2))
                .linje(fraEB().medSum(4362.16 / 2))
                .medAvlesninger(maaleavlesninger);

        assertEquals(429.98d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 429.98, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningJanuar2016() throws Exception {
        Avregning avregning = Regning
                .fra("01.01.2016").til("01.02.2016")
                .linje(fraLierEverk().medSum(2003.50))
                .linje(fraLierEverk().medSum(96.31 / 2))
                .linje(fraEB().medSum(4362.16 / 2))
                .medAvlesninger(maaleavlesninger);

        assertEquals(481.59d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 481.59, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningDesember2015() throws Exception {
        Avregning avregning = Regning
                .fra("01.12.2015").til("01.01.2016")
                .linje(fraLierEverk().medSum(919.35))
                .linje(fraLierEverk().medSum(98.18 / 2))
                .linje(fraEB().medSum(3558.59 / 2))
                .medAvlesninger(maaleavlesninger);

        assertEquals(394.99d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 394.99, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningNovember2015() throws Exception {
        Avregning avregning = Regning
                .fra("01.11.2015").til("01.12.2015")
                .linje(fraLierEverk().medSum(1274.32))
                .linje(fraLierEverk().medSum(98.18 / 2))
                .linje(fraEB().medSum(3558.59 / 2))
                .medAvlesninger(maaleavlesninger);

        assertEquals(413.76d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 413.76, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningOktober2015() throws Exception {
        Avregning avregning = Regning
                .fra("01.10.2015").til("01.11.2015")
                .linje(fraLierEverk().medSum(768.40))
                .linje(fraLierEverk().medSum(98.18 / 2))
                .linje(fraEB().medSum(1925.49 / 2))
                .medAvlesninger(maaleavlesninger);

        assertEquals(356.77d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 356.77, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningSeptember2015() throws Exception {
        Avregning avregning = Regning
                .fra("01.09.2015").til("01.10.2015")
                .linje(fraLierEverk().medSum(273.02))
                .linje(fraLierEverk().medSum(98.18 / 2))
                .linje(fraEB().medSum(1925.49 / 2))
                .medAvlesninger(maaleavlesninger);

        assertEquals(446.97d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 446.97, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningAugust2015() throws Exception {
        Avregning avregning = Regning
                .fra("01.08.2015").til("01.09.2015")
                .linje(fraLierEverk().medSum(185.14))
                .linje(fraLierEverk().medSum(99.79 / 2))
                .linje(fraEB().medSum(1193.33 / 2))
                .medAvlesninger(maaleavlesninger);

        assertEquals(370.97d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 370.97, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningJuli2015() throws Exception {
        Avregning avregning = Regning
                .fra("01.07.2015").til("01.08.2015")
                .linje(fraLierEverk().medSum(155.14))
                .linje(fraLierEverk().medSum(99.79 / 2))
                .linje(fraEB().medSum(1193.33 / 2))
                .medAvlesninger(maaleavlesninger);

        assertEquals(349.50d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 349.50, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningJuni2015() throws Exception {
        Avregning avregning = Regning
                .fra("01.06.2015").til("01.07.2015")
                .linje(fraLierEverk().medSum(264.19))
                .linje(fraLierEverk().medSum(98.18 / 2))
                .linje(fraEB().medSum(1748.13 / 2))
                .medAvlesninger(maaleavlesninger);

        assertEquals(395.77d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 395.77, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningMai2015() throws Exception {
        Avregning avregning = Regning
                .fra("01.05.2015").til("01.06.2015")
                .linje(fraLierEverk().medSum(610.44))
                .linje(fraLierEverk().medSum(98.18 / 2))
                .linje(fraEB().medSum(1748.13 / 2))
                .medAvlesninger(maaleavlesninger);

        assertEquals(285.42d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 285.42, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningApril2015() throws Exception {
        Avregning avregning = Regning
                .fra("01.04.2015").til("01.05.2015")
                .linje(fraLierEverk().medSum(783.18))
                .linje(fraLierEverk().medSum(98.18 / 2))
                .linje(fraEB().medSum(2756.84 / 2))
                .medAvlesninger(maaleavlesninger);

        assertEquals(351.46d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 351.46, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningMars2015() throws Exception {
        Avregning avregning = Regning
                .fra("01.03.2015").til("01.04.2015")
                .linje(fraLierEverk().medSum(998.49))
                .linje(fraLierEverk().medSum(98.18 / 2))
                .linje(fraEB().medSum(2756.84 / 2))
                .medAvlesninger(maaleavlesninger);

        assertEquals(435.25d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 435.25, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningFebruar2015() throws Exception {
        Avregning avregning = Regning
                .fra("01.02.2015").til("01.03.2015")
                .linje(fraLierEverk().medSum(1324.58))
                .linje(fraLierEverk().medSum(94.97 / 2))
                .linje(fraEB().medSum(3776.32 / 2))
                .medAvlesninger(maaleavlesninger);

        assertEquals(488.97d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 488.97, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningJanuar2015() throws Exception {
        Avregning avregning = Regning
                .fra("01.01.2015").til("01.02.2015")
                .linje(fraLierEverk().medSum(1592.41))
                .linje(fraLierEverk().medSum(94.97 / 2))
                .linje(fraEB().medSum(3776.32 / 2))
                .medAvlesninger(maaleavlesninger);

        assertEquals(492.29d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 492.29, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningDesember2014() throws Exception {
        Avregning avregning = Regning
                .fra("01.12.2014").til("01.01.2015")
                .linje(fraLierEverk().medSum(1622.64))
                .linje(fraLierEverk().medSum(98.18 / 2))
                .linje(fraEB().medSum(3035.16 / 2))
                .medAvlesninger(maaleavlesninger);

        assertEquals(489.05d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 489.05, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningNovember2014() throws Exception {
        Avregning avregning = Regning
                .fra("01.11.2014").til("01.12.2014")
                .linje(fraLierEverk().medSum(1000.42))
                .linje(fraLierEverk().medSum(98.18 / 2))
                .linje(fraEB().medSum(3035.16 / 2))
                .medAvlesninger(maaleavlesninger);

        assertEquals(497.70d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 497.70, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningOktober2014() throws Exception {
        Avregning avregning = Regning
                .fra("01.10.2014").til("01.11.2014")
                .linje(fraLierEverk().medSum(818.90))
                .linje(fraLierEverk().medSum(98.18 / 2))
                .linje(fraEB().medSum(1670.65 / 2))
                .medAvlesninger(maaleavlesninger);

        assertEquals(411.53d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 411.53, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningSeptember2014() throws Exception {
        Avregning avregning = Regning
                .fra("01.09.2014").til("01.10.2014")
                .linje(fraLierEverk().medSum(525.95))
                .linje(fraLierEverk().medSum(98.18 / 2))
                .linje(fraEB().medSum(1670.65 / 2))
                .medAvlesninger(maaleavlesninger);

        assertEquals(603.88d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 603.88, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningAugust2014() throws Exception {
        Avregning avregning = Regning
                .fra("01.08.2014").til("01.09.2014")
                .linje(fraLierEverk().medSum(468.61))
                .linje(fraLierEverk().medSum(99.79 / 2))
                .linje(fraEB().medSum(771.90))
                .medAvlesninger(maaleavlesninger);

        assertEquals(103.71d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 103.71, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningJuli2014() throws Exception {
        Avregning avregning = Regning
                .fra("01.07.2014").til("01.08.2014")
                .linje(fraLierEverk().medSum(274.28))
                .linje(fraLierEverk().medSum(99.79 / 2))
                .linje(fraEB().medSum(417.64))
                .medAvlesninger(maaleavlesninger);

        assertEquals(93.15d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 93.15, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningJuni2014() throws Exception {
        Avregning avregning = Regning
                .fra("01.06.2014").til("01.07.2014")
                .linje(fraLierEverk().medSum(278.39))
                .linje(fraLierEverk().medSum(98.18 / 2))
                .linje(fraEB().medSum(546.04))
                .medAvlesninger(maaleavlesninger);

        assertEquals(161.96d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 161.96, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningMai2014() throws Exception {
        Avregning avregning = Regning
                .fra("01.05.2014").til("01.06.2014")
                .linje(fraLierEverk().medSum(501.61))
                .linje(fraLierEverk().medSum(98.18 / 2))
                .linje(fraEB().medSum(901.71))
                .medAvlesninger(maaleavlesninger);

        assertEquals(253.72d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 253.72, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningApril2014() throws Exception {
        Avregning avregning = Regning
                .fra("01.04.2014").til("01.05.2014")
                .linje(fraLierEverk().medSum(618.46))
                .linje(fraLierEverk().medSum(98.18 / 2))
                .linje(fraEB().medSum(980.94))
                .medAvlesninger(maaleavlesninger);

        assertEquals(269.05d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 269.05, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningMars2014() throws Exception {
        Avregning avregning = Regning
                .fra("01.03.2014").til("01.04.2014")
                .linje(fraLierEverk().medSum(856.81))
                .linje(fraLierEverk().medSum(98.18 / 2))
                .linje(fraEB().medSum(1208.17))
                .medAvlesninger(maaleavlesninger);

        assertEquals(285.28d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 285.28, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningFebruar2014() throws Exception {
        Avregning avregning = Regning
                .fra("01.02.2014").til("01.03.2014")
                .linje(fraLierEverk().medSum(1465.76))
                .linje(fraLierEverk().medSum(94.97 / 2))
                .linje(fraEB().medSum(1754.46))
                .medAvlesninger(maaleavlesninger);

        assertEquals(543.50d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 543.50, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningJanuar2014() throws Exception {
        Avregning avregning = Regning
                .fra("01.01.2014").til("01.02.2014")
                .linje(fraLierEverk().medSum(1488.85))
                .linje(fraLierEverk().medSum(94.97 / 2))
                .linje(fraEB().medSum(1607.65))
                .medAvlesninger(maaleavlesninger);

        //TODO: DENNE ER FØRSTE!!!
        assertEquals(726.51d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 726.51, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningDesember2013() throws Exception {
        Avregning avregning = Regning
                .fra("01.12.2013").til("01.01.2014")
                .linje(fraLierEverk().medSum(1312.58))
                .linje(fraLierEverk().medSum(98.18 / 2))
                .linje(fraEB().medSum(1374.94))
                .medAvlesninger(maaleavlesninger);

        assertEquals(676.62d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 676.62, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningNovember2013() throws Exception {
        Avregning avregning = Regning
                .fra("01.11.2013").til("01.12.2013")
                .linje(fraLierEverk().medSum(1441.31))
                .linje(fraLierEverk().medSum(98.18 / 2))
                .linje(fraEB().medSum(1395.74))
                .medAvlesninger(maaleavlesninger);

        assertEquals(464.51d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 464.51, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);
    }

    @Test
    public void testAvregningOktober2013() throws Exception {
        Avregning avregning = Regning
                .fra("01.10.2013").til("01.11.2013")
                .linje(fraLierEverk().medSum(954.94))
                .linje(fraLierEverk().medSum(98.18 / 2))
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
                .linje(fraLierEverk().medSum(98.18 / 2))
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
                .linje(fraLierEverk().medSum(99.79 / 2))
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
                .linje(fraLierEverk().medSum(99.79 / 2))
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
                .linje(fraLierEverk().medSum(98.18 / 2))
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
                .linje(fraLierEverk().medSum(98.18 / 2))
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
                .linje(fraLierEverk().medSum(98.18 / 2))
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
                .linje(fraLierEverk().medSum(98.18 / 2))
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
                .linje(fraLierEverk().medSum(94.97 / 2))
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
                .linje(fraLierEverk().medSum(94.97 / 2))
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
                .linje(fraLierEverk().medSum(97.92 / 2))
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
                .linje(fraLierEverk().medSum(97.92 / 2))
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
                .linje(fraLierEverk().medSum(99.52 / 2))
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
                .linje(fraLierEverk().medSum(99.52 / 2))
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
                .linje(fraLierEverk().medSum(97.92 / 2))
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
                .linje(fraLierEverk().medSum(97.92 / 2))
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
                .linje(fraLierEverk().medSum(97.92 / 2))
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
                .linje(fraLierEverk().medSum(97.92 / 2))
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
                .linje(fraLierEverk().medSum(96.31 / 2))
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
                .linje(fraLierEverk().medSum(96.31 / 2))
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
                .linje(fraLierEverk().medSum(98.18 / 2))
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
                .linje(fraLierEverk().medSum(98.18 / 2))
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
                .linje(fraLierEverk().medSum(98.18 / 2))
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
                .linje(fraLierEverk().medSum(98.18 / 2))
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
                .linje(fraLierEverk().medSum(98.18 / 2))
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
                .linje(fraLierEverk().medSum(98.18 / 2))
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
                .linje(fraLierEverk().medSum(98.18 / 2))
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
                .linje(fraLierEverk().medSum(98.18 / 2))
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
                .linje(fraLierEverk().medSum(98.18 / 2))
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

    @Test
    @Ignore
    public void testAvregningHittil2016() throws Exception {
        //TODO lage et Regninger class som man kan registerere regning på
        //kjøre avregning på regningER (ikke regning)

        Avregning avregning = Regning
                .fra("01.01.2016").til("01.09.2016")
                //jan
                .linje(fraLierEverk().medSum(2003.50))
                .linje(fraLierEverk().medSum(96.31 / 2))
                .linje(fraEB().medSum(4362.16 / 2))
                //feb
                .linje(fraLierEverk().medSum(1025.73))
                .linje(fraLierEverk().medSum(96.31 / 2))
                .linje(fraEB().medSum(4362.16 / 2))
                //mars
                .linje(fraLierEverk().medSum(1467.87))
                .linje(fraLierEverk().medSum(97.92 / 2))
                .linje(fraEB().medSum(3954.76 / 2))
                //april
                .linje(fraLierEverk().medSum(794.68))
                .linje(fraLierEverk().medSum(97.92 / 2))
                .linje(fraEB().medSum(3954.76 / 2))
                //mai
                .linje(fraLierEverk().medSum(521.99))
                .linje(fraLierEverk().medSum(97.92 / 2))
                .linje(fraEB().medSum(1624.20 / 2))
                //juni
                .linje(fraLierEverk().medSum(453.82))
                .linje(fraLierEverk().medSum(97.92 / 2))
                .linje(fraEB().medSum(1624.20 / 2))
                //juli
                .linje(fraGlitreStrøm().medSum(345.97))
                .linje(fraGlitreStrøm().medSum(99.52 / 2))
                .linje(fraGlitreNett().medSum(1281.27 / 2))
                //august
                .linje(fraGlitreStrøm().medSum(401.85))
                .linje(fraGlitreStrøm().medSum(99.52 / 2))
                .linje(fraGlitreNett().medSum(1281.27 / 2))
                .medAvlesninger(maaleavlesninger);

        //dette er "riktig" i forhold til mnd for mnd
//        assertEquals(2246.07d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
//        assertEquals(avregning.getRegning().getSum() - 2246.07d, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);

        //dette er det jeg har nå (fordi mnd ikke er tatt med på regningene nå (alle teller like mye)
        assertEquals(2243.80d, avregning.beregnSum(Maalepunkt.HYBELMAALER), .01);
        assertEquals(avregning.getRegning().getSum() - 2243.80, avregning.beregnSum(Maalepunkt.HOVEDETASJE), .01);

    }

}
