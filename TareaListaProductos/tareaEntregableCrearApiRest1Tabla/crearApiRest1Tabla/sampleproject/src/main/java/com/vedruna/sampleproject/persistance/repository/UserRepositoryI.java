package com.vedruna.sampleproject.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vedruna.sampleproject.persistance.models.User;

@Repository
public interface UserRepositoryI extends JpaRepository<User, Long>{
    //https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
    User findByUsername(String username);
    User findByEmail(String email);
    User findByUsernameAndEmail(String username, String email);
}
