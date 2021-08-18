package com.how2java.springboot.service;

import com.how2java.springboot.pojo.Permission;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PermissionService {
    public List<Permission> getAllPermission();

    public int add(Permission permission);
    public void delete(int id);
    public int update(Permission permission);

    public Permission getById(int id);
}
