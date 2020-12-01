package donghyeon.dev.rabbitmqsubscriber.service;

import donghyeon.dev.rabbitmqsubscriber.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMessageListener {

    @RabbitListener(queues = "user")
    public void receiveMessage(final User user){
        System.out.println(user.toString());
    }

}
