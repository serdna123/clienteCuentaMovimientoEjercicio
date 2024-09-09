package com.example.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	  @Bean
	    public TopicExchange clienteExchange() {
	        return new TopicExchange("cliente-exchange");
	    }

	    @Bean
	    public Queue clienteQueue() {
	        return new Queue("cliente-queue", true);
	    }

	    @Bean
	    public Binding binding(Queue clienteQueue, TopicExchange clienteExchange) {
	        return BindingBuilder.bind(clienteQueue).to(clienteExchange).with("cliente.*");
	    }
	
	    @Bean
	    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
	        return new Jackson2JsonMessageConverter();
	    }

	    @Bean
	    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
	        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
	        factory.setConnectionFactory(connectionFactory);
	        factory.setMessageConverter(jackson2JsonMessageConverter());
	        return factory;
	    }
}
