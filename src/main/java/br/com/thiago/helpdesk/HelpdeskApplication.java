package br.com.thiago.helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.thiago.helpdesk.domain.Chamado;
import br.com.thiago.helpdesk.domain.Cliente;
import br.com.thiago.helpdesk.domain.Tecnico;
import br.com.thiago.helpdesk.domain.enums.Perfil;
import br.com.thiago.helpdesk.domain.enums.Prioridade;
import br.com.thiago.helpdesk.domain.enums.Status;
import br.com.thiago.helpdesk.repositories.ChamadoRepository;
import br.com.thiago.helpdesk.repositories.ClienteRepository;
import br.com.thiago.helpdesk.repositories.TecnicoRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner{

	@Autowired
	private ChamadoRepository chamadoRepository;
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Tecnico tec1 = new Tecnico(null,"Valdir Cezar","75719126104", "valdir@mail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null,"Linus Torvalds","80527954780", "torvalds@mail.com", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA,Status.ANDAMENTO,"Chamado 01", "Primeiro chamado", cli1, tec1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
		
	}

	
	
}
