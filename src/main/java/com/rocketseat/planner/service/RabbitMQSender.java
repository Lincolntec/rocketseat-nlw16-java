package com.rocketseat.planner.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendInvitation(String email) {
        rabbitTemplate.convertAndSend("invitationQueue", email);
    }

    public void sendConfirmation(String email) {
        rabbitTemplate.convertAndSend("confirmationQueue", email);
    }


}
