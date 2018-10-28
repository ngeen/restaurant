package com.ozcloud.restaurant.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductExtDTO {

    private String pExtGuid;
    private String pExtName;
    private String pExtDescription;
    private BigDecimal pExtPrice;
    private long pExtItemId;
}
