package org.example.eligibility.dto;

public record EligibilityCheckResponse(String status, boolean eligible, String message) {
}
