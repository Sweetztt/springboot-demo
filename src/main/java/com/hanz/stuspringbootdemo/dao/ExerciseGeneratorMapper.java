package com.hanz.stuspringbootdemo.dao;

import com.hanz.stuspringbootdemo.domain.ExerciseGenerator;

public interface ExerciseGeneratorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExerciseGenerator record);

    int insertSelective(ExerciseGenerator record);

    ExerciseGenerator selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExerciseGenerator record);

    int updateByPrimaryKey(ExerciseGenerator record);
}