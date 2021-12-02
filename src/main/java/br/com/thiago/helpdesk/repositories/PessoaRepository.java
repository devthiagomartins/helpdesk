package br.com.thiago.helpdesk.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.thiago.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

	Optional<Pessoa> findByCpf(String cpf);
	Optional<Pessoa> findByEmail(String email);

}
