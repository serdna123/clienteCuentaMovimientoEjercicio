package com.diegog.clientePersona_service.dto;

import java.io.Serializable;


import lombok.Data;

@Data
public class ClienteDTO  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String clienteId;
    private String nombre;

}
