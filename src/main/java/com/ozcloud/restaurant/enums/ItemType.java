package com.ozcloud.restaurant.enums;

public enum ItemType {
    MENU(1), CATEGORY(5), PRODUCT(10);

    private int value;

    ItemType(int value) { this.value = value; }

    public int getValue() { return value; }

    public static ItemType parse(int id) {
        ItemType itemType = null; // Default
        for (ItemType item : ItemType.values()) {
            if (item.getValue()==id) {
                itemType = item;
                break;
            }
        }
        return itemType;
    }
}
