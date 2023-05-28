package com.superchef.Super.Chef.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Component
public class User {

    //Define the database Fields
    @Id
    @Column(name = "user_email",nullable = false, length=100)
    private String userEmail;

    @Column(name = "user_name",length = 100)
    private String userName;

    @Column(name = "user_passwd",length = 100)
    private String passwd;

    public Set<User_Fav_Recipes> getUserMapping() {
        return userMapping;
    }

    public void setUserMapping(Set<User_Fav_Recipes> userMapping) {
        this.userMapping = userMapping;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<User_Fav_Recipes> userMapping = new HashSet<>();


    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
