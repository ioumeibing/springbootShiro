package com.how2java.springboot.pojo;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.*;

public class Person implements Serializable {
    private int uid;
    private String userName;
    private String password;
    private String phone;
    private String address;
    private String sex;
    private int age;
    private Date createDate;
    private String salt;
    private Set<Role> roles=new HashSet<>();
    private List<Department> departments=new ArrayList<>();

    public int getId(){return uid;}
    public String getUserName(){return userName;}
    public String getPassword(){return password;}
    public String getPhone(){return phone;}
    public String getAddress(){return address;}
    public String getSex(){return sex;}
    public int getAge(){return age;}
    public Date getCreateDate(){return createDate;}
    public String getSalt() { return salt; }
    public Set<Role> getRoleList() {
        return roles;
    }
    public List<Department> getDepartments() {
        return departments;
    }

    public void setId(int id){this.uid = id;}
    public void setUserName(String name){this.userName =name;}
    public void setPassword(String password){this.password = password;}
    public void setPhone(String phone){this.phone =phone;}
    public void setAddress(String address){this.address = address;}
    public void setSex(String sex){this.sex = sex;}
    public void setAge(int age){this.age = age;}
    public void setCreateDate(Date createDate){this.createDate = createDate;}
    public void setSalt(String salt) { this.salt = salt; }

    public void setRoleList(Set<Role> roleList) {
        this.roles = roleList;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
