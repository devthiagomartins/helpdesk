package br.com.thiago.helpdesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.thiago.helpdesk.services.DbService;

@Configuration
@Profile("test")
public class TestConfig {

	
	@Autowired
	private DbService dbService;
	
	@Bean
	public void instanciaDb() {
		this.dbService.instanciaDB();
	}
}
