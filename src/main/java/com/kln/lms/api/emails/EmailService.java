package com.kln.lms.api.emails;

import java.io.IOException;

public interface EmailService {
    void sendEmail(EmailModel email) throws IOException;
}
