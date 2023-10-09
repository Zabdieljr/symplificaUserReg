package com.symplifica.demouser.dao;

import com.symplifica.demouser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    public List<User> findAllByOrderByLastNameAsc();
}
