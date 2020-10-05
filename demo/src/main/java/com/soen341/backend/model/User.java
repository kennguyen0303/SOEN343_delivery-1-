package com.soen341.backend.model;

import java.util.UUID;

public class User {

    private final UUID id;
    private final String name;

    public String getName() {
        return name;
    }

    public User(UUID id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }
}
