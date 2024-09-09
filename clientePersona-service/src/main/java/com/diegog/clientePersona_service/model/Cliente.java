package com.diegog.clientePersona_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public  class Cliente extends Persona {
    @Column(unique = true)
    private String clienteId;

    private String contrasena;
    private boolean estado;
}
