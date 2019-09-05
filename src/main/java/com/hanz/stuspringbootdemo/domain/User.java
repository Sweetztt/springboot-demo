package com.hanz.stuspringbootdemo.domain;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private Double sal;
}
