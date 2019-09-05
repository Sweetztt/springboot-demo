package com.hanz.stuspringbootdemo.config.shiro;

import com.hanz.stuspringbootdemo.domain.Permission;
import com.hanz.stuspringbootdemo.domain.Role;
import com.hanz.stuspringbootdemo.domain.User;
import com.hanz.stuspringbootdemo.service.PermissionService;
import com.hanz.stuspringbootdemo.service.RoleService;
import com.hanz.stuspringbootdemo.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//Realm是shiro的第三大组件

//实现AuthorizingRealm接口用户用户认证
public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    //角色权限和对应权限添加
    //principals角色
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {//进行权限验证
        //获取登录用户名，存在session中
        String name= principals.getPrimaryPrincipal().toString();
        //查询用户
        User user = userService.selectUserByName(name);
        //查询用户权限
        List<Role> roles=roleService.getRoleByUserName(user.getName());
        //添加角色和权限，告诉shiro这个账户有哪些角色和哪些权限，@RequireRole和@RequirePermission这两个注解对用户限权
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (Role role:roles) {
            //添加角色
            simpleAuthorizationInfo.addRole(role.getRole_name());
            //查询用户权限
            List<Permission> permissions=permissionService.getPermissionByRoleId(role.getId());
            for (Permission permission:permissions) {
                //添加权限
                simpleAuthorizationInfo.addStringPermission(permission.getPermission());
            }
        }
        return simpleAuthorizationInfo;
    }

    //用户认证
    //token是用户登录，用户登录要携带token
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {//进行身份验证的(登录验证)
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (token.getPrincipal() == null) {
            return null;
        }
        //获取用户信息
        String name= token.getPrincipal().toString();
        //查询用户
        User user = userService.selectUserByName(name);
        if (user == null) {
            //这里返回后会报出对应异常
            return null;
        } else {
            //这里验证token和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, user.getPassword(),getName());
            return simpleAuthenticationInfo;
        }
    }
}