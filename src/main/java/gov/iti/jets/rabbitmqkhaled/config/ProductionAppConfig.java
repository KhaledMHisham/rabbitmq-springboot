package gov.iti.jets.rabbitmqkhaled.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("production")
@Configuration
public class ProductionAppConfig {

    @Bean
    public Queue productionMsgQueue(){
        return new Queue("production");
    }

}
