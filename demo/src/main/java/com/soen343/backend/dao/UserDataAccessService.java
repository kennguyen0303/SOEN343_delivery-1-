package com.soen343.backend.dao;

import com.soen343.backend.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * A Repository of the Users that are Registered to the Simulation and related business logic
 */
@Repository("userDao")
public class UserDataAccessService implements UserDAO {

    private List<User> DB = new ArrayList<>();

    /**
     *
     * @param id
     * @param user
     * @return
     */
    @Override
    public int insertUser(UUID id, User user) {
        DB.add(new User(id, user.getRole()));
        return 1;
    }

    /**
     *
     * @return
     */
    public List<User> selectAllUsers() {

        return DB;
    }

    @Override
    public Optional<User> selectUserById(UUID id) {
        return DB.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public int deleteUserById(UUID id) {
        Optional<User> user = selectUserById(id);

        if(user.isEmpty())
        {
            return 0; // indicates that no user was found and deleted
        }

        DB.remove(user.get());
        return 1;
    }

    /**
     *
     * @param id
     * @param updateUser
     * @return
     */
    @Override
    public int updateUserById(UUID id, User updateUser) {
        return selectUserById(id)
                .map(user -> {
                    int indexOfUserToUpdate = DB.lastIndexOf(user);
                    if(indexOfUserToUpdate >= 0) // we have found a person
                    {
                        DB.set(indexOfUserToUpdate,  new User(id, updateUser.getRole())); // set contents of the person to new person that was just received
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public int loginUser(UUID id) {

        Optional<User> userToLogIn = selectUserById(id);

        if(userToLogIn.isEmpty())
        {
            return 0; // indicates that no user was found and no action was taken
        }
        Optional<User> currentLoggedInUser = findCurrentLoggedInUser();

        if(!currentLoggedInUser.isEmpty())
        {
            // log out the current user
            currentLoggedInUser.get().setLoggedUser(false);
        }

        // log in new user
        userToLogIn.get().setLoggedUser(true);

        return 1;
    }

    /**
     *
     * @return
     */
    private Optional<User> findCurrentLoggedInUser() {
        return DB.stream()
                .filter(user -> user.getIsLoggedUser() == true)
                .findFirst();
    }

    /**
     *
     * @param id
     * @param location
     * @return
     */
    @Override
    public int setUserLocation(UUID id, String location) {

        Optional<User> user = selectUserById(id);

        if(user.isEmpty())
        {
            return 0; // indicates that no user was found and no action was taken
        }

        user.get().setLocation(location);
        return 1;
    }
}
