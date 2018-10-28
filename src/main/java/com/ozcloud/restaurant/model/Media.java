package com.ozcloud.restaurant.model;

import com.ozcloud.restaurant.enums.ItemType;
import com.ozcloud.restaurant.enums.MediaType;
import com.ozcloud.restaurant.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Media implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mediagen")
    private long mediaId;

    private String mediaGuid;

    private String mediaLink;

    private String fileName;

    private int mediaType;

    private int status;

    @ManyToOne
    @JoinColumn(name = "userMediaId", nullable = true)
    private User user;

    @ManyToOne
    @JoinColumn(name = "itemMediaId", nullable = true)
    private Item menuItem;

    @ManyToOne
    @JoinColumn(name = "venueMediaId", nullable = true)
    private Venue venue;

    public MediaType getMediaType () {
        return MediaType.parse(this.mediaType);
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType.getValue();
    }

    public Status getStatus () {
        return Status.parse(this.status);
    }

    public void setStatus(Status status) {
        this.status = status.getValue();
    }
}
