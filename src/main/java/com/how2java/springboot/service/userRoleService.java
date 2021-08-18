package com.how2java.springboot.service;

import com.how2java.springboot.pojo.userRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface userRoleService {
    public int updateUserRole(userRole ur);

    public userRole getUrByUidRid(int uid,int rid);

    public int adduserRole(userRole ur);

    public List<userRole> getUrByUid(int uid);

    public void deleteUserRole(int id);
}
