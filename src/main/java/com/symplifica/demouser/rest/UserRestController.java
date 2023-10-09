package com.symplifica.demouser.rest;

import com.symplifica.demouser.dao.UserDAO;
import com.symplifica.demouser.entity.User;
import com.symplifica.demouser.service.UserService;
import org.hibernate.boot.model.source.internal.hbm.AttributesHelper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserRestController {
    //  private UserDAO userDAO; //Now making use of the Service
    private UserService userService;
    //  inject user into user dao for testing! constructor Injection
    //    public UserRestController(UserDAO theUserDAO){
    //       userDAO = theUserDAO;
    //    }

    public UserRestController(UserService theUserService){
        userService = theUserService;
    }

    // Return a List of already Users Registered. "/users"
    @GetMapping ("/users")
    public List<User> findAll(){
    //        return userDAO.findAll();
        return userService.findAll();
    }

    // add mapping for GET /user/{userID}

    @GetMapping("/users/{userID}")
    public User getUser (@PathVariable int userID){

        User theUser = userService.findById(userID);
        if (theUser == null){
            throw  new RuntimeException(" User Id not Found - " + userID);
        }
        return theUser;
    }
    // add mapping for POST /users - register user
    @PostMapping("/users")
            public User addUser (@RequestBody User theUser) {
        // look out for JSON ID.. set id 0
        // force save fo new item ... instead of update
        theUser.setId(0);
        User dbUser = userService.save(theUser);
        return dbUser;
    }
}
