package com.ozcloud.restaurant.repository;

import com.ozcloud.restaurant.model.Media;
import com.ozcloud.restaurant.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediaRepository extends CrudRepository<Media, Long> {
    Media findByMediaGuid(String guid);

    public List<Media> findAllByUser(User user);
}
