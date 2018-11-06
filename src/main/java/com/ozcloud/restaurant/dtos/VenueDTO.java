package com.ozcloud.restaurant.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VenueDTO {

    private String venueGuid;

    private String venueName;

    private String venueImage;

    private String foursquareToken;

    private String foursquareId;

    private int infoScreenStatus;

    private long menuItemId;
}
