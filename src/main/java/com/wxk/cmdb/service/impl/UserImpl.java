package com.wxk.cmdb.service.impl;

import com.wxk.cmdb.domain.User;
import com.wxk.cmdb.mapper.UserMapper;
import com.wxk.cmdb.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int add(User user) {
        userMapper.add(user);
        int id=user.getId();
        return id;
    }

    @Override
    public List<User> findall() {
        return userMapper.findAll();
    }

    @Override
    public String findpassword(String name) {
        return userMapper.findPassword(name);
    }

    @Override
    public int findID(String name) {
        return userMapper.findID(name);
    }

    @Override
    public String findRealname(String name) {
        return userMapper.findRealname(name);
    }
}
