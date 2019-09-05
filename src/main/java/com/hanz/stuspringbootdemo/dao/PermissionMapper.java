package com.hanz.stuspringbootdemo.dao;

import com.hanz.stuspringbootdemo.domain.Permission;
import com.hanz.stuspringbootdemo.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionMapper {
    int insertPermission(Permission permission);
    int deleteById(int id);
    int updateById(Permission permission);
    Permission selectPermissionById(int id);
    List<Permission> getPermissionByRoleId(int role_id);
    List<Permission> getPermissionByRoleName(String role_name);
}
