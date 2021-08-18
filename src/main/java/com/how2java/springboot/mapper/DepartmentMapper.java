package com.how2java.springboot.mapper;

import com.how2java.springboot.pojo.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    public List<Department> getByAllDept();

    List<Department> getDeptByUid(int uid);

}

