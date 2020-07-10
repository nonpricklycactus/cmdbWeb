package com.wxk.cmdb.utils;

import com.wxk.cmdb.domain.CPU;
import com.wxk.cmdb.domain.ServerUser;
import com.wxk.cmdb.domain.pageParameter.JsonData;
import com.wxk.cmdb.service.CpuService;
import com.wxk.cmdb.service.SeverUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/6/7
 */

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class Time {
    @Autowired
    private CpuService cpuService;

    @Autowired
    private SeverUserService severUserService;

    @Scheduled(cron = "* * 0/23 * * ?")
    private void CpuUpdata() throws IOException {
        CPU cpu = new CPU();
        CpuSSH cpuSSH = new CpuSSH();
        List<ServerUser> serverUsers = severUserService.findAll();

        for (ServerUser serverUser : serverUsers) {
            String serverID = serverUser.getSeverID();
            CPU cpu1 = cpuService.findCpu2(serverID);
            String host = serverUser.getIpaddr();
            String user = serverUser.getUser();
            String password = serverUser.getPassword();

            String CpuManufactory = cpuSSH.CpuManufactory(host, user, password);
            String CpuModel = cpuSSH.CpuModel(host, user, password);

            if (cpu1.getManufactory()==CpuManufactory){
                System.out.println("资产数据未改变");
            }else {
                cpu.setSn(cpu1.getSn());
                cpu.setModel(CpuModel);
                cpu.setManufactory(CpuManufactory);

                try {
                    cpuService.updata(cpu);
                    System.out.println("资产数据发生改变");
                }catch (Exception e){
                }
            }

        }
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
    }
}
