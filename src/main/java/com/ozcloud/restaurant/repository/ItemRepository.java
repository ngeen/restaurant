package com.ozcloud.restaurant.repository;

import com.ozcloud.restaurant.model.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {
    public List<Item> findAllByOrderByItemTypeAsc();
}
