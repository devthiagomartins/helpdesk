package br.com.thiago.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thiago.helpdesk.domain.Chamado;
import br.com.thiago.helpdesk.domain.Cliente;
import br.com.thiago.helpdesk.domain.Tecnico;
import br.com.thiago.helpdesk.domain.enums.Perfil;
import br.com.thiago.helpdesk.domain.enums.Prioridade;
import br.com.thiago.helpdesk.domain.enums.Status;
import br.com.thiago.helpdesk.repositories.ChamadoRepository;
import br.com.thiago.helpdesk.repositories.ClienteRepository;
import br.com.thiago.helpdesk.repositories.TecnicoRepository;

@Service
public class DbService {

	@Autowired
	private ChamadoRepository chamadoRepository;
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	
	
	public void instanciaDB() {
		
		

		Tecnico tec1 = new Tecnico(null,"Valdir Cezar","75719126104", "valdir@mail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null,"Linus Torvalds","80527954780", "torvalds@mail.com", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA,Status.ANDAMENTO,"Chamado 01", "Primeiro chamado", cli1, tec1);
		
		

		Tecnico tec2 = new Tecnico(null,"Thiago Martins","35570861168", "thiago@mail.com", "123");
		tec1.addPerfil(Perfil.TECNICO);
		
		Cliente cli2 = new Cliente(null,"Mario Grigorio","44037326104", "grigorio@mail.com", "123");
		
		Chamado c2 = new Chamado(null, Prioridade.ALTA,Status.ANDAMENTO,"Chamado 02", "Segundo chamado", cli2, tec2);
		
		
		tecnicoRepository.saveAll(Arrays.asList(tec1,tec2));
		clienteRepository.saveAll(Arrays.asList(cli1,cli2));
		chamadoRepository.saveAll(Arrays.asList(c1,c2));
		
		
	}
	
}
