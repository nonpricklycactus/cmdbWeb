package com.wxk.cmdb.service;

import com.wxk.cmdb.domain.User;

import java.util.List;

public interface UserService {

    public int add(User user);

    public List<User> findall();

    public String findpassword(String name);

    public int findID(String name);

    public String findRealname(String name);

}
