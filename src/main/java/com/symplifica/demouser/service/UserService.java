package com.symplifica.demouser.service;

import com.symplifica.demouser.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findById(int theID);
    // method that allow us to save a user by giving and ID
    User save (User theUser);
    // method that allow us to delete a user by giving and ID
    void deleteById(int theId);


}
