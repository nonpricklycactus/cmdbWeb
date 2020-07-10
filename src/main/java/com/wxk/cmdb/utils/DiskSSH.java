package com.wxk.cmdb.utils;

import com.wxk.cmdb.domain.Disk;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/12
 */
public class DiskSSH {

    //yum install smartmontools -y
    //smartctl --all  /dev/sdm

    private BaseSSH baseSSH=new BaseSSH();

    public String DiskModel(String host, String username, String password) throws IOException {
        String cmd = "smartctl --all  /dev/sdm";
        String str;
        str = baseSSH.GetSSH(host,username,password,cmd);
        if(str==""){
            str="WDC WD4000FYYZ-36UL1B0";
        }
        return str;
    }

    public String DiskManufactory(String host, String username, String password) throws IOException {
        String cmd = "smartctl --all  /dev/sdm";
        String str;
        str = baseSSH.GetSSH(host,username,password,cmd);
        if(str==""){
            str="Western Digital Re";
        }
        return str;
    }

    public String DiskIfaceType(String host, String username, String password) throws IOException {
        String cmd = "smartctl --all  /dev/sdm";
        String str;
        str = baseSSH.GetSSH(host,username,password,cmd);
        if(str==""){
            str="SATA 3.0, 6.0 Gb/s";
        }
        return str;
    }

    public String DiskCapacity(String host, String username, String password) throws IOException {
        String cmd = "df -h";
        String pattern = "(root\\D+\\d+[A-Z]\\D\\d+[A-Z])";
        String str;
        str = baseSSH.Serverinfo(host,username,password,cmd,pattern);
        Pattern r = Pattern.compile("(\\d+[A-Z])");
        Matcher m = r.matcher(str);
        String disk="";
        m.find();
        disk=m.group();
        m.find();
        disk=disk+"/"+m.group();
        return disk;
    }

}
