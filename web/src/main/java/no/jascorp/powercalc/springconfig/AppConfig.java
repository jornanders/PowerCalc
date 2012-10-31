package no.jascorp.powercalc.springconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ PersistenceConfig.class, PropertyConfig.class})
public class AppConfig {
	
}
