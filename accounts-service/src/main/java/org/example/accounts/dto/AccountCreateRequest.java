package org.example.accounts.dto;

import java.util.UUID;

public record AccountCreateRequest(UUID accountOwner, boolean active, double balance) {
}
