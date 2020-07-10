package com.wxk.cmdb.service.impl;

import com.wxk.cmdb.domain.CPU;
import com.wxk.cmdb.mapper.CpuMapper;
import com.wxk.cmdb.service.CpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/12
 */

@Service
public class CpuImpl implements CpuService {

    @Autowired
    private CpuMapper cpuMapper;

    @Override
    public int add(CPU cpu) {
        cpuMapper.addCpu(cpu);
        return cpu.getId();
    }

    @Override
    public List<CPU> findall() {
        return cpuMapper.findAll();
    }

    @Override
    public void del(String CpuSN) {
        cpuMapper.del(CpuSN);
    }

    @Override
    public CPU updata(CPU cpu) {
        cpuMapper.updata(cpu);
        return cpuMapper.findCpu(cpu.getSn());
    }

    @Override
    public CPU findCpu(String CpuSN) {
        return cpuMapper.findCpu(CpuSN);
    }

    public CPU findCpu2(String serverID){return cpuMapper.findCpu2(serverID);}
}
