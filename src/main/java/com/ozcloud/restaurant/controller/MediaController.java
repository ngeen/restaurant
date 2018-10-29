package com.ozcloud.restaurant.controller;

import com.ozcloud.restaurant.dtos.MediaDTO;
import com.ozcloud.restaurant.dtos.UserDTO;
import com.ozcloud.restaurant.enums.MediaType;
import com.ozcloud.restaurant.enums.Status;
import com.ozcloud.restaurant.model.Media;
import com.ozcloud.restaurant.model.User;
import com.ozcloud.restaurant.repository.ItemRepository;
import com.ozcloud.restaurant.repository.MediaRepository;
import com.ozcloud.restaurant.repository.UserRepository;
import com.ozcloud.restaurant.repository.VenueRepository;
import com.ozcloud.restaurant.utils.BaseResponse;
import org.apache.commons.io.FilenameUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
public class MediaController implements Serializable {

    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private ModelMapper modelMapper;

    private String UPLOADED_FOLDER = "/root/images/";

    @PostMapping("/saveMedia")
    @ResponseBody
    public ResponseEntity<BaseResponse> saveMedia(@RequestParam("file") MultipartFile file, @RequestParam("userId") String userId,
                                                  @RequestParam("venueId") String venueId, @RequestParam("itemId") String itemId) throws Exception {
        try {
            UUID uuid = UUID.randomUUID();

            if(userId.isEmpty() && venueId.isEmpty() && itemId.isEmpty())
                throw new Exception("Missing Ids");

            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String extension = FilenameUtils.getExtension(file.getOriginalFilename());
                Path path = Paths.get(UPLOADED_FOLDER + uuid.toString() + "." + extension);
                Files.write(path, bytes);
            }

            Media media = new Media();

            if(!userId.isEmpty()){
                media.setUser(userRepository.findById(Long.valueOf(userId)).orElse(null));
                media.setMediaType(MediaType.USER);
            }


            if(!venueId.isEmpty()){
                media.setVenue(venueRepository.findById(Long.valueOf(venueId)).orElse(null));
                media.setMediaType(MediaType.VENUE);
            }


            if(!itemId.isEmpty()){
                media.setMenuItem(itemRepository.findById(Long.valueOf(itemId)).orElse(null));
                media.setMediaType(MediaType.ITEM);
            }

            media.setFileName(file.getOriginalFilename());
            media.setMediaGuid(uuid.toString());
            media.setStatus(Status.ACTIVE);
            String link = String.format("https://images.oenginoz.com/unsafe/%s/%s", "%s", media.getFileName());
            media.setMediaLink(link);
            mediaRepository.save(media);

            return ResponseEntity.ok(BaseResponse.getOkResponse(link));
        } catch (Exception e) {
            throw  new Exception(e);
        }

    }
}
