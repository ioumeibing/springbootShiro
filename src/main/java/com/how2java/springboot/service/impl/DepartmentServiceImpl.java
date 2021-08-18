package com.how2java.springboot.service.impl;

import com.how2java.springboot.mapper.DepartmentMapper;
import com.how2java.springboot.pojo.Department;
import com.how2java.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    @Override
    public List<Department> getByAllDept() {
        return departmentMapper.getByAllDept();
    }

    @Override
    public List<Department> getDeptByUid(int uid) {
        return departmentMapper.getDeptByUid(uid);
    }
}
