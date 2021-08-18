package com.how2java.springboot.service.impl;

import com.how2java.springboot.mapper.PermissionMapper;
import com.how2java.springboot.mapper.RoleMapper;
import com.how2java.springboot.pojo.Role;
import com.how2java.springboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    PermissionMapper permissionMapper;
    @Override
    public Set<Role> getAllRole() {
        return roleMapper.getAllRole();
    }

    @Override
    public int add(Role role) {
        return roleMapper.add(role);
    }

    @Override
    public void delete(int id) {
        roleMapper.delete(id);
    }

    @Override
    public int update(Role role) {
        return roleMapper.update(role);
    }

    @Override
    public Set<Role> getRoleNameByUid(int id) {
        return roleMapper.getRoleNameByUid(id);
    }

    @Override
    public int addRolePermiss(int pid, int rid) {
        return roleMapper.addRolePermiss(pid,rid);
    }
}
