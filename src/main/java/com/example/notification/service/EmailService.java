package com.example.notification.service;

import com.example.notification.model.Notification;

public interface EmailService {
    void sendEmail(Notification notification);
}
