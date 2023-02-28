package org.example.eligibility.controller;

import org.example.eligibility.dto.EligibilityCheckResponse;
import org.example.eligibility.dto.EligibilityRequest;
import org.example.eligibility.service.CheckEligibility;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eligible")
public class EligibilityResource {

    private CheckEligibility checkEligibility;

    public EligibilityResource(CheckEligibility checkEligibility) {
        this.checkEligibility = checkEligibility;
    }

    @PostMapping
    public ResponseEntity<EligibilityCheckResponse> checkEligibility (@RequestBody EligibilityRequest eligibilityRequest){
        EligibilityCheckResponse eligibilityCheckResponse = checkEligibility.checkEligibility(eligibilityRequest);
        return new ResponseEntity<>(
                eligibilityCheckResponse,
                HttpStatusCode.valueOf(Integer.parseInt(eligibilityCheckResponse.status()))
        );
    }
}
