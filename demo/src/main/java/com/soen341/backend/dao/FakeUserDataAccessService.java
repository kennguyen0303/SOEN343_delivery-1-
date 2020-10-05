package com.soen341.backend.dao;

import com.soen341.backend.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
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
}
