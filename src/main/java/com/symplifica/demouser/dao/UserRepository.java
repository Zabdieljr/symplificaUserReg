package com.symplifica.demouser.dao;

import com.symplifica.demouser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
