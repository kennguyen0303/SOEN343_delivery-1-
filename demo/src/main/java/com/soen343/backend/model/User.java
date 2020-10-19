package com.soen343.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;
import javax.validation.constraints.NotBlank;

public class User {

    private final UUID id;
    private boolean isLoggedUser;

    @NotBlank
    private final String role;

    private String location;

    public User(@JsonProperty("id") UUID id, @JsonProperty("role") String role) {
        this.id = id;
        this.role = role;
        this.isLoggedUser = false;
        this.location = "";
    }

    public String getRole() {
        return role;
    }

    public boolean getIsLoggedUser() {
        return isLoggedUser;
    }

    public UUID getId() {
        return id;
    }

    public void setLoggedUser(boolean isLoggedIn)
    {
        isLoggedUser = isLoggedIn;
    }

    public void setLocation(String location){
        this.location = location;
    }
}
