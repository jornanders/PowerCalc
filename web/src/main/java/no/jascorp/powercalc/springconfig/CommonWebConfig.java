package no.jascorp.powercalc.springconfig;

import javax.validation.Validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles2.TilesViewResolver;

@Configuration
@ComponentScan(basePackages = {"no.jascorp.powercalc.web.controller"})
public class CommonWebConfig extends WebMvcConfigurerAdapter {

	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		// In general, use Converters when you need implement general-purpose type conversion logic; logic that may be
		// invoked by the Spring Container, SpEL, or your own code as part of a one-way binding process. Use Formatters
		// when you're working in a UI environment such as a HTML form of a web application, and need to apply two-way
		// parsing, formatting, and localization logic to form field values.
		registry.addFormatter(getDateFormatter());
		
	}

	private DateFormatter getDateFormatter() {
		DateFormatter dateFormatter = new DateFormatter("dd.MM.yyyy");
		dateFormatter.setLenient(true);
		return dateFormatter;
	}

	@Bean
	public TilesViewResolver configureTilesViewResolver() {
		return new TilesViewResolver();
	}

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setCacheSeconds(1);
		//messageSource.setDefaultEncoding(CharEncoding.UTF_8);
//		messageSource.setBasenames(new String[] { "classpath:i18n/global_messages", "classpath:ValidationMessages",
//				"classpath:estil-version" });
		return messageSource;
	}

//	@Bean
//	public LocaleResolver localeResolver() {
//		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
//		cookieLocaleResolver.setDefaultLocale(locale());
//		return cookieLocaleResolver;
//	}

	@Bean
	public Validator validator() {
		return new LocalValidatorFactoryBean();
	}

	@Bean
	public SpringValidatorAdapter springValidatorAdapter() {
		return new SpringValidatorAdapter(validator());
	}
}
