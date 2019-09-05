package com.hanz.stuspringbootdemo.controller;

import com.hanz.stuspringbootdemo.domain.User;
import com.hanz.stuspringbootdemo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//代表每一个接口少写了一个注解@ResponseBody
public class ShiroController {
    @Autowired
    private UserService userService;
    @RequestMapping("/loginShiro/{username}/{password}")
    public Object loginShiro(@PathVariable String username,@PathVariable String password){
        if(username!=null){
            User user=userService.selectUserByName(username);
            if(user!=null&&user.getPassword().equals(password)){
                //添加用户验证信息
                Subject subject=SecurityUtils.getSubject();
                UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password);
                //进行验证，这里可以捕获异常，然后返回对应信息
                subject.login(usernamePasswordToken);
                System.out.println("loginShiro:"+usernamePasswordToken);
                return "loginShiro!";
            }
        }
        //调用过logout后通过setLoginUtil重新进入该方法
        return "it's logout!";
    }

    @RequestMapping("/logout")
    public Object logout(){
        return "logout!";
    }

    @RequestMapping(value = "/index")
    public Object index(){
        return "index!";
    }

    @RequestMapping(value = "/errorpage")
    public Object error(){
        return "error!";
    }

    @RequestMapping("/testShiro")
    public Object testShiro(){
        //业务省略...
        return "testShiro:success!";
    }

    //认证角色，logical = Logical.OR/Logical.AND,
    @RequestMapping("/testAuthorityRole")
    @RequiresRoles(value = {"admin","user"},logical = Logical.OR)
    public Object testAuthorityRole(){
        return "testAuthorityRole:success!";
    }

    //认证操作权限
    @RequestMapping("/testAuthorityPermission")
    @RequiresPermissions(value = {"create","update"},logical = Logical.OR)
    public Object testAuthorityPermission(){
        return "testAuthorityPermission:success!";
    }

    //同时认证角色和操作权限
    @RequestMapping("/testAuthorityPerAndRole")
    @RequiresRoles(value = {"admin","user"},logical = Logical.OR)
    @RequiresPermissions(value = {"create","select"},logical = Logical.AND)
    public Object testAuthorityPerAndRole(){
        return "testAuthorityPerAndRole:success!";
    }
}
