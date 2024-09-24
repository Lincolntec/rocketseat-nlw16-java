package com.rocketseat.planner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rocketseat.planner.service.RabbitMQSender;


@RestController
@RequestMapping("/travel")
public class TravelController {

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @PostMapping("/invite")
    public String invite(@RequestBody String email){
        rabbitMQSender.sendInvitation(email);
        return "Convite enviado para" +email;
    }

    @PostMapping("/confirm")
    public String confirm(@RequestBody String email) {
        rabbitMQSender.sendConfirmation(email);
        return "Confirmação enviada para " + email;
    }

}
