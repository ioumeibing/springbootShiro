package com.how2java.springboot.pojo;

public class Department {

    private int did;
    private String deptName;
    private String postionName;
    private String remark;
    private int parentId;

    public int getDid() {
        return did;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getPostionName() {
        return postionName;
    }

    public String getRemark() {
        return remark;
    }

    public int getParentId() {
        return parentId;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setPostionName(String postionName) {
        this.postionName = postionName;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
