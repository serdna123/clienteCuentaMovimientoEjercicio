package com.diegog.clientePersona_service.publisher;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class ClientePublisher {

    private final RabbitTemplate rabbitTemplate;
    private final Queue clienteQueue;

    public ClientePublisher(RabbitTemplate rabbitTemplate, Queue clienteQueue) {
        this.rabbitTemplate = rabbitTemplate;
        this.clienteQueue = clienteQueue;
    }

    public void send(Object message) {
        rabbitTemplate.convertAndSend(clienteQueue.getName(), message);
    }
}
