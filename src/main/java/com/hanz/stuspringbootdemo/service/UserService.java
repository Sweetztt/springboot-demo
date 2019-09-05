package com.hanz.stuspringbootdemo.service;

import com.hanz.stuspringbootdemo.domain.User;

import java.util.Map;

public interface UserService {

    //添加用户信息
    int insertUser(User user);

    //根据id删除用户信息
    int deleteById(int id);

    //根据id更新用户信息
    int updateById(User user);

    //根据用户名查询用户信息
    User selectUserByName(String name);

    //根据用户id查询用户信息
    User selectUserById(int id);

    //根据用户名查询用户所有权限
    Map<String,Object> getAllQXByUserName(String name);
}
