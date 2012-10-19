package no.jascorp.powercalc.repository.common;

import no.jascorp.powercalc.springconfig.PersistenceConfig;
import no.jascorp.powercalc.springconfig.PropertyConfigTest;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class, PropertyConfigTest.class })
public abstract class RepositoryTestContext {

}
