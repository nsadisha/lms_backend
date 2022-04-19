package com.kln.lms.api.emails;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import java.io.IOException;

public class EmailSender {

    public void send(Emails email) throws IOException {


        String subject = email.getSubject();
        Email to = new Email(email.getReceiver());
        Email from = new Email("text@text.com");

        Content content = new Content("text/html",email.getBody());

        Mail mail = new Mail(from, subject, to, content);

        SendGrid sendgridApiKey = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();

        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());


    }


}
