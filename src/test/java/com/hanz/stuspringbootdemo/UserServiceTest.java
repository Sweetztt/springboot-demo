package com.hanz.stuspringbootdemo;

import com.hanz.stuspringbootdemo.domain.Permission;
import com.hanz.stuspringbootdemo.domain.Role;
import com.hanz.stuspringbootdemo.domain.User;
import com.hanz.stuspringbootdemo.service.PermissionService;
import com.hanz.stuspringbootdemo.service.RoleService;
import com.hanz.stuspringbootdemo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    //添加Role的信息
    //@Test
    public void insertRole(){
        Role role=new Role();
        role.setRole_name("空姐");
        role.setUser_id(4);
        int count=roleService.insertRole(role);
        System.out.println(count);
    }

    //根据id删除Role中的信息
    //@Test
    public void deleteById(){
        int count=roleService.deleteById(2);
        System.out.println(count);
    }

    //根据id修改Role中的信息
    //@Test
    public void updateById(){
        Role role=new Role();
        role.setId(2);
        role.setRole_name("空姐");
        role.setUser_id(5);
        int count=roleService.updateById(role);
        System.out.println(count);
    }

    //根据id查询Role中的信息
    //@Test
    public void selectRoleById(){
        Role role=roleService.selectRoleById(2);
        System.out.println(role);
    }

    //根据user的name查询Role的信息
    //@Test
    public void getRoleByUserName(){
        List<Role> roleList=roleService.getRoleByUserName("Nancy");
        System.out.println(roleList);
    }

    //添加Permission的信息
    //@Test
    public void insertPermission(){
        Permission permission=new Permission();
        permission.setPermission("用户");
        permission.setRole_id(1);
        int count=permissionService.insertPermission(permission);
        System.out.println(count);
    }

    //根据id删除Permission的信息
    //@Test
    public void deletePermissionById(){
        int count=permissionService.deleteById(2);
        System.out.println(count);
    }

    //根据id修改Permission的信息
    //@Test
    public void updatePermissionById(){
        Permission permission=new Permission();
        permission.setId(3);
        permission.setPermission("管理员");
        permission.setRole_id(1);
        int count=permissionService.updateById(permission);
        System.out.println(count);
    }

    //根据id查询Permission的信息
    //@Test
    public void selectPermissionById(){
        Permission permission=permissionService.selectPermissionById(1);
        System.out.println(permission);
    }

    //根据role_id查询Permission的多条记录
    //@Test
    public void getPermissionByRoleId(){
        List<Permission> permissions=permissionService.getPermissionByRoleId(1);
        System.out.println(permissions);
    }

    //根据role_name查询Permission的信息
    //@Test
    public void getPermissionByRoleName(){
        List<Permission> permissions=permissionService.getPermissionByRoleName("机长");
        System.out.println(permissions);
    }

    //根据name查询user的信息
    //@Test
    public void selectUserByName(){
        User user=userService.selectUserByName("Andy");
        System.out.println(user);
    }

    //根据用户名查询用户所有权限
    @Test
    public void getAllOXByUserName(){
        Map<String,Object> all=userService.getAllQXByUserName("Andy");
        for(String key:all.keySet()){
            String row="role_name:"+key;
            List<Permission> obj=(List)all.get(key);
            row+=",permission:";
            for(Permission p:obj){
                row+=p.getPermission()+",";
            }
            System.out.println(row);
        }
    }

}
