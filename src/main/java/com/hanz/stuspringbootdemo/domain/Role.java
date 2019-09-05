package com.hanz.stuspringbootdemo.domain;

import lombok.Data;

import java.util.List;

@Data
public class Role {
    private Integer id;
    private String role_name;
    private Integer user_id;
}
