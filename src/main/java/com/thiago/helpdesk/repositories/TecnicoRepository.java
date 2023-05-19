package com.thiago.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiago.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
