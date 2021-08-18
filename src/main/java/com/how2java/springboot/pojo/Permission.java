package com.how2java.springboot.pojo;

import java.util.Set;

public class Permission {
    private int pid;
    private String permissionName;
    private String resourceType;
    private String url;
    private String lastMenu;
    private int parentId;
    private Set<Role> roles;

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public String getLastMenu() {
        return lastMenu;
    }

    public void setLastMenu(String lastMenu) {
        this.lastMenu = lastMenu;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public int getId() {
        return pid;
    }

    public void setId(int id) {
        this.pid = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
