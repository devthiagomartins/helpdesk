package br.com.thiago.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thiago.helpdesk.domain.Tecnico;
import br.com.thiago.helpdesk.repositories.TecnicoRepository;
import br.com.thiago.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {

	@Autowired 
	private TecnicoRepository repository;
	
	public Tecnico findById(Integer id) {
		
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}
	
}
