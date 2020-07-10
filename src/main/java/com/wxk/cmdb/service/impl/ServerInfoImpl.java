package com.wxk.cmdb.service.impl;

import com.wxk.cmdb.domain.ServerInfo;
import com.wxk.cmdb.mapper.ServerInfoMapper;
import com.wxk.cmdb.service.ServerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/10
 */

@Service
public class ServerInfoImpl implements ServerInfoService {

    @Autowired
    private ServerInfoMapper serverInfoMapper;

    @Override
    public int add(ServerInfo serverInfo) {
        serverInfoMapper.add(serverInfo);
        int id=serverInfo.getId();
        return id;
    }

    @Override
    public List<ServerInfo> findall() {
        return serverInfoMapper.findAll();
    }

    @Override
    public void del(String serverID) {
        serverInfoMapper.del(serverID);
    }

    @Override
    public void update(String serverID, String hostname) {
        serverInfoMapper.update(serverID,hostname);
    }

}
