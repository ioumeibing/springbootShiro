package com.how2java.springboot.service;

import com.how2java.springboot.pojo.userDepartment;

import java.util.List;

public interface userDepartmentService {
    public int updateUserDepartment(userDepartment ud);

    public List<userDepartment> getUdByUid(int uid);
}
