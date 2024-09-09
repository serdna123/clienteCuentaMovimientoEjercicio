package com.diegog.clientePersona_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegog.clientePersona_service.model.Cliente;
import com.diegog.clientePersona_service.reposiroty.ClienteRepository;

@Service
public class ClienteService {

	 @Autowired
	    private ClienteRepository clienteRepository;

	    // Crear un cliente
	    public Cliente createCliente(Cliente cliente) {
	        return clienteRepository.save(cliente);
	    }

	    // Obtener todos los clientes
	    public List<Cliente> getAllClientes() {
	        return clienteRepository.findAll();
	    }

	    // Obtener un cliente por ID
	    public Cliente getClienteById(Long id) {
	        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
	    }

	    // Actualizar un cliente
	    public Cliente updateCliente(Long id, Cliente clienteActualizado) {
	        Cliente clienteExistente = clienteRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
	        
	        // Actualizar los campos necesarios
	        clienteExistente.setContrasena(clienteActualizado.getContrasena());
	        clienteExistente.setEstado(clienteActualizado.isEstado());
	       
	        // Guardar el cliente actualizado
	        return clienteRepository.save(clienteExistente);
	    }

	    // Eliminar un cliente
	    public void deleteCliente(Long id) {
	        clienteRepository.deleteById(id);
	    }
	
}
