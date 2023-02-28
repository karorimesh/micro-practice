package org.example.accounts.dto;

import java.util.Date;
import java.util.UUID;

public record AccountCreateResponse(String status, String message, UUID accountId, String accountNumber, Date timestamp) {
}
