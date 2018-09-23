package com.ozcloud.architect.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String userName;

    private String password;

    private String[] roles;

}
