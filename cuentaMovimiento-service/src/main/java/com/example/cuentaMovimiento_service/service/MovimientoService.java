package com.example.cuentaMovimiento_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cuentaMovimiento_service.model.Movimiento;
import com.example.cuentaMovimiento_service.repository.MovimientoRepository;

@Service
public class MovimientoService {
	@Autowired
	private MovimientoRepository movimientoRepository;

	// Crear un movimiento
    public Movimiento createMovimiento(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

	// Obtener todos los movimientos
	public List<Movimiento> getAllMovimientos() {
		return movimientoRepository.findAll();
	}

	// Obtener un movimiento por ID
	public Movimiento getMovimientoById(Long id) {
		return movimientoRepository.findById(id).orElseThrow(() -> new RuntimeException("Movimiento no encontrado"));
	}

	// Actualizar un movimiento
	public Movimiento updateMovimiento(Long id, Movimiento movimiento) {
		Movimiento movimientoExistente = getMovimientoById(id);
		movimientoExistente.setValor(movimiento.getValor());
		movimientoExistente.setTipoMovimiento(movimiento.getTipoMovimiento());
		return movimientoRepository.save(movimientoExistente);
	}

	// Eliminar un movimiento
	public void deleteMovimiento(Long id) {
		movimientoRepository.deleteById(id);
	}

}
