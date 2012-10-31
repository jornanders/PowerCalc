package no.jascorp.powercalc.springconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;

@Configuration
@EnableWebMvc
@Import({ CommonWebConfig.class, PropertyConfig.class })
public class WebConfig extends WebMvcConfigurerAdapter {

	private static final String TILES = "/WEB-INF/tiles/tiles.xml";
	private static final String VIEWS = "/WEB-INF/views/**/views.xml";

	@Autowired
	private LocalContainerEntityManagerFactoryBean factory;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// OpenSessionInView pattern
		OpenEntityManagerInViewInterceptor openSessionInViewInterceptor = new OpenEntityManagerInViewInterceptor();
		openSessionInViewInterceptor.setEntityManagerFactory(factory.getObject());
		registry.addWebRequestInterceptor(openSessionInViewInterceptor);
	}

	@Bean
	public TilesConfigurer configureTilesConfigurer() {
		TilesConfigurer configurer = null;
		configurer = new TilesConfigurer();
		configurer.setDefinitions(new String[] { TILES, VIEWS });

		return configurer;
	}

}