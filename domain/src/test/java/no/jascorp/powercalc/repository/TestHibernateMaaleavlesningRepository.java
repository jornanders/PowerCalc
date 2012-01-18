package no.jascorp.powercalc.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import no.jascorp.powercalc.domain.common.Datointervall;
import no.jascorp.powercalc.domain.maaleavlesning.Maaleavlesning;
import no.jascorp.powercalc.domain.maaleavlesning.Maaleavlesninger;
import no.jascorp.powercalc.domain.maaleavlesning.Maalepunkt;
import no.jascorp.powercalc.repository.common.AbstractDatabaseTest;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class TestHibernateMaaleavlesningRepository extends AbstractDatabaseTest {
	
	private MaaleavlesningRepository repository;

	@Required
	@Autowired
	public void setRepository(MaaleavlesningRepository repository) {
		this.repository = repository;
	}

	@Test
	public void testSaveMaaleavlesning() {
		Maaleavlesning maaleavlesning = new Maaleavlesning(Maalepunkt.HOVEDETASJE, new Date(), 120);
		repository.save(maaleavlesning);
		assertTrue((maaleavlesning.getAvlesningId()) > 0);
		
	}
	
	@Test
	public void testGetMaaleavlesning() {
		Maaleavlesning maaleavlesning = repository.get(220);
		Logger.getLogger(getClass()).debug(maaleavlesning);
		assertNotNull(maaleavlesning);
	}

	@Test
	public void testGetAllMaaleavlesninger() {
		Maaleavlesninger maaleavlesninger = repository.getMaaleavlesninger();
		double beregnForbrukForIntervall = maaleavlesninger.beregnForbrukForIntervall(new Datointervall("01.01.2011", "31.12.2011"), Maalepunkt.HOVEDMAALER);
		assertEquals(18051.225806451614, beregnForbrukForIntervall, 0d);
	}
	
	@Test
	public void testSetAvlesningIdNotPossible() {
		Maaleavlesning maaleavlesning = new Maaleavlesning(Maalepunkt.HYBELMAALER, "01.01.2011", 23);
		maaleavlesning.setAvlesningId(13);
		repository.save(maaleavlesning);
		assertNotNull(maaleavlesning.getAvlesningId());
		assertTrue(maaleavlesning.getAvlesningId() != 13);
		maaleavlesning = repository.get(13);
		assertNull(maaleavlesning);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNotPossibleToSaveNullAvlesning() {
		repository.save(Maaleavlesning.NULL_AVLESNING);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testStandMustBeIncreasing() {
		repository.save(new Maaleavlesning(Maalepunkt.HYBELMAALER, "23.03.2011", 50));
	}

	@Override
	protected String getDataSetFileName() {
		return "dbunit/maaleavlesning_create";
	}
}
