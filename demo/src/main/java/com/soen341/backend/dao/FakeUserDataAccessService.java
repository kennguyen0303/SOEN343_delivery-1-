package com.soen341.backend.dao;

import com.soen341.backend.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeUserDataAccessService implements UserDAO {

    private List<User> DB = new ArrayList<>();

    @Override
    public int insertUser(UUID id, User user)
    {
        DB.add(new User(id, user.getName()));
        return 1;
    }

    public List<User> selectAllUsers()
    {
        return DB;
    }

    @Override
    public Optional<User> selectUserById(UUID id) {
        return DB.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

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

    @Override
    public int updateUserById(UUID id, User updateUser) {
        return selectUserById(id)
                .map(user -> {
                    int indexOfUserToUpdate = DB.lastIndexOf(user);
                    if(indexOfUserToUpdate >= 0) // we have found a person
                    {
                        DB.set(indexOfUserToUpdate,  new User(id, updateUser.getName())); // set contents of the person to new person that was just received
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
