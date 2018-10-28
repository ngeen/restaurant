package com.ozcloud.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ozcloud.restaurant.enums.ProductStatus;
import com.ozcloud.restaurant.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

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
    private BigDecimal price;

    @OneToMany
    @JsonIgnore
    @JoinColumn(name = "itemExtId")
    @JsonBackReference
    private List<ProductExtension> itemExtList = new LinkedList<ProductExtension>();

    public ProductStatus getProductStatus () {
        return ProductStatus.parse(this.productStatus);
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus.getValue();
    }

}
