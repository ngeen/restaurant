package com.ozcloud.restaurant.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTest {

    @GetMapping("/test")
    public String test(){
        return "{\n" +
                "    \"Id\": \"610\",\n" +
                "    \"Name\": \"15\",\n" +
                "    \"Description\": \"1.99\",\n" +
                "    \"ItemModList\": [42, 47, 139]\n" +
                "}";
    }
}
