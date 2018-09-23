package com.ozcloud.architect.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;

@Getter
@Setter
public class UserDTO {

    private long id;

    private String userName;

    private String password;

    private String[] roles;
}
