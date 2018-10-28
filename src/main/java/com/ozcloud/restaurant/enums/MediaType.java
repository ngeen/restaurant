package com.ozcloud.restaurant.enums;

public enum MediaType {
    USER(1), VENUE(5), ITEM(10);

    private int value;

    MediaType(int value) { this.value = value; }

    public int getValue() { return value; }

    public static MediaType parse(int id) {
        MediaType itemType = null; // Default
        for (MediaType item : MediaType.values()) {
            if (item.getValue()==id) {
                itemType = item;
                break;
            }
        }
        return itemType;
    }
}
