package com.soen341.backend.api;

import com.soen341.backend.model.User;
import com.soen341.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping
    public void  addUser(User user)
    {
        userService.addUser(user);
    }
}
