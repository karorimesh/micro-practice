package org.example.communication.service;

import org.example.communication.dto.EmailContent;
import org.example.communication.dto.EmailSenderResponse;
import org.example.communication.enums.AppConstants;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
public class EmailServiceImpl implements EmailService{

    private JavaMailSender javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public EmailSenderResponse sendEmail(EmailContent emailContent) {
        SimpleMailMessage email = new SimpleMailMessage();

        email.setFrom(emailContent.from());
        email.setTo(emailContent.to());
        email.setText(emailContent.content());
        email.setSubject(emailContent.subject());

        try {
            javaMailSender.send(email);
            return new EmailSenderResponse(
                    AppConstants.SUCCESS.getValue(),
                    AppConstants.SUCCESS_MAIL_SEND.getValue(),
                    new Date());
        } catch (MailSendException e){
            return new EmailSenderResponse(
                    AppConstants.FAILED.getValue(),
                    AppConstants.FAIL_MAIL_SEND.getValue(),
                    new Date());
        }
    }
}
