package com.symplifica.demouser.rest;

import com.symplifica.demouser.entity.User;
import com.symplifica.demouser.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private UserService userService;
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

    @PostMapping("/users")
            public User addUser (@RequestBody User theUser) {
        // look out for JSON ID... set id 0
        // force save fo new item ... instead of update
        theUser.setId(0);
        User dbUser = userService.save(theUser);
        return dbUser;
    }
    // add mapping for PUT /users -update existing user
    @PutMapping("/users")
    public User updateUser(@RequestBody User theUser){
        User dbUser = userService.save(theUser);
        return dbUser;
    }
    // add mapping for DELETE /users/{userId}
    @DeleteMapping ("/users/{userId}")
    public String deleteUser (@PathVariable int userId){
        User tempUser = userService.findById(userId);

        if (tempUser == null){
            throw new RuntimeException("User Id not Found - " + userId);

        }
        userService.deleteById((userId));
        return "Deleted User id - " + userId;

    }
}
