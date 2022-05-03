package com.kln.lms.api.emails;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service @Slf4j @AllArgsConstructor
public class SendGridEmailService implements EmailService{

    private SendGrid sendGrid;

    @Autowired
    public SendGridEmailService() {
        this.sendGrid = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        log.info(System.getenv("SENDGRID_API_KEY"));
    }

    @Override
    public void sendEmail(EmailModel email) throws IOException {

        Email from = new Email("hasinisama99@gmail.com");
        String subject = email.getSubject();
        Email to = new Email(email.getReceiver());

        Content content = new Content("text/plain",email.getBody());

        Mail mail = new Mail(from, subject, to, content);

        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
//            Response response = this.sendGrid.api(request);
            this.sendGrid.api(request);
            log.info("done");
//            log.info(response.getBody());
        } catch (IOException ex) {
            throw ex;
        }
    }
}
