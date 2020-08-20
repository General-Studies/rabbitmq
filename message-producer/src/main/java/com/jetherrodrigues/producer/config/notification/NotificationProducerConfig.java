package com.jetherrodrigues.producer.config.notification;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationProducerConfig {

    public static String DIRECT_NOTIFICATION_HA_QUEUE_EXCHANGE = "exchange.notification.ha";
    public static String DIRECT_NOTIFICATION_HA_QUEUE_DLQ_EXCHANGE = "exchange.notification.ha.dlq";

    public static String NOTIFICATION_HA_QUEUE = "queue.notification.ha";
    public static String NOTIFICATION_HA_QUEUE_BINDING_KEY = "bindingKey.notification.ha";
    public static String NOTIFICATION_HA_QUEUE_DLQ = "queue.notification.ha.dlq";
    public static String NOTIFICATION_HA_QUEUE_DLQ_BINDING_KEY = "bindingKey.notification.ha.dlq";

    @Bean
    DirectExchange notificationExchange() {
        return ExchangeBuilder
                .directExchange(DIRECT_NOTIFICATION_HA_QUEUE_EXCHANGE)
                .durable(true)
                .build();
    }

    @Bean
    DirectExchange notificationDlqExchange() {
        return ExchangeBuilder
                .directExchange(DIRECT_NOTIFICATION_HA_QUEUE_DLQ_EXCHANGE)
                .durable(true)
                .build();
    }


    @Bean
    Queue notificationQueue() {
        return QueueBuilder
                .durable(NOTIFICATION_HA_QUEUE)
                .deadLetterExchange(DIRECT_NOTIFICATION_HA_QUEUE_DLQ_EXCHANGE)
                .deadLetterRoutingKey(NOTIFICATION_HA_QUEUE_DLQ_BINDING_KEY)
                .build();
    }

    @Bean
    Queue notificationDlqQueue() {
        return QueueBuilder
                .durable(NOTIFICATION_HA_QUEUE_DLQ)
                .build();
    }

    @Bean
    public Binding notificationBinding() {
        return BindingBuilder.bind(notificationQueue())
                .to(notificationExchange())
                .with(NOTIFICATION_HA_QUEUE_BINDING_KEY);
    }

    @Bean
    public Binding notificationDlqBinding() {
        return BindingBuilder.bind(notificationDlqQueue())
                .to(notificationDlqExchange())
                .with(NOTIFICATION_HA_QUEUE_DLQ_BINDING_KEY);
    }
}
