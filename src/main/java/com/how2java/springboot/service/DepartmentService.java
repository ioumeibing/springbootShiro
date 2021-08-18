package com.how2java.springboot.service;

import com.how2java.springboot.pojo.Department;

import java.util.List;

public interface DepartmentService {
    public List<Department> getByAllDept();
    List<Department> getDeptByUid(int uid);
}
