package com.how2java.springboot.mapper;

import com.how2java.springboot.pojo.userRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface userRoleMapper {

    public int updateUserRole(userRole ur);

    public userRole getUrByUidRid(@Param("uid")int uid,@Param("rid")int rid);

    public int adduserRole(userRole ur);

    public List<userRole> getUrByUid(int uid);

    public void deleteUserRole(int id);

}
