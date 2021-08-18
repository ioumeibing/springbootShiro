package com.how2java.springboot.service.impl;

import com.how2java.springboot.mapper.userRoleMapper;
import com.how2java.springboot.pojo.userRole;
import com.how2java.springboot.service.userRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userRoleServiceImpl implements userRoleService {
    @Autowired
    userRoleMapper userRoleMapper;

    @Override
    public int updateUserRole(userRole ur) {
        return userRoleMapper.updateUserRole(ur);
    }

    @Override
    public userRole getUrByUidRid(int uid, int rid) {
        return userRoleMapper.getUrByUidRid(uid,rid);
    }

    @Override
    public int adduserRole(userRole ur) {
        return userRoleMapper.adduserRole(ur);
    }

    @Override
    public List<userRole> getUrByUid(int uid) {
        return userRoleMapper.getUrByUid(uid);
    }

    @Override
    public void deleteUserRole(int id) {
        userRoleMapper.deleteUserRole(id);
    }
}
