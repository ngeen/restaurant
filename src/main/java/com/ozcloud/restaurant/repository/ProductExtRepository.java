package com.ozcloud.restaurant.repository;

import com.ozcloud.restaurant.model.Product;
import com.ozcloud.restaurant.model.ProductExtension;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductExtRepository extends CrudRepository<ProductExtension, Long> {
    ProductExtension findByPExtGuid(String guid);
}
