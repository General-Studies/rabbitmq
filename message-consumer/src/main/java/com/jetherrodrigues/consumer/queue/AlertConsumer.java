package com.jetherrodrigues.consumer.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class AlertConsumer implements Consumer<AlertMessage> {

    private static final Logger logger = LoggerFactory.getLogger(AlertConsumer.class);

    public static final String ALERT_HA_QUEUE = "queue.ha.alert";

    @Override
    @RabbitListener(queues = ALERT_HA_QUEUE)
    public void consume(final AlertMessage message) {
        logger.info(String.format("Consuming message: %s", message.toAlert()));
    }

}
