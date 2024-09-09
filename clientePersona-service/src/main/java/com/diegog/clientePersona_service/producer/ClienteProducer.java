package com.diegog.clientePersona_service.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteProducer {

	@Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String EXCHANGE = "cliente-exchange";
    private static final String ROUTING_KEY = "cliente.creado";

    public void enviarClienteCreado(ClienteDTO clienteDTO) {
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, clienteDTO);
        System.out.println("Mensaje enviado: Cliente creado con ID: " + clienteDTO.getClienteId() + " y nombre " +clienteDTO.getNombre());
    }
}
