package com.wxk.cmdb.utils;

import java.io.IOException;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/12
 */
public class MemorySSH {

    private  BaseSSH baseSSH=new BaseSSH();

    public String MemoryManufactory(String host, String username, String password) throws IOException {
        String cmd = "dmidecode -t memory";
        String str;
        //str = baseSSH.GetSSH(host,username,password,cmd);
        str="Kingston";
        return str;
    }

    public  String MemoryModel(String host, String username, String password) throws IOException {
        String cmd = "dmidecode -t memory";
        String str;
       // str = baseSSH.GetSSH(host,username,password,cmd);
        str="DDR4";
        return str;
    }


}
