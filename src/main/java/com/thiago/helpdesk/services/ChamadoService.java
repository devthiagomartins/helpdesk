package com.thiago.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiago.helpdesk.domain.Chamado;
import com.thiago.helpdesk.repositories.ChamadoRepository;
import com.thiago.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class ChamadoService {

	@Autowired
	private ChamadoRepository chamadoRepository;
	
	public Chamado findById(Integer id) {
		Optional<Chamado> obj = chamadoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Não foi possível localizar o chamado. Id: "+ id));
	}

	public List<Chamado> findAll() {
		return chamadoRepository.findAll();
	}
}
