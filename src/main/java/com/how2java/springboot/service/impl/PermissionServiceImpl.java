package com.how2java.springboot.service.impl;

import com.how2java.springboot.mapper.PermissionMapper;
import com.how2java.springboot.pojo.Permission;
import com.how2java.springboot.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionMapper permissionMapper;
    @Override
    public List<Permission> getAllPermission() {
        return permissionMapper.getAllPermission();
    }

    @Override
    public int add(Permission permission) {
        return permissionMapper.add(permission);
    }

    @Override
    public void delete(int id) {
        permissionMapper.delete(id);
    }

    @Override
    public int update(Permission permission) {
        return permissionMapper.update(permission);
    }

    @Override
    public Permission getById(int id) {
        return permissionMapper.getById(id);
    }
}
