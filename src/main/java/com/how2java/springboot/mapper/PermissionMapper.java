package com.how2java.springboot.mapper;

import com.how2java.springboot.pojo.Permission;
import com.how2java.springboot.pojo.Person;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface PermissionMapper {

    public int add(Permission permission);
    public void delete(int id);
    public int update(Permission permission);

    public Permission getById(int id);

    public List<Permission> getAllPermission();
}
