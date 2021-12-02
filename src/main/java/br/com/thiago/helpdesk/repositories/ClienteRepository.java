package br.com.thiago.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.thiago.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
