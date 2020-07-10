package com.wxk.cmdb.service;

import com.wxk.cmdb.domain.CPU;
import com.wxk.cmdb.domain.Disk;

import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/12
 */
public interface DiskService {

    public int add(Disk disk);

    public List<Disk> findall();

    public void del(String serverID);

    public Disk updata(Disk disk);

    public Disk findDisk(String DiskSN);
}
