package com.autorent.model;

public class ContactMessage {
    private int messageId;
    private int userId;
    private String name;
    private String email;
    private String messageBody;
    private String subject;

    // Constructors, Getters & Setters


    public ContactMessage() {
    }

    public ContactMessage(int messageId, int userId, String name, String email, String messageBody, String subject) {
        this.messageId = messageId;
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.messageBody = messageBody;
        this.subject = subject;
    }

    public ContactMessage(int userId, String name, String email, String messageBody, String subject) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.messageBody = messageBody;
        this.subject = subject;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
