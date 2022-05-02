package com.kln.lms.api.emails;

import java.io.IOException;

public interface EmailService {
    void sendEmail(Emails email) throws IOException;
}
