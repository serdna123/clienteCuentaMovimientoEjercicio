package com.example.cuentaMovimiento_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cuentaMovimiento_service.model.Cuenta;
import com.example.cuentaMovimiento_service.repository.CuentaRepository;

@Service
public class CuentaService {

	@Autowired
	private CuentaRepository cuentaRepository;

	// Crear una cuenta
	public Cuenta createCuenta(Cuenta cuenta) {
		return cuentaRepository.save(cuenta);
	}

	// Obtener todas las cuentas
	public List<Cuenta> getAllCuentas() {
		return cuentaRepository.findAll();
	}

	// Obtener una cuenta por ID
	public Cuenta getCuentaById(Long id) {
		return cuentaRepository.findById(id).orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
	}

	// Actualizar una cuenta
	public Cuenta updateCuenta(Long id, Cuenta cuenta) {
		Cuenta cuentaExistente = getCuentaById(id);
		cuentaExistente.setSaldoInicial(cuenta.getSaldoInicial());
		cuentaExistente.setTipoCuenta(cuenta.getTipoCuenta());
		return cuentaRepository.save(cuentaExistente);
	}

	// Eliminar una cuenta
	public void deleteCuenta(Long id) {
		cuentaRepository.deleteById(id);
	}
}
