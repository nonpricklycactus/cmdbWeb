package com.wxk.cmdb.service.impl;

import com.wxk.cmdb.domain.Memory;
import com.wxk.cmdb.mapper.MemoryMapper;
import com.wxk.cmdb.service.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/12
 */

@Service
public class MemoryImpl implements MemoryService {

    @Autowired
    private MemoryMapper memoryMapper;

    @Override
    public int add(Memory memory) {
        memoryMapper.addMemory(memory);
        return memory.getId();
    }

    @Override
    public List<Memory> findall() {
        return memoryMapper.findAll();
    }

    @Override
    public void del(String serverID) {
        memoryMapper.del(serverID);
    }

    @Override
    public Memory updata(Memory memory) {
        memoryMapper.updata(memory);
        return memoryMapper.findMemory(memory.getSn());
    }

    @Override
    public Memory findMemory(String MemorySN) {
        return memoryMapper.findMemory(MemorySN);
    }
}
