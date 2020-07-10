package com.wxk.cmdb.service;

import com.wxk.cmdb.domain.ServerInfo;

import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/10
 */
public interface ServerInfoService {
    public int add(ServerInfo serverInfo);

    public List<ServerInfo> findall();

    public void del(String serverID);

    public void update(String serverID,String hostname);

}
