package com.symplifica.demouser.service;

import com.symplifica.demouser.dao.UserDAO;
import com.symplifica.demouser.dao.UserDAOJpaImpl;
import com.symplifica.demouser.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    private UserDAO userDAO;
    @Autowired
    public  UserServiceImpl (UserDAO theUserDAO)
    {
        userDAO = theUserDAO;
    }
    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }
}
