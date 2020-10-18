package com.soen343.backend.api;

import com.soen343.backend.model.User;
import com.soen343.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "api/user/addUser")
    public void  addUser(@Valid @NonNull @RequestBody User user) {
        userService.addUser(user);
    }

    @GetMapping(value = "api/user/allUserRetrieval")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "api/user/userRetrieval/{id}")
    public User getUserById(@PathVariable("id") UUID id) {
        return userService.getUserById(id)
                .orElse(null);
    }

    @DeleteMapping(value = "api/user/userRemoval/{id}")
    public void deleteUserById(@PathVariable("id") UUID id) {
        userService.deleteUser(id);
    }

    @PutMapping( value = "api/user/userUpdate/{id}")
    public void updateUserById(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody User userToUpdate ) {
        userService.updateUser(id, userToUpdate);
    }

    @PutMapping(value = "api/user/logIn/{id}")
    public void loginUser(@PathVariable("id") UUID id) {
        userService.loginUser(id);
    }
}
