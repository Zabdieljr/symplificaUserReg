package com.symplifica.demouser.rest;

import com.symplifica.demouser.dao.UserDAO;
import com.symplifica.demouser.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class UserRestController {
private UserDAO userDAO;
    // inject user into user dao for testing! constructor Injection
    public UserRestController(UserDAO theUserDAO){
       userDAO = theUserDAO;
    }

    // Return a List of already Users Registered. "/users"
    @GetMapping ("/users")
    public List<User> findAll(){
        return userDAO.findAll();
    }
}
