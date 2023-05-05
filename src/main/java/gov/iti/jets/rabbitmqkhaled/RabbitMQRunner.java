package gov.iti.jets.rabbitmqkhaled;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQRunner implements CommandLineRunner {
    @Value("${spring.rabbitmq.host}")
    private String host;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Ready ... running rabbit MQ");
    }
}