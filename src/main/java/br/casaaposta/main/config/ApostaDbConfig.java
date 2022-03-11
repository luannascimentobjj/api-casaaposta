package br.casaaposta.main.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import br.casaaposta.main.repository.consumer.LigaRepository;

@Configuration
@PropertySource({"classpath:application.properties"})
@EnableJpaRepositories(basePackageClasses = LigaRepository.class,  entityManagerFactoryRef = "consumerEntityManager")
public class ApostaDbConfig {

	@Bean
	@ConfigurationProperties(prefix = "spring.second-datasource")
	DataSource consumerDataSource() {

		return DataSourceBuilder
				.create()
				.username("root")
				.password("1234")
				.url("jdbc:mysql://localhost:3306/aposta")
				.driverClassName("com.mysql.jdbc.Driver")
				.build();

	}

	@Bean
	public LocalContainerEntityManagerFactoryBean consumerEntityManager(EntityManagerFactoryBuilder builder,
			@Qualifier("consumerDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("br.casaaposta.main.entity.consumer").build();

	}
	
	

}
