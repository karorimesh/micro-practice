package org.example.eligibility.service;

import org.example.eligibility.dto.EligibilityRequest;
import org.example.eligibility.dto.EligibilityCheckResponse;
import org.example.eligibility.enums.AppConstants;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CheckEligibilityImpl implements CheckEligibility{

    @Override
    public EligibilityCheckResponse checkEligibility(EligibilityRequest eligibilityRequest) {
        boolean isEligible = new Random().nextBoolean();
        String message = isEligible ?
                AppConstants.ELIGIBILITY_PASS_MESSAGE.getValue() :
                AppConstants.ELIBILITY_FAIL_MESSAGE.getValue();
        String status = isEligible ? AppConstants.SUCCESS.getValue() : AppConstants.FAILED.getValue();
        return new EligibilityCheckResponse(status, true, message);
    }
}
