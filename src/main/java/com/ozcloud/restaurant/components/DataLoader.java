package com.ozcloud.restaurant.components;

import com.ozcloud.restaurant.model.User;
import com.ozcloud.restaurant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void run(ApplicationArguments args) {
        User user = userRepository.findByUserName("admin");
        if (user == null) {

            UUID uuid = UUID.randomUUID();
            user = new User("admin", passwordEncoder.encode("admin"),new String[]{"ADMIN"}, uuid.toString());
            userRepository.save(user);
        }
    }
}