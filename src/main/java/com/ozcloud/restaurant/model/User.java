package com.ozcloud.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usergen")
    private long userId;

    private String userName;

    private String password;

    private String userGuid;

    private String[] roles;

    @OneToMany
    @JsonIgnore
    @JoinColumn(name = "userMediaId")
    @JsonBackReference
    private List<Media> userMediaList = new LinkedList<Media>();

    public User(String _userName, String _password, String[] _roles, String _userGuid){
        this.setUserName(_userName);
        this.setPassword(_password);
        this.setRoles(_roles);
        this.setUserGuid(_userGuid);

    }

}
