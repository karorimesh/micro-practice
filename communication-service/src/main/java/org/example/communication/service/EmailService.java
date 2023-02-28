package org.example.communication.service;

import org.example.communication.dto.EmailContent;
import org.example.communication.dto.EmailSenderResponse;

public interface EmailService {
    EmailSenderResponse sendEmail(EmailContent emailContent);
}
