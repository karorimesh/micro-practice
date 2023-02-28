package org.example.eligibility.enums;

import java.util.Objects;

public enum AppConstants {
    SUCCESS ("200"),
    FAILED ("200"),
    ELIGIBILITY_PASS_MESSAGE ("Applicant passed"),
    ELIBILITY_FAIL_MESSAGE ("Applicant failed because ...");

    private String value;
    AppConstants(String s) {
        this.value = s;
    }

    public String getValue() {
        return value;
    }

    public static AppConstants appConstants(String s) {
        AppConstants value = null;
        for (AppConstants type : AppConstants.values()) {
            if (Objects.equals(type.getValue(), s))
                value = type;
        }
        return value;
    }
}
