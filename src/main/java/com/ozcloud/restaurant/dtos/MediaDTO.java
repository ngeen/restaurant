package com.ozcloud.restaurant.dtos;

import com.ozcloud.restaurant.model.Item;
import com.ozcloud.restaurant.model.User;
import com.ozcloud.restaurant.model.Venue;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter @Setter
public class MediaDTO {

    private String mediaGuid;

    private String mediaLink;

    private String fileName;

    private int mediaType;

    private int status;

    private long userId;

    private long menuItemId;

    private long venueId;
}
