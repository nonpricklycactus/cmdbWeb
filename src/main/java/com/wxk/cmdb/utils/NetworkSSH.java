package com.wxk.cmdb.utils;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/12
 */
public class NetworkSSH {
    private BaseSSH baseSSH=new BaseSSH();

    public String NetworkManufactory(String host, String username, String password) throws IOException {
        String cmd = "lspci | grep -i ethernet";
        String pattern = "([Intel]{5}|[AMD]{3})";
        String str;
        str = baseSSH.Serverinfo(host,username,password,cmd,pattern);
        return str;
    }

    public String NetworkModel(String host, String username, String password) throws IOException {
        String cmd = "lspci | grep -i ethernet";
        String pattern = "Advanced.+";
        String str;
        str = baseSSH.Serverinfo(host,username,password,cmd,pattern);
        return str;
    }

    public String NetworkMacAddress(String host, String username, String password) throws IOException {
        String cmd = "ifconfig";
        String pattern = "HWaddr.+? inet";
        String str;
        str = baseSSH.Serverinfo(host,username,password,cmd,pattern);
        Pattern r = Pattern.compile("\\d.+?:\\d.+:\\d\\d");
        Matcher m = r.matcher(str);
        m.find();
        return m.group();
    }

}
