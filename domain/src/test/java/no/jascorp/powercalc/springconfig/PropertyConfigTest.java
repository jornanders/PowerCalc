package no.jascorp.powercalc.springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * Dette er en egen PropertyPlaceholderConfig som skal brukes i integrasjonstester. 
 */
@Configuration
public class PropertyConfigTest {
	
		
	/*
	 * Fra Spring doc: "Special consideration must be taken for @Bean methods that return Spring
	 * BeanFactoryPostProcessor (BFPP) types. Because BFPP objects must be instantiated very early in the container
	 * lifecycle, they can interfere with processing of annotations such as @Autowired, @Value, and @PostConstruct
	 * within @Configuration classes. To avoid these lifecycle issues, mark BFPP-returning @Bean methods as static"
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceholder() {
		PropertySourcesPlaceholderConfigurer propertPaceholder = new PropertySourcesPlaceholderConfigurer();
		propertPaceholder.setFileEncoding("UTF-8");
		propertPaceholder.setLocation(new ClassPathResource("application-test.properties"));
		return propertPaceholder;
	}

}
