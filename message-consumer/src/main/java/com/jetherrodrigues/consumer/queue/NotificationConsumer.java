package com.jetherrodrigues.consumer.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class NotificationConsumer implements Consumer<UserMessage> {

    private static final Logger logger = LoggerFactory.getLogger(NotificationConsumer.class);

    public static final String NOTIFICATION_HA_QUEUE = "queue.notification.ha";

    @Override
    @RabbitListener(queues = NOTIFICATION_HA_QUEUE)
    public void consume(final UserMessage userMessage) {
        logger.info(String.format("Consuming message: %s", userMessage.toUser()));
    }

}
