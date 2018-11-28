package com.example.service.impl;

import com.example.bean.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Cacheable(value = "findAllUser")
    public List<User> findAllUser() {
        List<User> list = userMapper.findAll();
        return list;
    }

    @Override
    @Cacheable(value = "getUserById")
    public User getUserById(Integer id) {
        User user = userMapper.getOne(id);
        return user;
    }
}
