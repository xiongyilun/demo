package com.example.controller;

import com.example.bean.User;
import com.example.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("User")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("list")
    public List<User> list(){
        List<User> list = userService.findAllUser();
        return list;
    }
}
