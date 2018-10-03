package com.ozcloud.restaurant.repository;

import com.ozcloud.restaurant.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
