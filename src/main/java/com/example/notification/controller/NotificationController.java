package com.example.notification.controller;

import com.example.notification.model.Notification;
import com.example.notification.service.NotificationProducer;
import com.example.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NotificationController {

    @Autowired
    private NotificationProducer producer;

    @Autowired
    private NotificationService notificationService;

    // Send notification via RabbitMQ
    @PostMapping("/notifications")
    public String sendNotification(@RequestBody Notification notification) {
        producer.sendNotification(notification);
        return "Notification has been queued successfully.";
    }

    // Get all notifications by user ID
    @GetMapping("/users/{id}/notifications")
    public List<Notification> getUserNotifications(@PathVariable("id") String userId) {
        return notificationService.getUserNotifications(userId);
    }
}
