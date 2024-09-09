package com.example.cuentaMovimiento_service.consumer;


import java.io.Serializable;
import lombok.Data;

@Data
public class ClienteDTO implements Serializable {
    private String clienteId;
    private String nombre;
}