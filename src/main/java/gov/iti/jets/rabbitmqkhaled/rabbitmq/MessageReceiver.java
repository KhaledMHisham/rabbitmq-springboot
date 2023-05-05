package gov.iti.jets.rabbitmqkhaled.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("receiver")
@Component
@RabbitListener(queues = "production")
public class MessageReceiver {

    @RabbitHandler
    public void receive(String in){
        System.out.println(" [x] Received '" + in + "'");
    }

}
