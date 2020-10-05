package com.soen341.backend.service;

import com.soen341.backend.dao.UserDAO;
import com.soen341.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserService(@Qualifier("fakeDao") UserDAO userDAO)
    {
        this.userDAO = userDAO;
    }

    public int addUser(User user)
    {
        return userDAO.insertUser(user);
    }

    public List<User> getAllUsers()
    {
        return userDAO.selectAllUsers();
    }

    public Optional<User> getUserById(UUID id)
    {
        return userDAO.selectUserById(id);
    }

    public int deleteUser(UUID id)
    {
        return userDAO.deleteUserById(id);
    }

    public int updateUser(UUID id, User newUser)
    {
        return userDAO.updateUserById(id, newUser);
    }
}
