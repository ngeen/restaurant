package com.ozcloud.restaurant.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {

    private long id;
    private String itemGuid;
    private String name;
    private String description;

    private String image;
    private String videoUrl;
    private String status;
    private String itemType;
    private int orderNo;
    private long parentId;

}
