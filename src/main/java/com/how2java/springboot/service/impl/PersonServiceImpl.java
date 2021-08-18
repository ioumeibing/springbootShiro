package com.how2java.springboot.service.impl;

import com.how2java.springboot.mapper.DepartmentMapper;
import com.how2java.springboot.mapper.PersonMapper;
import com.how2java.springboot.mapper.RoleMapper;
import com.how2java.springboot.pojo.Department;
import com.how2java.springboot.pojo.Person;
import com.how2java.springboot.pojo.Role;
import com.how2java.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonMapper personMapper;

    @Autowired
    RoleMapper roleMapper;
    @Autowired
    DepartmentMapper deptsMapper;
    @Override
    public List<Person> GetAll() {
        List<Person> persons = personMapper.GetAll();
        persons.forEach(person -> {
            Set<Role> roles =roleMapper.getRoleNameByUid(person.getId());
            List<Department> depts=deptsMapper.getDeptByUid(person.getId());
            person.setRoleList(roles);
            person.setDepartments(depts);
        });
        return persons;
    }


    @Override
    @Transactional
    public int add(Person person) {
        return personMapper.add(person);
    }

    @Override
    public void delete(int id) {
        personMapper.delete(id);
    }

    @Override
    public int update(Person person) {
        return personMapper.update(person);
    }

    @Override
    public Person getById(int id) {
        return personMapper.getById(id);
    }

    @Override
    public Person getNamePassword(String userName, String password) {
        return personMapper.getNamePassword(userName,password);
    }

    @Override
    public List<String> getUserNameByUserRole() {
        return personMapper.getUserNameByUserRole();
    }

    @Override
    public Person getUserByName(String name) {
        return personMapper.getUserByName(name);
    }

    @Override
    public int addUserRole(int uid, int rid) {
        return personMapper.addUserRole(uid,rid);
    }

    @Override
    public int addUserDept(int uid, int did) {
        return personMapper.addUserDept(uid,did);
    }

}
