package com.vedruna.sampleproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.sampleproject.persistance.models.User;
import com.vedruna.sampleproject.persistance.repository.UserRepositoryI;

@Service
public class UserServiceImpl implements UserServiceI {

    @Autowired
    UserRepositoryI userRepo;

    @Override
    public List<User> showAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User showUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public User showUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public User showUserByUsernameAndEmail(String username, String email) {
        return userRepo.findByUsernameAndEmail(username, email);
    }

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        user.setUserId(id);
        userRepo.save(user);
    }
    

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);    
    }
    
}
