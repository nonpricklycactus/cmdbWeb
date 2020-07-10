package com.wxk.cmdb.service;

import com.wxk.cmdb.domain.ServerUser;

import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/11
 */
public interface SeverUserService {
    public int add(ServerUser serverUser);

    public void del(String serverID);

    public ServerUser loginserver(String serverID);

    public List<ServerUser> findAll();
}
