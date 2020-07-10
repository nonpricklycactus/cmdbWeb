package com.wxk.cmdb.controller.PropertyController;

import com.wxk.cmdb.domain.Memory;
import com.wxk.cmdb.domain.ServerUser;
import com.wxk.cmdb.domain.pageParameter.JsonData;
import com.wxk.cmdb.domain.pageParameter.JsonData2;
import com.wxk.cmdb.service.MemoryService;
import com.wxk.cmdb.service.SeverUserService;
import com.wxk.cmdb.utils.MemorySSH;
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
public class MemoryController {

    @Autowired
    private MemoryService memoryService;

    @Autowired
    private SeverUserService severUserService;

    @RequestMapping(value = "pages/property/memoryproperty.data",method = RequestMethod.GET)
    @ResponseBody
    public Object Memorydata(){
        List<Memory> memories=memoryService.findall();
        return JsonData2.buildSuccess(memories.size(),memories);
    }

    @ResponseBody
    @RequestMapping(value = "pages/property/delmemory",method = RequestMethod.POST)
    public Object delMemory(@RequestParam(value="sn") String MemorySN){
        try {
            memoryService.del(MemorySN);
        }catch (Exception e){
            return JsonData.buildError("删除失败");
        }
        return JsonData.buildSuccess();
    }

    @ResponseBody
    @RequestMapping(value = "pages/property/updatememory",method = RequestMethod.POST)
    public Object updateMemory(@RequestParam(value="sn") String MemorySN,@RequestParam(value="server_id") String serverID) throws IOException {

        Memory memory=new Memory();
        MemorySSH memorySSH=new MemorySSH();
        ServerUser serverUser=severUserService.loginserver(serverID);

        String ip=serverUser.getIpaddr();
        String username=serverUser.getUser();
        String userpassword=serverUser.getPassword();

        String MemoryModel=memorySSH.MemoryModel(ip,username,userpassword);
        String MemoryManufactory=memorySSH.MemoryManufactory(ip,username,userpassword);

        memory.setSn(MemorySN);
        memory.setSever_id(serverID);
        memory.setModel(MemoryModel);
        memory.setManufactory(MemoryManufactory);
        memory.setUpdate_time(new Date());

        try {
            memoryService.updata(memory);
        }catch (Exception e){
            return JsonData.buildError("更新失败");
        }
        return JsonData.buildSuccess(memory);
    }
}
