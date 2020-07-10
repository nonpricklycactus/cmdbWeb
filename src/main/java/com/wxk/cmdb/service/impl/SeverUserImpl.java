package com.wxk.cmdb.service.impl;

import com.wxk.cmdb.domain.ServerUser;
import com.wxk.cmdb.mapper.SeverUserMapper;
import com.wxk.cmdb.service.SeverUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/11
 */

@Service
public class SeverUserImpl implements SeverUserService {
    @Autowired
    private SeverUserMapper severUserMapper;

    @Override
    public int add(ServerUser serverUser) {
        severUserMapper.add(serverUser);
        int id=serverUser.getId();
        return id;
    }

    @Override
    public void del(String serverID) {
        severUserMapper.del(serverID);
    }

    @Override
    public ServerUser loginserver(String serverID) {
        return severUserMapper.loginserver(serverID);
    }

    @Override
    public List<ServerUser> findAll() {
        return severUserMapper.findAll();
    }
}
