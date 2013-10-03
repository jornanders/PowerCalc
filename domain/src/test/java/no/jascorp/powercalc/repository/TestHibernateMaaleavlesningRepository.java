package no.jascorp.powercalc.repository;

import static no.jascorp.powercalc.util.Utils.stringToDate;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import no.jascorp.powercalc.domain.common.Datointervall;
import no.jascorp.powercalc.domain.maaleavlesning.Maaleavlesning;
import no.jascorp.powercalc.domain.maaleavlesning.Maaleavlesninger;
import no.jascorp.powercalc.domain.maaleavlesning.Maalepunkt;
import no.jascorp.powercalc.repository.common.AbstractDatabaseTest;
import no.jascorp.powercalc.util.Utils;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.transaction.annotation.Transactional;

public class TestHibernateMaaleavlesningRepository extends AbstractDatabaseTest {
	
	private MaaleavlesningRepository repository;

	@Required
	@Autowired
	public void setRepository(MaaleavlesningRepository repository) {
		this.repository = repository;
	}

	@Test
	@Transactional
	public void testSaveMaaleavlesning() {
		Maaleavlesning maaleavlesning = new Maaleavlesning(Maalepunkt.HOVEDETASJE, stringToDate("29.09.1013"), 120);
		repository.save(maaleavlesning);
		assertTrue((maaleavlesning.getAvlesningId()) > 0);
	}
	
	@Test
	@Transactional
	public void testGetMaaleavlesning() {
		Maaleavlesning maaleavlesning = repository.findOne(220);
		Logger.getLogger(getClass()).debug(maaleavlesning);
		assertThat(maaleavlesning, is(notNullValue()));
	}

	@Test
	@Transactional
	public void testGetAllMaaleavlesninger() {
		Maaleavlesninger maaleavlesninger = new Maaleavlesninger(repository.findAll());
		double beregnForbrukForIntervall = maaleavlesninger.beregnForbrukForIntervall(new Datointervall("01.01.2011", "31.12.2011"), Maalepunkt.HOVEDMAALER);
		assertEquals(18051.225806451614, beregnForbrukForIntervall, 0d);
	}
	
	@Test(expected=TransactionSystemException.class)
	public void testNotPossibleToSaveNullAvlesning() {
		repository.save(Maaleavlesning.NULL_AVLESNING);
	}
	
	@Override
	protected String getDataSetFileName() {
		return "dbunit/maaleavlesning_create";
	}
}
