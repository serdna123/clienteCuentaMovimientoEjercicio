package com.example.cuentaMovimiento_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.cuentaMovimiento_service.model.Cuenta;
import com.example.cuentaMovimiento_service.service.CuentaService;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

	@Autowired
	private CuentaService cuentaService;

	@PostMapping
	public Cuenta createCuenta(@RequestBody Cuenta cuenta) {
		return cuentaService.createCuenta(cuenta);
	}

	@GetMapping
	public List<Cuenta> getAllCuentas() {
		return cuentaService.getAllCuentas();
	}

	@GetMapping("/{id}")
	public Cuenta getCuentaById(@PathVariable Long id) {
		return cuentaService.getCuentaById(id);
	}

	@PutMapping("/{id}")
	public Cuenta updateCuenta(@PathVariable Long id, @RequestBody Cuenta cuenta) {
		return cuentaService.updateCuenta(id, cuenta);
	}

	@DeleteMapping("/{id}")
	public void deleteCuenta(@PathVariable Long id) {
		cuentaService.deleteCuenta(id);
	}

}
