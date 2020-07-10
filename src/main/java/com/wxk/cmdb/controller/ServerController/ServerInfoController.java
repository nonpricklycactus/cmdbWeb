package com.wxk.cmdb.controller.ServerController;

import com.wxk.cmdb.domain.ServerInfo;
import com.wxk.cmdb.domain.pageParameter.JsonData;
import com.wxk.cmdb.domain.pageParameter.JsonData2;
import com.wxk.cmdb.service.ServerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/10
 */
@Controller
public class ServerInfoController {

    @Autowired
    private ServerInfoService serverInfoService;

    @RequestMapping(value = "pages/serverpage/server.html",method = RequestMethod.GET)
    public String serverinfo(){

        return "pages/serverpage/server.html";
    }

    @ResponseBody
    @RequestMapping(value = "pages/serverpage/serverdata",method = RequestMethod.GET)
    public Object serverdata (){

        List<ServerInfo> serverInfos;
        serverInfos=serverInfoService.findall();
        return JsonData2.buildSuccess(serverInfos.size(),serverInfos);

    }

}
