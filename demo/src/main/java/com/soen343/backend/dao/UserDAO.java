package com.soen343.backend.dao;

import com.soen343.backend.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDAO {

    int insertUser(UUID id, User user);

    default int insertUser(User user) {
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    };

    List<User> selectAllUsers();

    Optional<User> selectUserById(UUID id);

    int deleteUserById(UUID id);

    int updateUserById(UUID id, User user);

    int loginUser(UUID id);
}
