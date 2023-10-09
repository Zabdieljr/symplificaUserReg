package com.symplifica.demouser.dao;

import com.symplifica.demouser.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserDAOJpaImpl implements UserDAO {

    // define field for Entitymanager

    private EntityManager entityManager;

    // setup constructors
    @Autowired
    public UserDAOJpaImpl(EntityManager  theEntityManager)
    {
        entityManager=theEntityManager;
    }

        @Override
    public List<User> findAll() {

        // create the query
            TypedQuery<User> theQuery = entityManager.createQuery("from User", User.class);

        // execute query and get results list
            List<User> users = theQuery.getResultList();
        // return the results


        return users;
    }
}
