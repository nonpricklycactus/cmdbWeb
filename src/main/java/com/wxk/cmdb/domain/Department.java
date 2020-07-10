package com.wxk.cmdb.domain;

/**
 * @Description:部门信息
 * @Author: nonpricklycactus
 * @CreateDate: 2020/3/17
 */
public class Department {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private int id;
    private String depname;
    private String description;
}
