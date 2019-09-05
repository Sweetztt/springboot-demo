package com.hanz.stuspringbootdemo.domain;

import lombok.Data;

import java.util.Date;

@Data
public class ExerciseGenerator {
    private Integer id;

    private String name;

    private Integer age;

    private Date dateTime;

}