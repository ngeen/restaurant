package com.ozcloud.restaurant.repository;

import com.ozcloud.restaurant.model.Item;
import com.ozcloud.restaurant.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
    public List<Item> findAllByOrderByItemTypeAsc();
    Item findByItemGuid(String guid);
    public List<Item> findAllByUser(User user);
    public Item findByItemId(long id);
}
