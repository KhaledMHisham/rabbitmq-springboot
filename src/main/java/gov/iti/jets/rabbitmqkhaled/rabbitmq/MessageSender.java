package gov.iti.jets.rabbitmqkhaled.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Profile("sender")
@Component
public class MessageSender {
    private RabbitTemplate template;
    private Queue productionMsgQueue;

    public MessageSender(RabbitTemplate template, Queue productionMsgQueue) {
        this.template = template;
        this.productionMsgQueue = productionMsgQueue;
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send(){
        String message = "Hello From MSG Sender";
        template.convertAndSend(productionMsgQueue.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
