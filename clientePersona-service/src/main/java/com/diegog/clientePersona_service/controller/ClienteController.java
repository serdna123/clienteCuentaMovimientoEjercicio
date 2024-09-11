package com.diegog.clientePersona_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.diegog.clientePersona_service.dto.ClienteDTO;
import com.diegog.clientePersona_service.model.Cliente;
import com.diegog.clientePersona_service.service.ClienteService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	// Crear un nuevo cliente
	@PostMapping
	public Cliente createCliente(@RequestBody Cliente cliente) {
		Cliente nuevoCliente = clienteService.createCliente(cliente);

		System.out.println(nuevoCliente.getClienteId() + "//" + nuevoCliente.getNombre());
		// Convertir Cliente a ClienteDTO
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setClienteId(nuevoCliente.getClienteId());
		clienteDTO.setNombre(nuevoCliente.getNombre());
		System.out.println(clienteDTO.toString());
		System.out.println(clienteDTO);
		log.info("mensaje enviado con ' '", clienteDTO);
		// Enviar a RabbitMQ
		clienteService.postQueue(clienteDTO);
		return nuevoCliente;
	}

	// Obtener todos los clientes
	@GetMapping
	public List<Cliente> getAllClientes() {
		return clienteService.getAllClientes();
	}

	// Obtener un cliente por ID
	@GetMapping("/{id}")
	public Cliente getClienteById(@PathVariable Long id) {
		return clienteService.getClienteById(id);
	}

	// Actualizar un cliente por ID
	@PutMapping("/{id}")
	public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
		return clienteService.updateCliente(id, cliente);
	}

	// Eliminar un cliente por ID
	@DeleteMapping("/{id}")
	public void deleteCliente(@PathVariable Long id) {
		clienteService.deleteCliente(id);
	}
}
