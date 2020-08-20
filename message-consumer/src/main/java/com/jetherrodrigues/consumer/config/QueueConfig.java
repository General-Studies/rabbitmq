package com.jetherrodrigues.consumer.config;

import com.jetherrodrigues.consumer.queue.AlertConsumer;
import com.jetherrodrigues.consumer.queue.Consumer;
import com.jetherrodrigues.consumer.queue.NotificationConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @Bean
    public Consumer<?> notificationConsumer() {
        return new NotificationConsumer();
    }

    @Bean
    public Consumer<?> alertConsumer() {
        return new AlertConsumer();
    }

}
