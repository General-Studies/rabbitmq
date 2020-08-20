package com.jetherrodrigues.producer.queue;

import com.jetherrodrigues.producer.config.alert.AlertProducerConfig;
import com.jetherrodrigues.producer.domain.Alert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class AlertProducer implements Producer<Alert> {

    private static final Logger logger = LoggerFactory.getLogger(AlertProducer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send(final Alert alert) {
        logger.info(String.format("Sending message: %s", alert));
        try {
            rabbitTemplate.convertAndSend(
                    AlertProducerConfig.DIRECT_ALERT_HA_QUEUE_EXCHANGE,
                    AlertProducerConfig.ALERT_HA_QUEUE_BINDING_KEY,
                    alert
            );
        } catch (final Exception ex) {
            logger.error(String.format("Error on send message: %s, %s", alert, ex.getMessage()));
            throw new AmqpRejectAndDontRequeueException(ex);
        }
    }
}
