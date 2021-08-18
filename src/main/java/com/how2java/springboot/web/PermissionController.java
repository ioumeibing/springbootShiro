package com.how2java.springboot.web;

import com.how2java.springboot.helper.Response;
import com.how2java.springboot.helper.ResponseResult;
import com.how2java.springboot.pojo.Permission;
import com.how2java.springboot.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PermissionController {
    @Autowired
    PermissionService permissionService;

    @GetMapping("/permissions")
    public ResponseResult<List<Permission>> list() throws Exception{
        return Response.makeOkRsp(permissionService.getAllPermission());
    }


    @PostMapping("/addPermissions")
    public ResponseResult<Object> add(@RequestBody Permission permission) throws Exception{
        return Response.makeOkRsp(permissionService.add(permission));
    }
    @DeleteMapping("/deletePermissions/{id}")
    public ResponseResult<Object> delete(@PathVariable("id") int pid) throws Exception{
        permissionService.delete(pid);
        return Response.makeOkRsp();
    }

    @PutMapping("/updatePermissions/{id}")
    public ResponseResult<Object> update(@RequestBody Permission permission) throws Exception{
        return Response.makeOkRsp(permissionService.update(permission));
    }


}
