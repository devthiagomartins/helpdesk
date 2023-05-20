package com.thiago.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiago.helpdesk.domain.Tecnico;
import com.thiago.helpdesk.repositories.TecnicoRepository;
import com.thiago.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = tecnicoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Não foi possível localizar o técnico. Id: "+ id));
	}

	public List<Tecnico> findAll() {
		return tecnicoRepository.findAll();
	}
}
