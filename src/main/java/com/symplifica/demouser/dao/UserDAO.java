package com.symplifica.demouser.dao;

import com.symplifica.demouser.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> findAll();
    // method that allow us to find a user by giving and ID
    User findById(int theID);
    // method that allow us to save a user by giving and ID
    User save (User theUser);
    // method that allow us to delete a user by giving and ID
    void deleteById(int theId);
}
