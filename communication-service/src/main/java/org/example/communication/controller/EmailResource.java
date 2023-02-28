package org.example.communication.controller;

import org.example.communication.dto.EmailContent;
import org.example.communication.dto.EmailSenderResponse;
import org.example.communication.service.EmailService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailResource {

    private final EmailService emailService;

    public EmailResource(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<EmailSenderResponse> sendMail(@RequestBody EmailContent emailContent) {
        EmailSenderResponse emailSenderResponse = emailService.sendEmail(emailContent);
        return new ResponseEntity<>(
                emailSenderResponse,
                HttpStatusCode.valueOf(Integer.parseInt(emailSenderResponse.status())
                ));
    }
}
