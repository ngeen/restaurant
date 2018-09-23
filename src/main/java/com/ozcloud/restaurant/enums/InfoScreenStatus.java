package com.ozcloud.restaurant.enums;

public enum InfoScreenStatus {
    disabled (0),
    enabled (1);

    private final int infoScreenStatusCode;

    InfoScreenStatus(int infoScreenStatusCode) {
        this.infoScreenStatusCode = infoScreenStatusCode;
    }

    public int getInfoScreenStatusCode() {
        return this.infoScreenStatusCode;
    }
}
