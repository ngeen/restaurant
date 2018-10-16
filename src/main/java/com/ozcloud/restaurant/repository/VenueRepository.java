package com.ozcloud.restaurant.repository;

import com.ozcloud.restaurant.model.User;
import com.ozcloud.restaurant.model.Venue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenueRepository extends CrudRepository<Venue, Long> {
    Venue findByVenueGuid(String guid);
    List<Venue> findAllByUserOrderByVenueIdDesc(User user);
}
