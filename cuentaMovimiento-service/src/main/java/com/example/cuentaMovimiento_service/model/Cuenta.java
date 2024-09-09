package com.example.cuentaMovimiento_service.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Cuenta {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(unique = true)
	    private String numeroCuenta;

	    private String tipoCuenta;
	    private double saldoInicial;
	    private boolean estado;

	    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL, orphanRemoval = true)
	    @JsonManagedReference // Esta anotación permite que Jackson maneje la serialización de esta relación
	    private List<Movimiento> movimientos = new ArrayList<>();

	    // referencia al cliente
	    private String clienteId;
	    private String nombreCliente; 
}
