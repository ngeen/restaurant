package com.ozcloud.restaurant.enums;

public enum ProductStatus {
    NORMAL(0), NEW(5), DISCOUNTED(7);

    private int value;

    ProductStatus(int value) { this.value = value; }

    public int getValue() { return value; }

    public static ProductStatus parse(int id) {
        ProductStatus productStatus = null; // Default
        for (ProductStatus item : ProductStatus.values()) {
            if (item.getValue()==id) {
                productStatus = item;
                break;
            }
        }
        return productStatus;
    }
}
