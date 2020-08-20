package com.jetherrodrigues.producer.queue;

import com.jetherrodrigues.producer.config.notification.NotificationProducerConfig;
import com.jetherrodrigues.producer.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationProducer implements Producer<User> {

    private static final Logger logger = LoggerFactory.getLogger(NotificationProducer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send(final User user) {
        logger.info(String.format("Sending message: %s", user));
        try {
            rabbitTemplate.convertAndSend(
                    NotificationProducerConfig.DIRECT_NOTIFICATION_HA_QUEUE_EXCHANGE,
                    NotificationProducerConfig.NOTIFICATION_HA_QUEUE,
                    user
            );
        } catch (final Exception ex) {
            logger.error(String.format("Error on send message: %s, %s", user, ex.getMessage()));
            throw new AmqpRejectAndDontRequeueException(ex);
        }
    }
}
