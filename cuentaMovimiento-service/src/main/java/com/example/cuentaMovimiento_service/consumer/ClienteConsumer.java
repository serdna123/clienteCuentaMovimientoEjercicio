package com.example.cuentaMovimiento_service.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.example.cuentaMovimiento_service.dto.ClienteDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ClienteConsumer {

	@RabbitListener(queues = { "${cliente-queue.name}" })
	public void receive(@Payload ClienteDTO message) {
		log.info("Mensaje recibido con: '{}'", message);
		makeSlow();
	}

	private void makeSlow() {
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
