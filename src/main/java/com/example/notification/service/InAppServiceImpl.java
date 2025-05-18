package com.example.notification.service;

import com.example.notification.model.Notification;
import com.example.notification.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InAppServiceImpl implements InAppService {

    @Autowired
    private NotificationRepository repository;

    @Override
    public void saveInAppNotification(Notification notification) {
        // Mark it as delivered or pending for UI fetching
        notification.setStatus("DELIVERED");
        repository.save(notification);
    }
}
