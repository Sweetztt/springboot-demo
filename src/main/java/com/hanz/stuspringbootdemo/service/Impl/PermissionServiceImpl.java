package com.hanz.stuspringbootdemo.service.Impl;

import com.hanz.stuspringbootdemo.dao.PermissionMapper;
import com.hanz.stuspringbootdemo.domain.Permission;
import com.hanz.stuspringbootdemo.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@Slf4j
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionDao;
    public int insertPermission(Permission permission) {
        return permissionDao.insertPermission(permission);
    }

    public int deleteById(int id) {
        return permissionDao.deleteById(id);
    }

    public int updateById(Permission permission) {
        return permissionDao.updateById(permission);
    }

    public Permission selectPermissionById(int id) {
        return permissionDao.selectPermissionById(id);
    }

    public List<Permission> getPermissionByRoleId(int role_id) {
        return permissionDao.getPermissionByRoleId(role_id);
    }
    public List<Permission> getPermissionByRoleName(String role_name) {
        return permissionDao.getPermissionByRoleName(role_name);
    }
}
