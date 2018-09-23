package com.ozcloud.restaurant.controller;

import com.ozcloud.restaurant.dtos.UserDTO;
import com.ozcloud.restaurant.model.User;
import com.ozcloud.restaurant.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/registerUser")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        try {

            User user = userRepository.findByUserName(userDTO.getUserName());
            if(user != null)
                throw new Exception("Exists_User");

            user = modelMapper.map(userDTO, User.class);

            user.setRoles(new String[]{"USER"});

            User returnUser = userRepository.save(user);

            return new ResponseEntity<String>("{\"result\": true, userId : " + returnUser.getId() + "}", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"result\": false, error: \"" +e.getMessage()+"\"}", HttpStatus.BAD_REQUEST);
        }

    }
}
