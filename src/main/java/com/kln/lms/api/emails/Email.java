package com.kln.lms.api.emails;

public class Email {

    private String receiver;
    private String subject;
    private String body;

    public Email(String receiver, String subject, String body) {
        this.receiver = receiver;
        this.subject = subject;
        this.body = body;
    }
}
