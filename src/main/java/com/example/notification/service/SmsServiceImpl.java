package com.example.notification.service;

import com.example.notification.model.Notification;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl implements SmsService {

    @Override
    public void sendSms(Notification notification) {
        // For now, simulate SMS sending
        System.out.println("Sending SMS to " + notification.getRecipient());
        System.out.println("Message: " + notification.getMessage());

        // Integrate Twilio or other APIs here in real projects
    }
}
