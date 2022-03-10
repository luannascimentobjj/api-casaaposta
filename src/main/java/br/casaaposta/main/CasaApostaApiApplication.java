package br.casaaposta.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class CasaApostaApiApplication {

	public static void main(String[] args) {
		SpringApplication springApp = new SpringApplication(CasaApostaApiApplication.class);
		springApp.setAdditionalProfiles("dev", "prod");
		springApp.run(args);
		
	}

}
