package org.example.eligibility.service;

import org.example.eligibility.dto.EligibilityRequest;
import org.example.eligibility.dto.EligibilityCheckResponse;

public interface CheckEligibility {
    EligibilityCheckResponse checkEligibility(EligibilityRequest eligibilityRequest);
}
