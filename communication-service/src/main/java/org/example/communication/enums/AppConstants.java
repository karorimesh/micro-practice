package org.example.communication.enums;

import java.util.Objects;

public enum AppConstants {
    SUCCESS ("200"),
    FAILED ("500"),
    SUCCESS_MAIL_SEND ("Email sent successfully"),
    FAIL_MAIL_SEND ("Email not sent successfully");

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
