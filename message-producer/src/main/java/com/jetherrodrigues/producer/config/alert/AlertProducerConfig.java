package com.jetherrodrigues.producer.config.alert;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlertProducerConfig {

    public static String DIRECT_ALERT_HA_QUEUE_EXCHANGE = "exchange.alert.ha";
    public static String DIRECT_ALERT_HA_QUEUE_DLQ_EXCHANGE = "exchange.alert.ha.dlq";

    public static String ALERT_HA_QUEUE = "queue.ha.alert";
    public static String ALERT_HA_QUEUE_BINDING_KEY = "bindingKey.alert.ha";
    public static String ALERT_HA_QUEUE_DLQ = "queue.alert.ha.dlq";
    public static String ALERT_HA_QUEUE_DLQ_BINDING_KEY = "bindingKey.alert.ha.dlq";

    @Bean
    DirectExchange alertExchange() {
        return ExchangeBuilder
                .directExchange(DIRECT_ALERT_HA_QUEUE_EXCHANGE)
                .durable(true)
                .build();
    }

    @Bean
    DirectExchange alertDlqExchange() {
        return ExchangeBuilder
                .directExchange(DIRECT_ALERT_HA_QUEUE_DLQ_EXCHANGE)
                .durable(true)
                .build();
    }


    @Bean
    Queue alertQueue() {
        return QueueBuilder
                .durable(ALERT_HA_QUEUE)
                .deadLetterExchange(DIRECT_ALERT_HA_QUEUE_DLQ_EXCHANGE)
                .deadLetterRoutingKey(ALERT_HA_QUEUE_DLQ_BINDING_KEY)
                .build();
    }

    @Bean
    Queue alertDlqQueue() {
        return QueueBuilder
                .durable(ALERT_HA_QUEUE_DLQ)
                .build();
    }

    @Bean
    public Binding alertBinding() {
        return BindingBuilder.bind(alertQueue())
                .to(alertExchange())
                .with(ALERT_HA_QUEUE_BINDING_KEY);
    }

    @Bean
    public Binding alertDlqBinding() {
        return BindingBuilder.bind(alertDlqQueue())
                .to(alertDlqExchange())
                .with(ALERT_HA_QUEUE_DLQ_BINDING_KEY);
    }
}
