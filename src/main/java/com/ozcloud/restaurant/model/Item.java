package com.ozcloud.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ozcloud.restaurant.enums.ItemType;
import com.ozcloud.restaurant.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy= InheritanceType.JOINED)
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemgen")
    private long itemId;
    private String name;
    @Lob
    private String description;

    private String image;
    private String videoUrl;
    private int status;
    private int itemType;
    private int orderNo;

    @OneToMany
    @JsonIgnore
    @JoinColumn(name = "parent_id")
    private List<Item> children = new LinkedList<Item>();

    public ItemType getItemType () {
        return ItemType.parse(this.itemType);
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType.getValue();
    }

    public Status getStatus () {
        return Status.parse(this.status);
    }

    public void setStatus(Status status) {
        this.status = status.getValue();
    }

}
