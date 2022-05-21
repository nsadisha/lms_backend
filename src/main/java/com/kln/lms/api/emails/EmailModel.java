package com.kln.lms.api.emails;

public class EmailModel {

    private String receiver;
    private String leadingTitle;
    private String title;
    private String description;
    private String sender;

    public EmailModel(String receiver, String leadingTitle, String title, String body, String sender) {
        this.receiver = receiver;
        this.title = title;
        this.description = body;
        this.sender = sender;
        this.leadingTitle = leadingTitle;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getSubject() {
        return this.leadingTitle + " :  " + this.title;
    }

    public String getBody() {
        String body = this.description + "\n\nSincerely,\n" + this.sender;
        return body;
    }
}
