package com.wxk.cmdb.service;

import com.wxk.cmdb.domain.Memory;

import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/12
 */
public interface MemoryService {

    public int add(Memory memory);

    public List<Memory> findall();

    public void del(String serverID);

    public Memory updata(Memory memory);

    public Memory findMemory(String MemorySN);


}
