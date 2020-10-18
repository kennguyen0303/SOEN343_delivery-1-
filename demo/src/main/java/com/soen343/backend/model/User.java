package com.soen343.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;
import javax.validation.constraints.NotBlank;

public class User {

    private final UUID id;

    @NotBlank
    private final String role;

    public String getRole() {
        return role;
    }

    public User(@JsonProperty("id") UUID id, @JsonProperty("role") String role)
    {
        this.id = id;
        this.role = role;
    }

    public UUID getId() {
        return id;
    }
}
