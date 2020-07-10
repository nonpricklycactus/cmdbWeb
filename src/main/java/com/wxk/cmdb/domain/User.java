package com.wxk.cmdb.domain;

import java.math.BigInteger;

/**
 * @Description:用户信息
 * @Author: nonpricklycactus
 * @CreateDate: 2020/3/17
 */
public class User {
    private Integer id;
    private String  username;
    private String  password;
    private String  realname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword(String password) {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Integer getDepartId() {
        return departId;
    }

    public void setDepartId(Integer departId) {
        this.departId = departId;
    }
    public void setDepartId(String departId) {
        this.departId = Integer.parseInt(departId);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private Integer departId;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String phone;
    private String  email;
}
