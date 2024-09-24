package com.rocketseat.planner.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue invitationQueue() {
        return new Queue("invitationQueue", false);
    }

    @Bean
    public Queue confirmationQueue() {
        return new Queue("confirmationQueue", false);
    }


}
