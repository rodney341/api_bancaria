package com.example.cuenta.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String CLIENTE_QUEUE = "cliente.creado";

    @Bean
    public Queue clienteQueue() {
        return new Queue(CLIENTE_QUEUE, false);
    }
}
