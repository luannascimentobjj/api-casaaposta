package br.casaaposta.main.config;

import java.util.HashMap;
import java.util.Map;

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
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.ddl-auto", "update");
		properties.put("show-sql", "true");
		properties.put("show-sql", "true");
		properties.put("driverClassName", "com.mysql.jdbc.Driver");
		properties.put("database-platform", "org.hibernate.dialect.MySQL8Dialect");
		
		
		return builder.dataSource(dataSource)
				.packages("br.casaaposta.main.entity.api").properties(properties).build();

	}

}