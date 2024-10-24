package com.vedruna.sampleproject.services;

import java.util.List;

import com.vedruna.sampleproject.persistance.models.User;

public interface UserServiceI {
    List<User> showAllUsers();
    User showUserByUsername(String username);
    User showUserByEmail(String email);
    User showUserByUsernameAndEmail(String username, String email);
    void saveUser(User user);
    void updateUser(Long id,User user);
    void deleteUser(Long id);
}
