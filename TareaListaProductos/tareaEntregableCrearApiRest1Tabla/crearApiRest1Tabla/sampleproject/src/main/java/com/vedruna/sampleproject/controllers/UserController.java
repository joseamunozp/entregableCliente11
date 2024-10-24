package com.vedruna.sampleproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.sampleproject.persistance.models.User;
import com.vedruna.sampleproject.services.UserServiceI;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserServiceI userMngmnt;
    
    @GetMapping
    public List<User> getAllUsers() {
        return userMngmnt.showAllUsers();
    }

    @GetMapping("/name/{username}")
    public User showUserByUsername(@PathVariable String username) {
        return userMngmnt.showUserByUsername(username);
    }

    @GetMapping("/email/{email}")
    public User showUserByEmail(@PathVariable String email) {
        return userMngmnt.showUserByEmail(email);
    }

    @PostMapping("/insert")
    public String postUser(@RequestBody User user) {
        userMngmnt.saveUser(user);

        return "User saved";
    }
    
    @PutMapping("edit/{id}")
    public String editUser(@PathVariable Long id, @RequestBody User user) {
        userMngmnt.updateUser(id, user);
        
        return "User modified";
    }
    
    @DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userMngmnt.deleteUser(id);
        
        return "User deleted";
    }

}
