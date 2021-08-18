package com.how2java.springboot.service;

import com.how2java.springboot.pojo.Person;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PersonService {

    public List<Person> GetAll();

    public int add(Person person);

    public void delete(int id);

    public int update(Person person);

    public Person getById(int id);
    public Person getNamePassword(String userName ,String password);

    public List<String> getUserNameByUserRole();

    public Person getUserByName(String name);

    public int addUserRole( int uid,  int rid);

    public int addUserDept(int uid,int did);

}
