package com.example.cuentaMovimiento_service.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Movimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String tipoMovimiento;
	private double valor;
	private double saldo;

	private LocalDate fecha;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cuenta_id")
	@JsonBackReference // Esta anotación evita que Jackson entre en un bucle al serializar la relación
						// bidireccional
	private Cuenta cuenta;

	@Transient
	private String numeroCuenta;

	@PostLoad
	private void postLoad() {
		if (cuenta != null) {
			this.numeroCuenta = cuenta.getNumeroCuenta();
		}
	}
}
