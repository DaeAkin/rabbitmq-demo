package donghyeon.dev.rabbitmqpublisher.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import donghyeon.dev.rabbitmqpublisher.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static donghyeon.dev.rabbitmqpublisher.config.RabbitConfig.EXCHANGE_NAME;
import static donghyeon.dev.rabbitmqpublisher.config.RabbitConfig.ROUTING_KEY;

@RestController
@RequiredArgsConstructor
public class PubController {

    private final RabbitTemplate rabbitTemplate;

    @PostMapping("/api/v1/user")
    public void saveUser() {
        User user = new User("donghyeon",25);
        System.out.println("sending Message");

        rabbitTemplate.convertAndSend(EXCHANGE_NAME,ROUTING_KEY,user);
    }
}
