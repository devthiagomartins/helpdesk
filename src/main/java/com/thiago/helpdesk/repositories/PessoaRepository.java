package com.thiago.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiago.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
