package com.example.cuentaMovimiento_service;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class CuentaMovimientoServiceApplicationTests {

	 @MockBean
	    private RabbitTemplate rabbitTemplate;  // Simula la interacción con RabbitMQ

	@Test
	void contextLoads() {
		System.out.println("Test");
	}

}
