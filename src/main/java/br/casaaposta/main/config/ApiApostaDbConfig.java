package br.casaaposta.main.config;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import br.casaaposta.main.repository.api.MetodoRespository;

@Configuration
@EnableJpaRepositories(basePackageClasses = MetodoRespository.class, entityManagerFactoryRef = "apiApostaEntityManager")
public class ApiApostaDbConfig {

	@Autowired
	private Environment env;
	
	@Primary
	@Profile("dev")
	@Bean
	DataSource apiApostaDataSource() {

				return DataSourceBuilder
				.create()
				.username("root")
				.password("1234")
				.url("jdbc:mysql://localhost:3306/api_aposta")
				.driverClassName("com.mysql.jdbc.Driver")
				.build();
				

	}


		@Bean
		@Primary
        public LocalContainerEntityManagerFactoryBean apiApostaEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(apiApostaDataSource());
        em.setPackagesToScan(new String[] { "br.casaaposta.main.entity.api" });

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        Properties properties = new Properties();
        properties.setProperty("hibernate.ddl-auto", "update");
        properties.setProperty("jpa.defer-datasource-initialization", "true");
        properties.setProperty("jpa.show-sql", "true");
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
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

