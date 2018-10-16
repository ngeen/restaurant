package com.ozcloud.restaurant.controller;

import com.google.common.collect.Lists;
import com.ozcloud.restaurant.dtos.ProductDTO;
import com.ozcloud.restaurant.dtos.VenueDTO;
import com.ozcloud.restaurant.model.Venue;
import com.ozcloud.restaurant.repository.VenueRepository;
import com.ozcloud.restaurant.service.UserServiceImpl;
import com.ozcloud.restaurant.utils.BaseResponse;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class VenueController implements Serializable{
    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/getUserVenues")
    public ResponseEntity<BaseResponse> getUserVenues() throws Exception {
        try {
            List<Venue> venueList = Lists.newArrayList(venueRepository.findAllByUserOrderByVenueIdDesc(userServiceImpl.getAuthUser()));

            Type listType = new TypeToken<List<VenueDTO>>() {}.getType();
            List<VenueDTO> venueDTOList = modelMapper.map(venueList,listType);

            return ResponseEntity.ok(BaseResponse.getOkResponse(venueDTOList));
        } catch (Exception e) {
            throw  new Exception(e);
        }

    }

    @PostMapping("/newVenue")
    public ResponseEntity<BaseResponse> newVenue(@RequestBody VenueDTO venueDTO) throws Exception {
        try {

            Venue venue = modelMapper.map(venueDTO, Venue.class);
            venue.setUser(userServiceImpl.getAuthUser());

            UUID uuid = UUID.randomUUID();
            venue.setVenueGuid(uuid.toString());

            venue = venueRepository.save(venue);

            return ResponseEntity.ok(BaseResponse.getOkResponse(venue.getVenueGuid()));
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    @PostMapping("/updateVenue")
    public ResponseEntity<BaseResponse> updateVenue(@RequestBody VenueDTO venueDTO) throws Exception {
        try {
            Venue venue = venueRepository.findByVenueGuid(venueDTO.getVenueGuid());

            if(venue == null)
                throw new Exception("VenueNotFind");

            if(venue.getUser().getUserId() != userServiceImpl.getAuthUser().getUserId())
                throw new Exception("WrongUserOwner");

            venue.setVenueName(venueDTO.getVenueName());
            venue.setFoursquareId(venueDTO.getFoursquareId());
            venue.setFoursquareToken(venueDTO.getFoursquareToken());
            venue.setVenueImage(venueDTO.getVenueImage());
            venue.setInfoScreenStatus(venueDTO.getInfoScreenStatus());
            //venue = modelMapper.map(venueDTO, Venue.class);

            venue = venueRepository.save(venue);

            return ResponseEntity.ok(BaseResponse.getOkResponse(venue.getVenueGuid()));
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    @PostMapping("/deleteVenue")
    public ResponseEntity<BaseResponse> deleteVenue(@RequestBody VenueDTO venueDTO) throws Exception {
        try {
            Venue venue = venueRepository.findByVenueGuid(venueDTO.getVenueGuid());

            if(venue == null)
                throw new Exception("VenueNotFind");

            if(venue.getUser().getUserId() != userServiceImpl.getAuthUser().getUserId())
                throw new Exception("WrongUserOwner");

            venueRepository.delete(venue);

            return ResponseEntity.ok(BaseResponse.getOkResponse("success"));
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    @GetMapping("/venueDetail/{guid}")
    public ResponseEntity<BaseResponse> getVenueDetail(@PathVariable("guid") String venueGuid) throws Exception {
        try {
            Venue venue = venueRepository.findByVenueGuid(venueGuid);

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
