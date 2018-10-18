package com.ozcloud.restaurant.repository;

import com.ozcloud.restaurant.model.Item;
import com.ozcloud.restaurant.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {
    public List<Item> findAllByOrderByItemTypeAsc();
    Item findByItemGuid(String guid);
    public List<Item> findAllByUser(User user);
}
