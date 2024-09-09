package com.example.cuentaMovimiento_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cuentaMovimiento_service.model.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
	  Optional<Cuenta> findByNumeroCuenta(String numeroCuenta);
	  List<Cuenta> findByClienteId(String clienteId);
}
