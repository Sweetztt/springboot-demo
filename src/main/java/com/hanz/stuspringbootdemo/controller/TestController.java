package com.hanz.stuspringbootdemo.controller;

import com.hanz.stuspringbootdemo.config.jedis.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TestController {
    @RequestMapping(value = "/test")
    @ResponseBody
    public Object test(){
        return "hello world!";

    //访问地址：http://localhost:8080/test
    }


    //rest接口
    @RequestMapping("/restTest/{name}")
    public Object restTest(@PathVariable String name){
        return "restTest"+name;

    //访问地址：http://localhost:8080/restTest/zx
    }

    //jedis
    @Autowired
    private JedisUtil jedis;
    @RequestMapping("/restJedis/{val}")
    public Object restJedis(@PathVariable String val){
        jedis.set("key-"+val,val);
        return "restJedis_OK";

    //访问地址：http://localhost:8080/restJedis/testValue
    }

    //jdbc
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @RequestMapping("/getJDBC/{id}")
    public Object getJDBC(@PathVariable Integer id){
        String sql="select * from user where id= "+id;
        Map<String,Object> data=jdbcTemplate.queryForMap(sql);
        return data;

    //访问地址：http://localhost:8080/getJDBC/3
    }


}
