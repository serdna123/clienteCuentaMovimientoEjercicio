package com.example.cuentaMovimiento_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.cuentaMovimiento_service.model.Cuenta;
import com.example.cuentaMovimiento_service.model.Movimiento;
import com.example.cuentaMovimiento_service.repository.CuentaRepository;
import com.example.cuentaMovimiento_service.service.MovimientoService;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

	@Autowired
	private MovimientoService movimientoService;
	@Autowired
	private CuentaRepository cuentaRepository;

	@PostMapping
	public Movimiento createMovimiento(@RequestBody Movimiento movimiento) {
		// Obtener la cuenta usando el numeroCuenta recibido en el JSON
		Cuenta cuenta = cuentaRepository.findByNumeroCuenta(movimiento.getNumeroCuenta()).orElseThrow(
				() -> new RuntimeException("Cuenta no encontrada con numero: " + movimiento.getNumeroCuenta()));

		// Calcular el saldo restante basado en el tipo de movimiento
		if (movimiento.getTipoMovimiento().equals("RETIRO")) {
			if (cuenta.getSaldoInicial() >= movimiento.getValor()) {
				cuenta.setSaldoInicial(cuenta.getSaldoInicial() - movimiento.getValor());
			} else {
				throw new RuntimeException("Saldo insuficiente para realizar el retiro");
			}
		} else if (movimiento.getTipoMovimiento().equals("DEPOSITO")) {
			cuenta.setSaldoInicial(cuenta.getSaldoInicial() + movimiento.getValor());
		}

		// Asignar el saldo restante al movimiento
		movimiento.setSaldo(cuenta.getSaldoInicial());

		// Asignar la cuenta al movimiento
		movimiento.setCuenta(cuenta);

		// Guardar el movimiento y devolverlo
		Movimiento savedMovimiento = movimientoService.createMovimiento(movimiento);

		// Actualizar la cuenta con el nuevo saldo
		cuentaRepository.save(cuenta);

		return savedMovimiento;
	}

	@GetMapping
	public List<Movimiento> getAllMovimientos() {
		return movimientoService.getAllMovimientos();
	}

	@GetMapping("/{id}")
	public Movimiento getMovimientoById(@PathVariable Long id) {
		return movimientoService.getMovimientoById(id);
	}

	@PutMapping("/{id}")
	public Movimiento updateMovimiento(@PathVariable Long id, @RequestBody Movimiento movimiento) {
		return movimientoService.updateMovimiento(id, movimiento);
	}

	@DeleteMapping("/{id}")
	public void deleteMovimiento(@PathVariable Long id) {
		movimientoService.deleteMovimiento(id);
	}

}
