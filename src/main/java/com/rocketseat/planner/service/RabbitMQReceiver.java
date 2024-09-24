package com.rocketseat.planner.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQReceiver {

    @Autowired
    private JavaMailSender eMailSender;

    @RabbitListener(queues = "invitationQueue")
    public void receiveInvitation(String email) {
        sendInvitationEmail(email);
    }

    public void  sendInvitationEmail( String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("lincoln_tec@hotmail.com");
        message.setSubject("Convite para viagem ");
        message.setText("Você está convidado para uma viagem! Por favor, confirme sua presença respondendo a este e-mail");;
        eMailSender.send(message);
    }

    public void sendConfirmationEmail( String to ) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("zelincolin7@gmail.com");
        message.setSubject("Confirmação de presença na viagem");
        message.setText("Obrigado por confirmar sua presença na viagem!");
        eMailSender.send(message);
    }


}
