package com.how2java.springboot.web;

import com.how2java.springboot.helper.Response;
import com.how2java.springboot.helper.ResponseResult;
import com.how2java.springboot.pojo.Permission;
import com.how2java.springboot.pojo.Role;
import com.how2java.springboot.service.PermissionService;
import com.how2java.springboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class RoleController {
    @Autowired
    RoleService roleService;


    static int roleCount =0;
    @GetMapping("/roles")
    public ResponseResult<Set<Role>> roleList(){
        Set<Role> roles =roleService.getAllRole();
        roleCount = roles.size()+1;
        return Response.makeOkRsp(roles);

    }

    @PostMapping("/roles")
    public ResponseResult<Object> add(@RequestBody Role role){
        Set<Permission> perms =role.getPermissions();
        int rid = roleCount;
        perms.forEach(per -> {
            roleService.addRolePermiss(per.getId(),rid);
        });
        return Response.makeOkRsp(roleService.add(role));
    }


    @PutMapping("/roles/{id}")
    public ResponseResult<Object> update(@RequestBody Role role){
        return Response.makeOkRsp(roleService.update(role));
    }

    @DeleteMapping("/roles/{id}")
    public ResponseResult<Object> delete(@PathVariable("id")int rid){
        roleService.delete(rid);
        return Response.makeOkRsp();
    }
}
