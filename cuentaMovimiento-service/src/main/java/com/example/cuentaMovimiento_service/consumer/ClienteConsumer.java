package com.example.cuentaMovimiento_service.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ClienteConsumer {

    @RabbitListener(queues = "cliente-queue")
    public void recibirClienteCreado(ClienteDTO clienteDTO) {
        System.out.println("Cliente creado recibido con ID: " + clienteDTO.getClienteId() + " y nombre: " + clienteDTO.getNombre());
        // Procesar el cliente recibido
    }

}
