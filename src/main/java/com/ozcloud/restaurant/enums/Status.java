package com.ozcloud.restaurant.enums;

public enum Status {
    DRAFT(1), ACTIVE(10), PASSIVE(90);

    private int value;

    Status(int value) { this.value = value; }

    public int getValue() { return value; }

    public static Status parse(int id) {
        Status status = null; // Default
        for (Status item : Status.values()) {
            if (item.getValue()==id) {
                status = item;
                break;
            }
        }
        return status;
    }
}
