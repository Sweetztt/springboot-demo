package com.hanz.stuspringbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hanz.stuspringbootdemo")
public class StuSpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(StuSpringbootDemoApplication.class, args);
    }

}
