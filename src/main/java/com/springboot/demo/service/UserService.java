package com.springboot.demo.service;

import com.springboot.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUsers();
    void addUser(User user);
    void editUser(User user);
    void delUser(String uid);
}
