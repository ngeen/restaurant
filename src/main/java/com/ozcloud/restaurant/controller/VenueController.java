package com.ozcloud.restaurant.controller;

import com.ozcloud.restaurant.dtos.UserDTO;
import com.ozcloud.restaurant.dtos.VenueDTO;
import com.ozcloud.restaurant.model.User;
import com.ozcloud.restaurant.model.Venue;
import com.ozcloud.restaurant.repository.UserRepository;
import com.ozcloud.restaurant.repository.VenueRepository;
import com.ozcloud.restaurant.service.UserServiceImpl;
import com.ozcloud.restaurant.utils.BaseResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.UUID;

@RestController
public class VenueController implements Serializable{
    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/newVenue")
    public ResponseEntity<BaseResponse> newVenue(@RequestBody VenueDTO venueDTO) throws Exception {
        try {

            Venue venue = modelMapper.map(venueDTO, Venue.class);

            venue = venueRepository.save(venue);

            return ResponseEntity.ok(BaseResponse.getOkResponse(Long.valueOf(venue.getVenueId())));
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    @PostMapping("/updateVenue")
    public ResponseEntity<BaseResponse> updateVenue(@RequestBody VenueDTO venueDTO) throws Exception {
        try {
            Venue venue = venueRepository.findById(venueDTO.getVenueId()).orElse(null);
            if(venue == null)
                throw new Exception("VenueNotFind");
            if(venue.getUser().getUserId() != userServiceImpl.getAuthUser().getUserId())
                throw new Exception("WrongUserOwner");
            venue = modelMapper.map(venueDTO, Venue.class);

            venue = venueRepository.save(venue);

            return ResponseEntity.ok(BaseResponse.getOkResponse(Long.valueOf(venue.getVenueId())));
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    @GetMapping("/venueDetail/{id}")
    public ResponseEntity<BaseResponse> getVenueDetail(@PathVariable("id") long venueId) throws Exception {
        try {
            Venue venue = venueRepository.findById(venueId).orElse(null);

            if(venue == null)
                throw new Exception("VenueNotFind");

            //if(venue.getUser().getUserId() != userServiceImpl.getAuthUser().getUserId())
                //throw new Exception("WrongUserOwner");

            VenueDTO venueDTO = modelMapper.map(venue, VenueDTO.class);

            return ResponseEntity.ok(BaseResponse.getOkResponse(venueDTO));
        } catch (Exception e) {
            throw new Exception(e);
        }

    }
}
