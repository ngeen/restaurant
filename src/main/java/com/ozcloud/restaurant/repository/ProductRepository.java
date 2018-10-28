package com.ozcloud.restaurant.repository;

import com.ozcloud.restaurant.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findByItemGuid(String guid);
}
