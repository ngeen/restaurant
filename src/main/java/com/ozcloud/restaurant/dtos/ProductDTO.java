package com.ozcloud.restaurant.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDTO extends  ItemDTO {
    private int prepareTime;
    private int calories;
    private String productStatus;
    private boolean isVirtualCategory;
    private int virtualOrderNo;
    private BigDecimal price;
}
