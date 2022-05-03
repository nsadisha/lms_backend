package com.kln.lms.api.emails;

public class EmailModel {

    private String receiver;
    private String subject;
    private String body;

    public EmailModel(String receiver, String subject, String body) {
        this.receiver = receiver;
        this.subject = subject;
        this.body = body;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }
}
