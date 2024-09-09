package com.example.cuentaMovimiento_service.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cuentaMovimiento_service.model.Movimiento;


public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
	  List<Movimiento> findByCuentaIdAndFechaBetween(Long cuentaId, LocalDate fechaInicio, LocalDate fechaFin);

}
