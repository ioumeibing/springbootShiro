package com.how2java.springboot.service;

import com.how2java.springboot.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface RoleService {
    public Set<Role> getAllRole();
    public int add(Role role);
    public void delete(int id);
    public int update(Role role);
    public Set<Role> getRoleNameByUid(int id);
    public int addRolePermiss(int pid,  int rid);

}
