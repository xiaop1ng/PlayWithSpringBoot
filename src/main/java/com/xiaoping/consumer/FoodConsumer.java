package com.xiaoping.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "food")
public class FoodConsumer {

    @RabbitHandler
    public void process(String food) {
        System.out.println("开始消费 : " + food);
    }

}
