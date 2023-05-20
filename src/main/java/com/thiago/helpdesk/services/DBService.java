package com.thiago.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiago.helpdesk.domain.Chamado;
import com.thiago.helpdesk.domain.Cliente;
import com.thiago.helpdesk.domain.Tecnico;
import com.thiago.helpdesk.domain.enums.Perfil;
import com.thiago.helpdesk.domain.enums.Prioridade;
import com.thiago.helpdesk.domain.enums.Status;
import com.thiago.helpdesk.repositories.ChamadoRepository;
import com.thiago.helpdesk.repositories.ClienteRepository;
import com.thiago.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	public void criarCargaInicialBaseDados() {
		Tecnico tecnico1 = new Tecnico(null, "Thiago Martins", "85649382000", "thiago@mail.com", "123");
		tecnico1.adicionarPerfil(Perfil.ADMIN);
		
		Cliente cliente1 = new Cliente(null, "Linus Torvalds", "79952977000", "torvalds@mail.com", "123");
		
		Chamado chamado1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tecnico1, cliente1);
		
		
		//Dados para avaliador TCC
		Tecnico tecnicoAvaliador = new Tecnico(null, "Técnico", "69197729060", "tecnico@mail.com", "123");
		Tecnico tecnicoAvaliadorAdmin = new Tecnico(null, "Técnico Admin", "04318303047", "tecnicoadmin@mail.com", "123");
		tecnicoAvaliadorAdmin.adicionarPerfil(Perfil.ADMIN);
		
		Cliente clienteAvaliador = new Cliente(null, "Cliente", "69109003088", "cliente@mail.com", "123");
		Cliente clienteAvaliadorAdmin = new Cliente(null, "Cliente Admin", "12054556041", "clienteadmin@mail.com", "123");
		clienteAvaliadorAdmin.adicionarPerfil(Perfil.ADMIN);
		
		Chamado chamadoTecnicoAvaliador = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado Tecnico Avaliador", "Primeiro chamado", tecnicoAvaliador, clienteAvaliador);
		Chamado chamadoTecnicoAvaliadorAdmin = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado Tecnico Avaliador Admin", "Primeiro chamado", tecnicoAvaliadorAdmin, clienteAvaliadorAdmin);
		
		tecnicoRepository.saveAll(Arrays.asList(tecnico1,tecnicoAvaliador,tecnicoAvaliadorAdmin));
		clienteRepository.saveAll(Arrays.asList(cliente1,clienteAvaliador,clienteAvaliadorAdmin));
		chamadoRepository.saveAll(Arrays.asList(chamado1,chamadoTecnicoAvaliador,chamadoTecnicoAvaliadorAdmin));
	}
}
