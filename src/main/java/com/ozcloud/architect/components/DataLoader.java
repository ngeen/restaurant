package com.ozcloud.architect.components;

import com.ozcloud.architect.model.User;
import com.ozcloud.architect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

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
            user = new User(1,"admin", passwordEncoder.encode("admin"),new String[]{"ADMIN"});
            userRepository.save(user);
        }
    }
}