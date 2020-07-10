package com.wxk.cmdb.controller.PropertyController;

import com.wxk.cmdb.domain.CPU;
import com.wxk.cmdb.domain.ServerUser;
import com.wxk.cmdb.domain.pageParameter.JsonData;
import com.wxk.cmdb.domain.pageParameter.JsonData2;
import com.wxk.cmdb.service.CpuService;
import com.wxk.cmdb.service.SeverUserService;
import com.wxk.cmdb.utils.CpuSSH;
import com.wxk.cmdb.utils.GenerateID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/14
 */


@Controller
public class CpuController {

    @Autowired
    private CpuService cpuService;

    @Autowired
    private SeverUserService severUserService;

    @RequestMapping(value = "pages/property/cpuproperty.data",method = RequestMethod.GET)
    @ResponseBody
    public Object cpudata(){
        List<CPU> cpus=cpuService.findall();
        return JsonData2.buildSuccess(cpus.size(),cpus);
    }

    @ResponseBody
    @RequestMapping(value = "pages/property/delcpu",method = RequestMethod.POST)
    public Object delcpu(@RequestParam(value="sn") String CpuSN){
        try {
            cpuService.del(CpuSN);
        }catch (Exception e){
            return JsonData.buildError("删除失败");
        }
        return JsonData.buildSuccess();
    }

    @ResponseBody
    @RequestMapping(value = "pages/property/updatecpu",method = RequestMethod.POST)
    public Object updatecpu(@RequestParam(value="sn") String CpuSN,@RequestParam(value="server_id") String serverID) throws IOException {

        CPU cpu=new CPU();
        CpuSSH cpuSSH=new CpuSSH();
        ServerUser serverUser=severUserService.loginserver(serverID);
        CPU cpu1=cpuService.findCpu(CpuSN);

        String host=serverUser.getIpaddr();
        String user=serverUser.getUser();
        String password=serverUser.getPassword();

        String CpuManufactory=cpuSSH.CpuManufactory(host,user,password);
        String CpuModel=cpuSSH.CpuModel(host,user,password);

        if (cpu1.getManufactory()==CpuManufactory){
            System.out.println("资产数据未改变");
            return JsonData.buildSuccess(cpu);
        }else {
            cpu.setSn(CpuSN);
            cpu.setModel(CpuModel);
            cpu.setManufactory(CpuManufactory);

            try {
                cpuService.updata(cpu);
                System.out.println("资产数据发生改变");
            }catch (Exception e){
                return JsonData.buildError("更新失败");
            }
        }

        return JsonData.buildSuccess(cpu);
    }
}
