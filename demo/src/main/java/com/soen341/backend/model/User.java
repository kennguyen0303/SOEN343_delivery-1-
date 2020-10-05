package com.soen341.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;
import javax.validation.constraints.NotBlank;

public class User {

    private final UUID id;

    @NotBlank
    private final String name;

    public String getName() {
        return name;
    }

    public User(@JsonProperty("id") UUID id, @JsonProperty("name") String name)
    {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }
}
