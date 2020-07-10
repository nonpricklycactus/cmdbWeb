package com.wxk.cmdb.domain;

import java.util.Date;

/**
 * @Description:服务器账号信息
 * @Author: nonpricklycactus
 * @CreateDate: 2020/3/17
 */
public class ServerUser {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public String getSeverID() {
        return severID;
    }

    public void setSeverID(String severID) {
        this.severID = severID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    private String severID;
    private int userID;
    private String user;
    private String password;
    private String ipaddr;
    private Date createTime;
    private Date updateTime;
}
