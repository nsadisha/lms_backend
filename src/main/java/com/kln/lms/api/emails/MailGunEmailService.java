package com.kln.lms.api.emails;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MailGunEmailService implements EmailService{

    private static final String DOMAIN_NAME = "sandbox73944287eef348c7a66b5898cd5cf8e6.mailgun.org";
    private static final String API_KEY = "142c96fb3ed425a980b32b05884b41cf-fe066263-1f6c211c";

    @Override
    public void sendEmail(EmailModel email) throws IOException {

        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + DOMAIN_NAME + "/messages")
                .basicAuth("api", API_KEY)
                .field("from", "lms@lms.com")
                .field("to", email.getReceiver())
                .field("subject", email.getSubject())
                .field("text", email.getBody())
                .asJson();


    }


}

//throw an email execption
