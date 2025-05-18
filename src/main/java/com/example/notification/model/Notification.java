package com.example.notification.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Notification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String type;        // "email", "sms", or "in-app"
    private String recipient;
    private String subject;
    private String message;
    private String status;      // "SENT", "FAILED", etc.

    // Default constructor
    public Notification() {}

    // All-args constructor (optional, helpful in tests or manual creation)
    public Notification(String userId, String type, String recipient, String subject, String message, String status) {
        this.userId = userId;
        this.type = type;
        this.recipient = recipient;
        this.subject = subject;
        this.message = message;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Optional: For logging/debugging
    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", type='" + type + '\'' +
                ", recipient='" + recipient + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
