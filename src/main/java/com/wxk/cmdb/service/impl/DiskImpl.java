package com.wxk.cmdb.service.impl;

import com.wxk.cmdb.domain.Disk;
import com.wxk.cmdb.mapper.DiskMapper;
import com.wxk.cmdb.service.DiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/12
 */

@Service
public class DiskImpl implements DiskService {

    @Autowired
    private DiskMapper diskMapper;

    @Override
    public int add(Disk disk) {
        diskMapper.addDisk(disk);
        return disk.getId();
    }

    @Override
    public List<Disk> findall() {
        return diskMapper.findAll();
    }

    @Override
    public void del(String serverID) {
        diskMapper.del(serverID);
    }

    @Override
    public Disk updata(Disk disk) {
        diskMapper.updata(disk);
        return diskMapper.findDisk(disk.getSn());
    }

    @Override
    public Disk findDisk(String DiskSN) {
        return diskMapper.findDisk(DiskSN);
    }
}
