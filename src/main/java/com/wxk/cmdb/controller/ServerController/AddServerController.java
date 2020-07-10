package com.wxk.cmdb.controller.ServerController;

import com.wxk.cmdb.domain.*;
import com.wxk.cmdb.domain.pageParameter.JsonData;
import com.wxk.cmdb.domain.pageParameter.AddServer;
import com.wxk.cmdb.domain.pageParameter.PageUser;
import com.wxk.cmdb.service.*;
import com.wxk.cmdb.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/4/19
 */

@Controller
public class AddServerController {
    @Autowired
    private UserService userService;
    @Autowired
    private SeverUserService severUserService;
    @Autowired
    private CpuService cpuService;
    @Autowired
    private DiskService diskService;
    @Autowired
    private MemoryService memoryService;
    @Autowired
    private NetworkService networkService;
    @Autowired
    private ServerInfoService serverInfoService;

    @RequestMapping(value = "pages/serverpage/addserver.html",method = RequestMethod.GET)
    public String addServerpage(){

        return "/pages/serverpage/addserver.html";
    }

    @RequestMapping(value = "pages/serverpage/addserver.html",method = RequestMethod.POST)
    @ResponseBody
    public Object addServerinfo(@RequestBody AddServer addservers, HttpSession session) throws IOException {
        GenerateID generateID=new GenerateID();
        String server_id=generateID.getCharAndNumr(12);

        //192.168.23.0 wxk 123456
        PageUser user = (PageUser) session.getAttribute("USER_SESSION");
        String ip=addservers.getIp();
        String username=addservers.getUsername();
        String userpassword=addservers.getPassword();

        try {
            serverInfoService.add(getServerinfo(ip,username,userpassword,server_id));
        }catch (IOException e){
            return JsonData.buildError("账号错误");
        }
        severUserService.add(getUserServiceInfo(user,ip,username,userpassword,server_id));
        cpuService.add(getCpuInfo(ip,username,userpassword,server_id));
        diskService.add(getDiskInfo(ip,username,userpassword,server_id));
        memoryService.add(getMemoryInfo(ip,username,userpassword,server_id));
        networkService.add(getNetWorkInfo(ip,username,userpassword,server_id));

        return JsonData.buildSuccess();
    }

    public ServerInfo getServerinfo(String ip,String username,String userpassword,String server_id) throws IOException {
        ServerInfoSSH serverInfoSSH=new ServerInfoSSH();

        String hostname=serverInfoSSH.Hostname(ip,username,userpassword);
        String device_type=serverInfoSSH.DeviceType(ip,username,userpassword);
        String system_version=serverInfoSSH.SystemVersion(ip,username,userpassword);
        String system_kernel=serverInfoSSH.SystemKernel(ip,username,userpassword);
        String hard_disk=serverInfoSSH.HardDisk(ip,username,userpassword);
        String memory=serverInfoSSH.Memory(ip,username,userpassword);
        String physical_cpu_cores=serverInfoSSH.CPUCores(ip,username,userpassword);

        ServerInfo serverInfo=new ServerInfo();
        serverInfo.setServer_id(server_id);
        serverInfo.setHostname(hostname);
        serverInfo.setDevice_type(device_type);
        serverInfo.setSystem_version(system_version);
        serverInfo.setSystem_kernel(system_kernel);
        serverInfo.setHard_disk(hard_disk);
        serverInfo.setMemory(memory);
        serverInfo.setPhysical_cpu_cores(physical_cpu_cores);
        serverInfo.setSystem_ip(ip);
        serverInfo.setCheck_time(new Date());

        return serverInfo;
    }

    public CPU getCpuInfo(String ip, String username, String userpassword, String server_id) throws IOException{
        CPU cpu=new CPU();
        CpuSSH cpuSSH=new CpuSSH();
        GenerateID generateID=new GenerateID();

        String CpuId=generateID.getCharAndNumr(12);

        String CpuManufactory=cpuSSH.CpuManufactory(ip,username,userpassword);
        String CpuModel=cpuSSH.CpuModel(ip,username,userpassword);

        cpu.setSn(CpuId);
        cpu.setSever_id(server_id);
        cpu.setModel(CpuModel);
        cpu.setManufactory(CpuManufactory);

        return cpu;
    }

    public Disk getDiskInfo(String ip, String username, String userpassword, String server_id) throws IOException{
        Disk disk=new Disk();
        DiskSSH diskSSH=new DiskSSH();
        GenerateID generateID=new GenerateID();

        String DiskId=generateID.getCharAndNumr(12);
        String DiskModel=diskSSH.DiskModel(ip,username,userpassword);
        String DiskManufactory=diskSSH.DiskManufactory(ip,username,userpassword);
        String DiskCapacity=diskSSH.DiskCapacity(ip,username,userpassword);
        String DiskIfaceType=diskSSH.DiskIfaceType(ip,username,userpassword);

        disk.setSn(DiskId);
        disk.setSever_id(server_id);
        disk.setModel(DiskModel);
        disk.setManufactory(DiskManufactory);
        disk.setCapacity(DiskCapacity);
        disk.setIface_type(DiskIfaceType);
        disk.setCreate_time(new Date());
        disk.setUpdate_time(new Date());

        return disk;
    }

    public Memory getMemoryInfo(String ip, String username, String userpassword, String server_id) throws IOException{
        Memory memory=new Memory();
        MemorySSH memorySSH=new MemorySSH();
        GenerateID generateID=new GenerateID();

        String MemoryId=generateID.getCharAndNumr(12);
        String MemoryModel=memorySSH.MemoryModel(ip,username,userpassword);
        String MemoryManufactory=memorySSH.MemoryManufactory(ip,username,userpassword);

        memory.setSn(MemoryId);
        memory.setSever_id(server_id);
        memory.setModel(MemoryModel);
        memory.setManufactory(MemoryManufactory);
        memory.setCreate_time(new Date());
        memory.setUpdate_time(new Date());

        return memory;
    }

    public Network getNetWorkInfo(String ip, String username, String userpassword, String server_id) throws IOException{
        Network network=new Network();
        NetworkSSH networkSSH=new NetworkSSH();
        GenerateID generateID=new GenerateID();

        String NetworkId=generateID.getCharAndNumr(12);
        String NetworkModel=networkSSH.NetworkModel(ip,username,userpassword);
        String NetworkManufactory=networkSSH.NetworkManufactory(ip,username,userpassword);
        String NetworkMacAddress=networkSSH.NetworkMacAddress(ip,username,userpassword);

        network.setSn(NetworkId);
        network.setSever_id(server_id);
        network.setModel(NetworkModel);
        network.setManufactory(NetworkManufactory);
        network.setMac_address(NetworkMacAddress);

        return network;
    }

    public ServerUser getUserServiceInfo(PageUser user,String ip,String username,String userpassword,String server_id){
        ServerUser serverUser=new ServerUser();

        int userID=userService.findID("admin");

        serverUser.setIpaddr(ip);
        serverUser.setUserID(userID);
        serverUser.setSeverID(server_id);
        serverUser.setUser(username);
        serverUser.setPassword(userpassword);
        serverUser.setCreateTime(new Date());
        serverUser.setUpdateTime(new Date());

        return serverUser;
    }

}
