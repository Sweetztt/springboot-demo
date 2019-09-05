package com.hanz.stuspringbootdemo.dao;

import com.hanz.stuspringbootdemo.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    int insertRole(Role role);
    int deleteById(int id);
    int updateById(Role role);
    Role selectRoleById(int id);
    List<Role> getRoleByUserName(String name);
}
