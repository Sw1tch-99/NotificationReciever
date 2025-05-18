package com.example.notification.service;

import com.example.notification.model.Notification;
import com.example.notification.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository repository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private SmsService smsService;

    @Autowired
    private InAppService inAppService;

    public String sendNotification(Notification notification) {
        String type = notification.getType();
        if (type == null || type.isEmpty()) {
            return "Notification type is missing.";
        }

        try {
            switch (type.toLowerCase()) {
                case "email":
                    emailService.sendEmail(notification);
                    break;
                case "sms":
                    smsService.sendSms(notification);
                    break;
                case "in-app":
                    inAppService.saveInAppNotification(notification);
                    break;
                default:
                    return "Invalid notification type: " + type;
            }

            notification.setStatus("SENT");
        } catch (Exception e) {
            notification.setStatus("FAILED");
            return "Failed to send notification: " + e.getMessage();
        }

        repository.save(notification);
        return "Notification sent successfully.";
    }

    public List<Notification> getUserNotifications(String userId) {
        return repository.findByUserId(userId);
    }
}
