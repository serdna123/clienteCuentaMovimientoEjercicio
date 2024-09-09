package com.diegog.clientePersona_service.producer;

import java.io.Serializable;

import lombok.Data;

@Data
public class ClienteDTO implements Serializable {
	private String clienteId;
    private String nombre;
}
