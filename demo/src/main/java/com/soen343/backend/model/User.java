package com.soen343.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;
import javax.validation.constraints.NotBlank;

public class User {

    private final UUID id;
    private boolean isLoggedUser = false;

    @NotBlank
    private final String role;

    public User(@JsonProperty("id") UUID id, @JsonProperty("role") String role) {
        this.id = id;
        this.role = role;
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
}
