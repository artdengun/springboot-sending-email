package com.deni.gunawan.springsendingemail.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;

import com.deni.gunawan.springsendingemail.controllers.NotifEmailListener;

@Configuration
@EnableRetry
public class RabbitMqConfig {
    
        @Autowired
    private AppProperties appProperties;

    @Bean
    Queue emailQueue() {
        return new Queue( appProperties.getRabbitMqQueue(), false);
    }

    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(appProperties.getRabbitMqHost());
        connectionFactory.setPort(appProperties.getRabbitMqPort());
        connectionFactory.setUsername(appProperties.getRabbitMqUsername());
        connectionFactory.setPassword(appProperties.getRabbitMqPassword());
        connectionFactory.resetConnection();
        return connectionFactory;
    }

    @Bean
    SimpleMessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer listenerContainer = new SimpleMessageListenerContainer();
        listenerContainer.setConnectionFactory(connectionFactory);
        listenerContainer.setMessageListener(listenerAdapter);
        listenerContainer.setDefaultRequeueRejected(false);
        listenerContainer.setRecoveryInterval(appProperties.getRabbitMqRecoveryInterval());
        listenerContainer.setReceiveTimeout(appProperties.getRabbitMqReceiveTimeout());
        listenerContainer.setQueues(emailQueue());
        return listenerContainer;
    }

    @Bean
    MessageListenerAdapter listener(NotifEmailListener listener) {
        return new MessageListenerAdapter(listener, AppConstant.LOG_RECEIVE_MESSAGE);
    }
}
