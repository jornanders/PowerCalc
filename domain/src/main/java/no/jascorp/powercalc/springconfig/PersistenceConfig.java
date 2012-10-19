package no.jascorp.powercalc.springconfig;

import java.util.Properties;

import javax.sql.DataSource;

import liquibase.integration.spring.SpringLiquibase;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author Jørn Anders Svendsen
 *
 */
@Configuration
@ComponentScan(basePackages = { "no.jascorp.powercalc.repository"})
@ImportResource({ "classpath:jpaConfig.xml" })
public class PersistenceConfig {

	// DB properties
	private @Value("${db.driver}") String PROPERTY_DATABASE_DRIVER;
	private @Value("${db.url}")	String PROPERTY_DATABASE_URL;
	private @Value("${db.username}") String PROPERTY_DATABASE_USERNAME;
	private @Value("${db.password}") String PROPERTY_DATABASE_PASSWORD;

	// Hibernate properties
	private @Value("${hibernate.database}")	String PROPERTY_HIBERNATE_DATABASE;
	private @Value("${hibernate.dialect}") String PROPERTY_HIBERNATE_DIALECT;
	private @Value("${hibernate.format_sql}") String PROPERTY_HIBERNATE_FORMAT_SQL;
	private @Value("${hibernate.show_sql}")	String PROPERTY_HIBERNATE_SHOW_SQL;
	private @Value("${hibernate.autodetection}") String PROPERTY_HIBERNATE_AUTODETECTION;
	private @Value("${hibernate.id.new_generator_mappings}") String PROPERTY_HIBERNATE_ID_MAPPING;
	private @Value("${hibernate.use_sql_comments}") String PROPERTY_HIBERNATE_USE_SQL_COMMENTS;

	private @Value("${liquibase.drop_table}") boolean PROPERTY_LIQUIBASE_DROP_TABLE;
	
	private static final String DOMAIN_LOCATION = "no.jascorp.powercalc.domain";
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan(new String[] { DOMAIN_LOCATION });
		factoryBean.setPersistenceProviderClass(HibernatePersistence.class);

		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.format_sql", PROPERTY_HIBERNATE_FORMAT_SQL);
		jpaProperties.put("hibernate.show_sql", PROPERTY_HIBERNATE_SHOW_SQL);
		// Auto detect annotated model classes
		jpaProperties.put("hibernate.archive.autodetection", PROPERTY_HIBERNATE_AUTODETECTION);
		jpaProperties.put("hibernate.id.new_generator_mappings", PROPERTY_HIBERNATE_ID_MAPPING);
		jpaProperties.put("hibernate.use_sql_comments", PROPERTY_HIBERNATE_USE_SQL_COMMENTS);
		factoryBean.setJpaProperties(jpaProperties);

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter() {
			{
				setDatabase(Database.valueOf(PROPERTY_HIBERNATE_DATABASE));
				setDatabasePlatform(PROPERTY_HIBERNATE_DIALECT);
			}
		};
		factoryBean.setJpaVendorAdapter(vendorAdapter);

		return factoryBean;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(PROPERTY_DATABASE_DRIVER);
		dataSource.setUrl(PROPERTY_DATABASE_URL);
		dataSource.setUsername(PROPERTY_DATABASE_USERNAME);
		dataSource.setPassword(PROPERTY_DATABASE_PASSWORD);
		return dataSource;
	}
	
	@Bean
	public SpringLiquibase liquibaseMigration() {
		SpringLiquibase migration = new SpringLiquibase();
		migration.setDataSource(dataSource());
		migration.setChangeLog("classpath:db-changelog/db-changelog.xml");
		migration.setDropFirst(PROPERTY_LIQUIBASE_DROP_TABLE);
		return migration;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactoryBean().getObject());
	}
}
