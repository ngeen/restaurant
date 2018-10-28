package com.ozcloud.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Venue implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venuegen")
    private long venueId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "menuItemId", nullable = true)
    private Item menuItem;

    @OneToMany
    @JsonIgnore
    @JoinColumn(name = "venueMediaId")
    @JsonBackReference
    private List<Media> venueMediaList = new LinkedList<Media>();

    private String venueName;

    private String venueImage;

    private String foursquareToken;

    private String foursquareId;

    private String venueGuid;

    private int infoScreenStatus;
}
