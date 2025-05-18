package com.example.notification.service;

import com.example.notification.config.RabbitMQConfig;
import com.example.notification.model.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendNotification(Notification notification) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE,
                RabbitMQConfig.ROUTING_KEY,
                notification
        );
        System.out.println("Notification published to queue: " + notification);
    }
}
