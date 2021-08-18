package com.how2java.springboot.mapper;

import com.how2java.springboot.pojo.Person;
import com.how2java.springboot.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface RoleMapper {

    public Set<Role> getAllRole();
    public int add(Role role);
    public void delete(int id);
    public int update(Role role);

    public Set<Role> getRoleNameByUid(int id);

    public int addRolePermiss(@Param("pid")int pid,@Param("rid") int rid);

}
