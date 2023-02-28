package org.example.communication.dto;

import java.util.Date;

public record EmailSenderResponse(String status, String message, Date timestamp) {
}
