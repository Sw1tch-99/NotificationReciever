package com.example.notification.service;

import com.example.notification.model.Notification;

public interface SmsService {
    void sendSms(Notification notification);
}
