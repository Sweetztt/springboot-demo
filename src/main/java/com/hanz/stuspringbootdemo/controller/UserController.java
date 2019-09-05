package com.hanz.stuspringbootdemo.controller;

import com.hanz.stuspringbootdemo.domain.User;
import com.hanz.stuspringbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //添加用户信息
    @RequestMapping("/insertUser/{name}/{password}/{sal}")
    public Object insertUser(@PathVariable String name,@PathVariable String password,@PathVariable double sal){
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        user.setSal(sal);
        int result=userService.insertUser(user);
        Map<String,Object> map=new HashMap<>();
        if(result>0){
            map.put("code",0);
        }else{
            map.put("code",-1);
        }
        return map;
    }

    //删除用户信息
    @RequestMapping("/deleteById/{id}")
    public Object deleteById(@PathVariable int id){
        int result=userService.deleteById(id);
        Map<String,Object> map=new HashMap<>();
        if(result>0){
            map.put("code",0);
        }else{
            map.put("code",-1);
        }
        return map;
    }

    //修改用户信息
    @RequestMapping("/updateById/{id}/{name}/{password}/{sal}")
    public Object updateById(@PathVariable int id,@PathVariable String name,@PathVariable String password,@PathVariable double sal){
        User user=new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        user.setSal(sal);
        int result=userService.updateById(user);
        Map<String,Object> map=new HashMap<>();
        if(result>0){
            map.put("code",0);
        }else{
            map.put("code",-1);
        }
        return map;
    }

    //查询用户信息
    @RequestMapping("/selectById/{id}")
    public Object selectById(@PathVariable int id){
        User result=userService.selectUserById(id);
        return result;
    }
}
