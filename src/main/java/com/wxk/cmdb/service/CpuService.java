package com.wxk.cmdb.service;

import com.wxk.cmdb.domain.CPU;

import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/12
 */
public interface CpuService {

    public int add(CPU cpu);

    public List<CPU> findall();

    public void del(String CpuSN);

    public CPU updata(CPU cpu);

    public CPU findCpu(String CpuSN);

    public CPU findCpu2(String serverID);
}
