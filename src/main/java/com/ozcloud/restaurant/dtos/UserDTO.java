package com.ozcloud.restaurant.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private long id;

    private String userName;

    private String password;

    private String[] roles;
}
