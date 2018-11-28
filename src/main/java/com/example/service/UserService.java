package com.example.service;

import com.example.bean.User;

import java.util.List;

public interface UserService {
    /**
     * 根据接口查询所用的用户
     */
     List<User> findAllUser();

     User getUserById(Integer id);
}
