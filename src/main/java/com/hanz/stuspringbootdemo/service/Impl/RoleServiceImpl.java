package com.hanz.stuspringbootdemo.service.Impl;

import com.hanz.stuspringbootdemo.dao.RoleMapper;
import com.hanz.stuspringbootdemo.domain.Role;
import com.hanz.stuspringbootdemo.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@Slf4j
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleDao;
    public int insertRole(Role role) {
        return roleDao.insertRole(role);
    }

    public int deleteById(int id) {
        return roleDao.deleteById(id);
    }

    public int updateById(Role role) {
        return roleDao.updateById(role);
    }

    public Role selectRoleById(int id) {
        return roleDao.selectRoleById(id);
    }

    public List<Role> getRoleByUserName(String name){
        return roleDao.getRoleByUserName(name);
    }

    public List<Role> getRolesByUserName(String name){
        return roleDao.getRoleByUserName(name);
    }
}
