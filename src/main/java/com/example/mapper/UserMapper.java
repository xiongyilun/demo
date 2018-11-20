package com.example.mapper;

import java.util.List;

import com.example.bean.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {

    List<User> findAll();

}
