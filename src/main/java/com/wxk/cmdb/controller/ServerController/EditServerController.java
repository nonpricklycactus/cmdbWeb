package com.wxk.cmdb.controller.ServerController;

import com.wxk.cmdb.domain.ServerInfo;
import com.wxk.cmdb.domain.pageParameter.JsonData;
import com.wxk.cmdb.domain.pageParameter.JsonData2;
import com.wxk.cmdb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/13
 */

@Controller
public class EditServerController {
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

    @ResponseBody
    @RequestMapping(value = "pages/serverpage/delserver",method = RequestMethod.POST)
    public Object delserver (@RequestParam(value="server_id") String serverId){

        severUserService.del(serverId);
        cpuService.del(serverId);
        diskService.del(serverId);
        memoryService.del(serverId);
        networkService.del(serverId);

        try {
            serverInfoService.del(serverId);
        }catch (Exception e){
            return JsonData.buildError("存在约束");
        }

        return JsonData.buildSuccess();

    }

    @ResponseBody
    @RequestMapping(value = "pages/serverpage/editserver",method = RequestMethod.POST)
    public Object editserver(@RequestParam(value="server_id") String serverId,@RequestParam(value="hostname") String hostname){

        try {
            serverInfoService.update(serverId,hostname);
        }catch (Exception e){
            return JsonData.buildError("更新失败");
        }
        return JsonData.buildSuccess();
    }
}
