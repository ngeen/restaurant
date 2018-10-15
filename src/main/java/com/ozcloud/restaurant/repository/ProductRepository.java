package com.ozcloud.restaurant.repository;

import com.ozcloud.restaurant.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findByItemGuid(String guid);
}
