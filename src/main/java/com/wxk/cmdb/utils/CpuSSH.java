package com.wxk.cmdb.utils;

import com.wxk.cmdb.domain.CPU;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/12
 */
public class CpuSSH {
    private BaseSSH baseSSH=new BaseSSH();

    public String CpuManufactory(String host, String username, String password) throws IOException {
        String cmd = "cat /proc/cpuinfo | grep name | cut -f2 -d: |uniq -c";
        String pattern = "([Intel]{5}|[AMD]{3})";
        String str;
        str = baseSSH.Serverinfo(host,username,password,cmd,pattern);
        return str;
    }

    public String CpuModel(String host, String username, String password) throws IOException {
        String cmd = "cat /proc/cpuinfo | grep name | cut -f2 -d: |uniq -c";
        String pattern = "(([Intel]{5}|[AMD]{3}).+)";
        String str;
        str = baseSSH.Serverinfo(host,username,password,cmd,pattern);
        return str;
    }

    public CPU cpu_ssh(String host, String username, String password,String SeverID) throws IOException {
        CPU cpu=new CPU();
        GenerateID generateID=new GenerateID();

        String CpuManufactory=CpuManufactory(host,username,password);
        String CpuModel=CpuModel(host,username,password);

        cpu.setSever_id(SeverID);
        cpu.setSn(generateID.getCharAndNumr(12));
        cpu.setManufactory(CpuManufactory);
        cpu.setModel(CpuModel);

        return cpu;

    }

}
