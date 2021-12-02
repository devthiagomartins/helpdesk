package br.com.thiago.helpdesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.thiago.helpdesk.services.DbService;

@Configuration
@Profile("dev")
public class DevConfig {

	
	@Autowired
	private DbService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String value;
	
	@Bean
	public boolean instanciaDb() {
		
		if(value.equals("create")) {
			this.dbService.instanciaDB();
		}
		
		return false;
	}
}
