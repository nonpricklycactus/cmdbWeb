package com.wxk.cmdb.controller.PropertyController;

import com.wxk.cmdb.domain.Disk;
import com.wxk.cmdb.domain.ServerUser;
import com.wxk.cmdb.domain.pageParameter.JsonData;
import com.wxk.cmdb.domain.pageParameter.JsonData2;
import com.wxk.cmdb.service.DiskService;
import com.wxk.cmdb.service.SeverUserService;
import com.wxk.cmdb.utils.DiskSSH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/14
 */
@Controller
public class DiskController {

    @Autowired
    private DiskService diskService;

    @Autowired
    private SeverUserService severUserService;

    @RequestMapping(value = "pages/property/diskproperty.data",method = RequestMethod.GET)
    @ResponseBody
    public Object diskdata(){
        List<Disk> disks=diskService.findall();
        return JsonData2.buildSuccess(disks.size(),disks);
    }

    @ResponseBody
    @RequestMapping(value = "pages/property/deldisk",method = RequestMethod.POST)
    public Object deldisk(@RequestParam(value="sn") String CpuSN){
        try {
            diskService.del(CpuSN);
        }catch (Exception e){
            return JsonData.buildError("删除失败");
        }
        return JsonData.buildSuccess();
    }

    @ResponseBody
    @RequestMapping(value = "pages/property/updatedisk",method = RequestMethod.POST)
    public Object updatedisk(@RequestParam(value="sn") String DiskSN,@RequestParam(value="server_id") String serverID) throws IOException {
        Disk disk=new Disk();
        DiskSSH diskSSH=new DiskSSH();
        ServerUser serverUser=severUserService.loginserver(serverID);

        String ip=serverUser.getIpaddr();
        String username=serverUser.getUser();
        String userpassword=serverUser.getPassword();

        String DiskModel=diskSSH.DiskModel(ip,username,userpassword);
        String DiskManufactory=diskSSH.DiskManufactory(ip,username,userpassword);
        String DiskCapacity=diskSSH.DiskCapacity(ip,username,userpassword);
        String DiskIfaceType=diskSSH.DiskIfaceType(ip,username,userpassword);

        disk.setSn(DiskSN);
        disk.setSever_id(serverID);
        disk.setModel(DiskModel);
        disk.setManufactory(DiskManufactory);
        disk.setCapacity(DiskCapacity);
        disk.setIface_type(DiskIfaceType);
        disk.setUpdate_time(new Date());

        try {
            diskService.updata(disk);
        }catch (Exception e){
            return JsonData.buildError("更新失败");
        }

        return JsonData.buildSuccess(disk);

    }
}
