package com.symplifica.demouser.service;

import com.symplifica.demouser.dao.UserRepository;
import com.symplifica.demouser.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    @Autowired
    public  UserServiceImpl (UserRepository theUserRepository)
    {
        userRepository = theUserRepository;
    }
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int theid) {

        Optional<User> result = userRepository.findById(theid);
        User theUser = null;
        if(result.isPresent()){
            theUser =result.get();

        }
        else {
            throw new RuntimeException("Did not find user id - " + theid);
        }
        return theUser;
    }

    @Override
    public User save(User theUser) {
        return userRepository.save(theUser);
    }

    @Override
    public void deleteById(int theId) {
    userRepository.deleteById(theId);
    }
}
