package com.ozcloud.restaurant.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ProductDTO extends  ItemDTO {
    private int prepareTime;
    private int calories;
    private String productStatus;
    private boolean isVirtualCategory;
    private int virtualOrderNo;
    private BigDecimal price;
    private List<MediaDTO> medias;
}
