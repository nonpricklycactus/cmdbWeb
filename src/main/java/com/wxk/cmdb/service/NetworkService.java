package com.wxk.cmdb.service;

import com.wxk.cmdb.domain.Network;

import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/12
 */
public interface NetworkService {

    public int add(Network network);

    public List<Network> findall();

    public void del(String serverID);

    public Network updata(Network network);

    public Network findNetwork(String NetworkSN);

}
