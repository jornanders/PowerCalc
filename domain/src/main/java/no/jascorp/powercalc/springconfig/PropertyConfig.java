package no.jascorp.powercalc.springconfig;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@Configuration
public class PropertyConfig {

	private static final Logger logger = LoggerFactory.getLogger(PropertyConfig.class);

	// I hvilken systemvariabel applikasjonen leter etter path til property fil
	private static final String SYSTEM_VARIABLE_PROPERTIES_PATH = "powercalc.properties.path";

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
		propertPaceholder.setIgnoreResourceNotFound(false);
		propertPaceholder.setIgnoreUnresolvablePlaceholders(false);

		propertPaceholder.setLocations(getResources());
		return propertPaceholder;
	}

	private static Resource[] getResources() {
		List<Resource> locations = new ArrayList<>();
		locations.add(createPowerCalcPropertiesResource());
		Resource[] resources = locations.toArray(new Resource[] {});
		return resources;
	}

	public static Resource createPowerCalcPropertiesResource() {
		String propertiesPath = System.getProperty(SYSTEM_VARIABLE_PROPERTIES_PATH);
		Resource resource;
		if (propertiesPath != null) {
			resource = new FileSystemResource(propertiesPath);
		} else {
			resource = new ClassPathResource("application.properties");
			logger.warn("Path for property fil er ikke satt. Vennligst sett path i systemvariabelen '"
					+ SYSTEM_VARIABLE_PROPERTIES_PATH + "'. Bruker default property fil (application.properties).");
		}
		return resource;
	}

}
