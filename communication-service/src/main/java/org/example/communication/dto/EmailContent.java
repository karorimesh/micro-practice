package org.example.communication.dto;

public record EmailContent(String subject, String to, String from, String content) {
}
