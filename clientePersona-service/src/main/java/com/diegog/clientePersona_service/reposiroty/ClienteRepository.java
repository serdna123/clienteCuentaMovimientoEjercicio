	package com.diegog.clientePersona_service.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegog.clientePersona_service.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	
}
