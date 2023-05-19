package com.thiago.helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thiago.helpdesk.domain.Chamado;
import com.thiago.helpdesk.domain.Cliente;
import com.thiago.helpdesk.domain.Tecnico;
import com.thiago.helpdesk.domain.enums.Perfil;
import com.thiago.helpdesk.domain.enums.Prioridade;
import com.thiago.helpdesk.domain.enums.Status;
import com.thiago.helpdesk.repositories.ChamadoRepository;
import com.thiago.helpdesk.repositories.ClienteRepository;
import com.thiago.helpdesk.repositories.TecnicoRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tecnico tecnico1 = new Tecnico(null, "Thiago Martins", "85649382000", "thiago@mail.com", "123");
		tecnico1.adicionarPerfil(Perfil.ADMIN);
		
		Cliente cliente1 = new Cliente(null, "Linus Torvalds", "79952977000", "torvalds@mail.com", "123");
		
		Chamado chamado1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tecnico1, cliente1);
		
		tecnicoRepository.saveAll(Arrays.asList(tecnico1));
		clienteRepository.saveAll(Arrays.asList(cliente1));
		chamadoRepository.saveAll(Arrays.asList(chamado1));
	}

}
