package com.thiago.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiago.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
