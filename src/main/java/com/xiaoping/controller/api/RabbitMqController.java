package com.xiaoping.controller.api;

import com.xiaoping.pojo.Rs;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq")
public class RabbitMqController {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RequestMapping("/food")
    public Rs pushToFoodQueue(@RequestParam(required = true) String food) {
        rabbitTemplate.convertAndSend("food", food);
        return Rs.ok();
    }
}
