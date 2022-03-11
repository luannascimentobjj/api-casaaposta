package br.casaaposta.main.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import br.casaaposta.main.repository.consumer.LigaRepository;
import br.casaaposta.main.util.BDPropertiesUtil;

@Configuration
@EnableJpaRepositories(basePackageClasses = LigaRepository.class, entityManagerFactoryRef = "consumerEntityManager")
public class ApostaDbConfig {

	@Bean
	@Profile("dev")
	DataSource consumerDataSource() {

		return DataSourceBuilder.create().username(BDPropertiesUtil.LOCAL_USERNAME_APOSTA)
				.password(BDPropertiesUtil.LOCAL_PASSWORD_APOSTA).url(BDPropertiesUtil.LOCAL_URL_APOSTA)
				.driverClassName(BDPropertiesUtil.LOCAL_DRIVERCLASSNAME_APOSTA).build();

	}

	@Bean
	public LocalContainerEntityManagerFactoryBean consumerEntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(consumerDataSource());
		em.setPackagesToScan("br.casaaposta.main.entity.consumer");

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		Properties properties = new Properties();
		properties.setProperty(BDPropertiesUtil.ADITIONAL_PROPERTIES_DIALECT,
				BDPropertiesUtil.ADITIONAL_PROPERTIES_DIALECT_VALUE);
		properties.setProperty(BDPropertiesUtil.ADITIONAL_PROPERTIES_SHOWSQL,
				BDPropertiesUtil.ADITIONAL_PROPERTIES_SHOWSQL_VALUE);
		properties.setProperty(BDPropertiesUtil.ADITIONAL_PROPERTIES_HBM2DDL_AUTO,
				BDPropertiesUtil.ADITIONAL_PROPERTIES_HBM2DDL_AUTO_VALUE);
		em.setJpaProperties(properties);

		return em;
	}



}
