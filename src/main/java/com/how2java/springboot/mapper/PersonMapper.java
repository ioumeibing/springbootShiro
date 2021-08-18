package com.how2java.springboot.mapper;

import com.how2java.springboot.pojo.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PersonMapper
{
    public List<Person> GetAll();

    public int add(Person person);
    public void delete(int id);
    public int update(Person person);
    public Person getById(int id);

    /*当方法有两个参数时，需要使用@Param*/
    public Person getNamePassword(@Param("userName")String userName , @Param("password") String password);

    public List<String> getUserNameByUserRole();

    public Person getUserByName(String name);

    public int addUserRole(@Param("uid") int uid,@Param("rid") int rid);

    public int addUserDept(@Param("uid")int uid,@Param("did")int did);

}
