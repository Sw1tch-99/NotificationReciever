package com.example.notification.listener;

import com.example.notification.config.RabbitMQConfig;
import com.example.notification.model.Notification;
import com.example.notification.service.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    @Autowired
    private NotificationService notificationService;

    @RabbitListener(queues = RabbitMQConfig.QUEUE, containerFactory = "rabbitListenerContainerFactory")
    public void handleNotification(Notification notification) {
        System.out.println("Received notification from queue: " + notification);
        notificationService.sendNotification(notification);
    }
}
