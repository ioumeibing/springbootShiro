package com.how2java.springboot.service.impl;

import com.how2java.springboot.mapper.userDepartmentMapper;
import com.how2java.springboot.pojo.userDepartment;
import com.how2java.springboot.service.userDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userDepartmentServiceImpl implements userDepartmentService {
    @Autowired
    userDepartmentMapper userDepartmentMapper;
    @Override
    public int updateUserDepartment(userDepartment ud) {
        return userDepartmentMapper.updateUserDepartment(ud);
    }


    @Override
    public List<userDepartment> getUdByUid(int uid) {
        return userDepartmentMapper.getUdByUid(uid);
    }

}
