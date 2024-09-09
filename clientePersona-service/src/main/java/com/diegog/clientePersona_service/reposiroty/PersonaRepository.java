package com.diegog.clientePersona_service.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegog.clientePersona_service.model.Persona;

public interface PersonaRepository  extends JpaRepository<Persona, Long> {

}
