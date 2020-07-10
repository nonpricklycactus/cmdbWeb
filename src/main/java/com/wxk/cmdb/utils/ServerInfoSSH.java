package com.wxk.cmdb.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/11
 */
public class ServerInfoSSH {

    private static  BaseSSH baseSSH=new BaseSSH();

    public  String CpuManufactory(String host, String username, String password) throws IOException {
        String cmd = "cat /proc/cpuinfo | grep name | cut -f2 -d: |uniq -c";
        String pattern = "([Intel]{5}|[AMD]{3})";
        String str;
        str = baseSSH.Serverinfo(host,username,password,cmd,pattern);
        return str;
    }

    public  String CpuModel(String host, String username, String password) throws IOException {
        String cmd = "cat /proc/cpuinfo | grep name | cut -f2 -d: |uniq -c";
        String pattern = "(([Intel]{5}|[AMD]{3}).+)";
        String str;
        str = baseSSH.Serverinfo(host,username,password,cmd,pattern);
        return str;
    }

    public String  Hostname(String host, String username, String password) throws IOException {
        String cmd = "hostname ";
        String str;
        str = baseSSH.GetSSH(host,username,password,cmd);
        return str;
    }

    public String  DeviceType(String host, String username, String password) throws IOException {
        String cmd = "dmidecode | grep \"Product Name\"";
        String str;
        str = baseSSH.GetSSH(host,username,password,cmd);
        if (str==""){
            str="Dell Inc. PowerEdge R720";
        }
        return str;
    }

    public String SystemVersion(String host, String username, String password) throws IOException {
        String cmd = "cat /etc/issue";
        String pattern = "((.+)[A-Z])";
        String str;
        str = baseSSH.Serverinfo(host,username,password,cmd,pattern);
        return str;
    }

    public String SystemKernel(String host, String username, String password) throws IOException {
        String cmd = "uname -a";
        String pattern = "((.+)[-][a-z]+)";
        String str;
        str = baseSSH.Serverinfo(host,username,password,cmd,pattern);
        return str;
    }

    public String HardDisk(String host, String username, String password) throws IOException {
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

    public String Memory(String host, String username, String password) throws IOException {
        String cmd = "cat /proc/meminfo | grep MemTotal";
        String pattern = "\\d+.[a-z][A-Z]";
        String str;
        str = baseSSH.Serverinfo(host,username,password,cmd,pattern);
        return str;
    }

    public String  CPUCores(String host, String username, String password) throws IOException {
        String cmd = "cat /proc/cpuinfo | grep \"cpu cores\" | uniq ";
        String pattern = "\\d+";
        String str;
        str = baseSSH.Serverinfo(host,username,password,cmd,pattern);
        return str;
    }

    public List<String>  SystemIp(String host, String username, String password) throws IOException {
        String cmd = "ifconfig";
        String pattern = "(inet addr:\\d+.\\d+.\\d+.\\d+)";
        String str;
        str = baseSSH.GetSSH(host,username,password,cmd);
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        List<String> ip=new ArrayList<>();
        while (m.find()){
            Pattern r2 = Pattern.compile("(\\d+.\\d+.\\d+.\\d+)");
            Matcher m2 = r2.matcher(m.group());
            m2.find();
            ip.add(m2.group());
        }
        return ip;
    }

}
