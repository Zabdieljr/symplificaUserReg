package com.symplifica.demouser.dao;

import com.symplifica.demouser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource (path = "registered_users")
public interface UserRepository extends JpaRepository<User,Integer> {
}
