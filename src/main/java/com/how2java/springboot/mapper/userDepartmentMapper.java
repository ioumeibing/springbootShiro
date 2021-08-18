package com.how2java.springboot.mapper;

import com.how2java.springboot.pojo.userDepartment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface userDepartmentMapper {

    public int updateUserDepartment(userDepartment ud);

    public List<userDepartment> getUdByUid(int uid);

}
