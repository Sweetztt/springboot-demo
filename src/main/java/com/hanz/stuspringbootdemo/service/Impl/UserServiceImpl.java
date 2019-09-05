package com.hanz.stuspringbootdemo.service.Impl;

import com.hanz.stuspringbootdemo.dao.UserMapper;
import com.hanz.stuspringbootdemo.domain.User;
import com.hanz.stuspringbootdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Primary
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    //添加用户信息
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    //根据id删除用户信息
    public int deleteById(int id) {
        return userMapper.deleteById(id);
    }

    //根据id更新用户信息
    public int updateById(User user) {
        return userMapper.updateById(user);
    }

    //根据用户id查询用户信息
    public User selectUserById(int id) {
        return userMapper.selectUserById(id);
    }

    //根据用户名查询用户信息
    public User selectUserByName(String name) {
        return userMapper.selectUserByName(name);
    }

    //根据用户名查询用户所有权限
    public Map<String,Object> getAllQXByUserName(String name){
        return userMapper.getAllQXByUserName(name);
    }
}
