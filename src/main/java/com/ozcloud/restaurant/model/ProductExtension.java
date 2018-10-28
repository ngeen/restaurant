package com.ozcloud.restaurant.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductExtension implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pextgen")
    private long pExtId;
    private String pExtGuid;
    private String pExtName;
    @Lob
    private String pExtDescription;
    private BigDecimal pExtPrice;
    @ManyToOne
    @JoinColumn(name = "itemExtId", nullable = true)
    private Item pExtItem;
}
