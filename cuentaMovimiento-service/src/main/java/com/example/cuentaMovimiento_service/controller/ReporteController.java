package com.example.cuentaMovimiento_service.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.cuentaMovimiento_service.model.Cuenta;
import com.example.cuentaMovimiento_service.model.Movimiento;
import com.example.cuentaMovimiento_service.repository.CuentaRepository;
import com.example.cuentaMovimiento_service.repository.MovimientoRepository;

@RestController
@RequestMapping("/reportes")
public class ReporteController {
    @Autowired
    private CuentaRepository cuentaRepository;
    
    @Autowired
    private MovimientoRepository movimientoRepository;

    @GetMapping
    public ResponseEntity<?> generarReporte(
        @RequestParam String clienteId, 
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio, 
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {

        // Obtener cuentas del cliente
        List<Cuenta> cuentas = cuentaRepository.findByClienteId(clienteId);
        if (cuentas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("No se encontraron cuentas para el cliente con ID: " + clienteId);
        }

        // Crear un objeto para el reporte
        Map<String, Object> reporte = new HashMap<>();
        reporte.put("clienteId", clienteId);
        List<Map<String, Object>> detallesCuentas = new ArrayList<>();

        // Recorrer las cuentas y agregar sus movimientos al reporte
        for (Cuenta cuenta : cuentas) {
            Map<String, Object> cuentaDetalles = new HashMap<>();
            cuentaDetalles.put("numeroCuenta", cuenta.getNumeroCuenta());
            cuentaDetalles.put("saldoActual", cuenta.getSaldoInicial());
            cuentaDetalles.put("tipo", cuenta.getTipoCuenta());

            // Obtener los movimientos de la cuenta en el rango de fechas
            List<Movimiento> movimientos = movimientoRepository.findByCuentaIdAndFechaBetween(
                cuenta.getId(), fechaInicio, fechaFin);

            cuentaDetalles.put("movimientos", movimientos);
            detallesCuentas.add(cuentaDetalles);
        }

        reporte.put("cuentas", detallesCuentas);
        return ResponseEntity.ok(reporte);
    }
    
    @GetMapping("/reporte-cliente")
    public ResponseEntity<?> generarReporteCliente(@RequestParam String clienteId, @RequestParam LocalDate fechaInicio, @RequestParam LocalDate fechaFin) {
        // Obtener las cuentas del cliente
        List<Cuenta> cuentas = cuentaRepository.findByClienteId(clienteId);

        if (cuentas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay cuentas para el cliente con ID: " + clienteId);
        }

        // Crear el reporte basado en el clienteId, fechaInicio y fechaFin
        Map<String, Object> reporte = new HashMap<>();
        reporte.put("clienteId", clienteId);
        reporte.put("cuentas", cuentas); // Incluye todas las cuentas y movimientos asociados

        return ResponseEntity.ok(reporte);
    }
}
