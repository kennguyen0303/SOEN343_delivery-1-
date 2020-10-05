package com.soen341.backend.dao;

import com.soen341.backend.model.User;

import java.util.UUID;

public interface UserDAO {

    int insertUser(UUID id, User user);

    default int insertUser(User user)
    {
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    };
}
