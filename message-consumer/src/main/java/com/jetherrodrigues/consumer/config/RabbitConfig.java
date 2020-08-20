package com.jetherrodrigues.consumer.config;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public SimpleRabbitListenerContainerFactory factory(
            final ConnectionFactory connectionFactory,
            final SimpleRabbitListenerContainerFactoryConfigurer configurator
    ) {
       final SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
       configurator.configure(factory, connectionFactory);
       factory.setMessageConverter(messageConverter());
       return factory;
    }
}
