package com.ozcloud.restaurant.model;

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
    private long userId;

    private String userName;

    private String password;

    private String userGuid;

    private String[] roles;

    public User(String _userName, String _password, String[] _roles, String _userGuid){
        this.setUserName(_userName);
        this.setPassword(_password);
        this.setRoles(_roles);
        this.setUserGuid(_userGuid);

    }

}
