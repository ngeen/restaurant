package com.ozcloud.architect.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTest {
    @GetMapping("/test")
    public String test(){
        return "bu test";
    }
}
