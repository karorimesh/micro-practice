package org.example.accounts.enums;

import java.util.Objects;

public enum AppConstants {
    SUCCESS ("200"),
    FAILED ("500"),
    SUCCESS_ACCOUNT_CREATE ("Account created successfully"),
    FAIL_ACCOUNT_CREATE ("Account not successfully");

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
