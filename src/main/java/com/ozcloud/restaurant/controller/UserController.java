package com.ozcloud.restaurant.controller;

import com.ozcloud.restaurant.dtos.UserDTO;
import com.ozcloud.restaurant.model.User;
import com.ozcloud.restaurant.repository.UserRepository;
import com.ozcloud.restaurant.utils.BaseResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.UUID;

@RestController
public class UserController implements Serializable {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/registerUser")
    public ResponseEntity<BaseResponse> registerUser(@RequestBody UserDTO userDTO) throws Exception {
        try {

            User user = userRepository.findByUserName(userDTO.getUserName());
            if(user != null)
                throw new Exception("Exists_User");

            user = modelMapper.map(userDTO, User.class);

            String pass = passwordEncoder.encode(user.getPassword());
            user.setPassword(pass);
            UUID uuid = UUID.randomUUID();

            user.setUserGuid(uuid.toString());

            user.setRoles(new String[]{"ADMIN"});

            User returnUser = userRepository.save(user);

            return ResponseEntity.ok(BaseResponse.getOkResponse(Long.valueOf(returnUser.getUserId())));
        } catch (Exception e) {
            throw  new Exception(e);
        }

    }
}
