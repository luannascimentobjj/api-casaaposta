package br.casaaposta.main.config;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import br.casaaposta.main.repository.api.MetodoRespository;
import br.casaaposta.main.util.BDPropertiesUtil;

@Configuration
@Profile("dev")
@EnableJpaRepositories(basePackageClasses = MetodoRespository.class, entityManagerFactoryRef = "apiApostaEntityManager")
public class ApiApostaDbConfig {

	
	@Bean
	@Primary
	DataSource apiApostaDataSource() {

				return DataSourceBuilder
				.create()
				.username(BDPropertiesUtil.PROD_USERNAME_API_APOSTA)
				.password(BDPropertiesUtil.PROD_PASSWORD_API_APOSTA)
				.url(BDPropertiesUtil.PROD_URL_API_APOSTA)
				.driverClassName(BDPropertiesUtil.DRIVERCLASSNAME_MYSQL)
				.build();
				

	}


		@Bean
		@Primary
        public LocalContainerEntityManagerFactoryBean apiApostaEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(apiApostaDataSource());
        em.setPackagesToScan("br.casaaposta.main.entity.api");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        Properties properties = new Properties();
        properties.setProperty(BDPropertiesUtil.ADITIONAL_PROPERTIES_DIALECT, BDPropertiesUtil.ADITIONAL_PROPERTIES_DIALECT_VALUE);
		properties.setProperty(BDPropertiesUtil.ADITIONAL_PROPERTIES_SHOWSQL, BDPropertiesUtil.ADITIONAL_PROPERTIES_SHOWSQL_VALUE);
		properties.setProperty(BDPropertiesUtil.ADITIONAL_PROPERTIES_HBM2DDL_AUTO, BDPropertiesUtil.ADITIONAL_PROPERTIES_HBM2DDL_AUTO_VALUE);
        em.setJpaProperties(properties);
        
        return em;
    }
	


	@Primary
    @Bean
    public PlatformTransactionManager apiTransactionManager() {
 
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(apiApostaEntityManager().getObject());
        return transactionManager;
    }
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf){
		return new JpaTransactionManager(emf);
		
	}
}

