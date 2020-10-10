package com.xxx.demo.service;

import com.xxx.demo.mapper.UserMapper;
import com.xxx.demo.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    public User queryUserByName(String name){
        return userMapper.findUserByName(name);
    }
}
