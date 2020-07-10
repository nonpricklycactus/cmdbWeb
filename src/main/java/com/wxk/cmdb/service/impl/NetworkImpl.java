package com.wxk.cmdb.service.impl;

import com.wxk.cmdb.domain.Network;
import com.wxk.cmdb.mapper.NetworkMapper;
import com.wxk.cmdb.service.NetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/12
 */

@Service
public class NetworkImpl implements NetworkService {

    @Autowired
    private NetworkMapper networkMapper;

    @Override
    public int add(Network network) {
        networkMapper.addNetwork(network);
        return network.getId();
    }

    @Override
    public List<Network> findall() {
        return networkMapper.findAll();
    }

    @Override
    public void del(String serverID) {
        networkMapper.del(serverID);
    }

    @Override
    public Network updata(Network network) {
        networkMapper.updata(network);
        return networkMapper.findNetwork(network.getSn());
    }

    @Override
    public Network findNetwork(String NetworkSN) {
        return networkMapper.findNetwork(NetworkSN);
    }
}
