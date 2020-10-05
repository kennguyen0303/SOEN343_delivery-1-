package com.soen341.backend.service;

import com.soen341.backend.dao.UserDAO;
import com.soen341.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
}
