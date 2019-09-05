package com.hanz.stuspringbootdemo.service;

import com.hanz.stuspringbootdemo.domain.Role;

import java.util.List;

public interface RoleService {
    int insertRole(Role role);
    int deleteById(int id);
    int updateById(Role role);
    Role selectRoleById(int id);
    List<Role> getRoleByUserName(String name);
    List<Role> getRolesByUserName(String name);
}
