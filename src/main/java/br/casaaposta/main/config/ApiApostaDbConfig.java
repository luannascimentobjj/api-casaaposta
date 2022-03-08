package br.casaaposta.main.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import br.casaaposta.main.repository.api.MetodoRespository;

@Configuration
@EnableJpaRepositories(basePackageClasses = MetodoRespository.class, entityManagerFactoryRef = "apiEntityManager")
public class ApiApostaDbConfig {

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "api.datasource")
	DataSource apiApostaDataSource() {

		return DataSourceBuilder.create().build();

	}

	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean apiEntityManager(EntityManagerFactoryBuilder builder,
			@Qualifier("apiApostaDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("br.casaaposta.main.entity.api").build();

	}

}