package com.springboot.demo.service.impl;

import com.springboot.demo.mapper.UserMapper;
import com.springboot.demo.model.User;
import com.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public void addUser(User user){
       userMapper.addUser(user);
    }

    @Override
    public void editUser(User user){
        userMapper.editUser(user);
    }
    @Override
    public void delUser(String uid){
        userMapper.delUser(uid);
    }
}
