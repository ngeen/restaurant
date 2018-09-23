package com.ozcloud.restaurant.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Venue implements Serializable {

    @Id
    @GeneratedValue
    private long venueId;

    @ManyToOne
    private User user;

    private String venueName;

    private String venueImage;

    private String foursquareToken;

    private String foursquareId;

    private int infoScreenStatus;
}
