package com.ozcloud.restaurant.model;

import com.ozcloud.restaurant.enums.ProductStatus;
import com.ozcloud.restaurant.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends  Item {

    private int prepareTime;
    private int calories;
    private int productStatus;
    private boolean isVirtualCategory;
    private int virtualOrderNo;

    public ProductStatus getProductStatus () {
        return ProductStatus.parse(this.productStatus);
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus.getValue();
    }

}
