package com.ozcloud.restaurant.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO extends  ItemDTO {
    private int prepareTime;
    private int calories;
    private String productStatus;
    private boolean isVirtualCategory;
    private int virtualOrderNo;
}
