package com.hanz.stuspringbootdemo.service;

import com.hanz.stuspringbootdemo.domain.Permission;
import com.hanz.stuspringbootdemo.domain.Role;

import java.util.List;


public interface PermissionService {
    int insertPermission(Permission permission);
    int deleteById(int id);
    int updateById(Permission permission);
    Permission selectPermissionById(int id);
    List<Permission> getPermissionByRoleId(int role_id);
    List<Permission> getPermissionByRoleName(String role_name);
}
