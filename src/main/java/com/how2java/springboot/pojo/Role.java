package com.how2java.springboot.pojo;

import java.util.HashSet;
import java.util.Set;

public class Role {
    private int rid;
    private String roleName;
    private String remark;
    private Set<Person> persons =new HashSet<>();
    private Set<Permission> permissions = new HashSet<>();

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    public int getId() {
        return rid;
    }

    public void setId(int id) {
        this.rid = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
