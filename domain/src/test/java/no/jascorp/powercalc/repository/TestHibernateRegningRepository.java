package no.jascorp.powercalc.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import no.jascorp.powercalc.domain.regning.Avsender;
import no.jascorp.powercalc.domain.regning.Regning;
import no.jascorp.powercalc.domain.regning.RegningLinje;
import no.jascorp.powercalc.repository.common.AbstractDatabaseTest;

import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

public class TestHibernateRegningRepository extends AbstractDatabaseTest {

	protected RegningRepository repository;

	@Required
	@Autowired
	public void setRepository(RegningRepository repository) {
		this.repository = repository;
	}

	@Test
	@Transactional
	public void testSaveRegning() {
		Regning regning = new Regning("01.09.2011", "30.09.2011");
		regning.addRegningLinje(new RegningLinje(Avsender.EB, 223.34));
		regning.addRegningLinje(new RegningLinje(Avsender.EB, 100.00));
		regning.addRegningLinje(new RegningLinje(Avsender.LIER_EVERK, 100.00));
		regning = repository.save(regning);
		assertTrue(regning.getRegningId() > 0);
		
		Regning regningGet = repository.findOne(regning.getRegningId());
		assertEquals(423.34, regningGet.getSum(), 0.000000001);
	}

	@Test
	@Transactional
	public void testGetRegning() {
		Regning regning = repository.findOne(103);
		assertTrue(regning.getRegningId() > 0);
		assertEquals(623.34, regning.getSum(), 0);
		LoggerFactory.getLogger(getClass()).debug(regning.toString());
	}
	
	@Override
	protected String getDataSetFileName() {
		return "dbunit/regning_create";
	}
}
