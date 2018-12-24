package com.xiaoping.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    /**
     * food 队列
     * @return
     */
    @Bean
    public Queue foodQueue() {
        return new Queue("food");
    }

}
