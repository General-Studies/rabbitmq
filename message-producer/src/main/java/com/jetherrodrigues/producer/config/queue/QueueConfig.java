package com.jetherrodrigues.producer.config.queue;

import com.jetherrodrigues.producer.domain.Alert;
import com.jetherrodrigues.producer.domain.User;
import com.jetherrodrigues.producer.queue.AlertProducer;
import com.jetherrodrigues.producer.queue.NotificationProducer;
import com.jetherrodrigues.producer.queue.Producer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @Bean
    @Qualifier("AlertProducer")
    public Producer<Alert> alertProducer() {
        return new AlertProducer();
    }

    @Bean
    @Qualifier("NotificationProducer")
    public Producer<User> notificationProducer() {
        return new NotificationProducer();
    }

}
