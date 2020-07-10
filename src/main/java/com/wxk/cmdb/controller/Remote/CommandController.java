package com.wxk.cmdb.controller.Remote;

import com.wxk.cmdb.domain.ServerUser;
import com.wxk.cmdb.domain.pageParameter.Command;
import com.wxk.cmdb.domain.pageParameter.JsonData;
import com.wxk.cmdb.service.SeverUserService;
import com.wxk.cmdb.utils.BaseSSH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/14
 */

@Controller
public class CommandController {

    @Autowired
    private SeverUserService severUserService;


    @ResponseBody
    @RequestMapping(value = "pages/remote/command",method = RequestMethod.POST)
    public Object command(@RequestParam(value="server_id") String[] serverIDs, @RequestParam(value="command") String command) throws IOException {

        BaseSSH baseSSH=new BaseSSH();
        Command commandresult=new Command();
        List<Command> commands=new ArrayList<>();

        for(String serverID:serverIDs) {
            try {
                ServerUser serverUser = severUserService.loginserver(serverID);

                String host = serverUser.getIpaddr();
                String user = serverUser.getUser();
                String password = serverUser.getPassword();

                String result = baseSSH.Command(host, user, password, command);
                commandresult.setServerID(serverID);
                commandresult.setResult(result);
                commands.add(commandresult);
            }catch (Exception e){
                commandresult.setServerID(serverID);
                commandresult.setResult("没有找到该服务器账户");
                continue;
            }
        }

        for (Command str:commands){
            System.out.println(str.getServerID()+":\n"+str.getResult());
        }


        return JsonData.buildSuccess(commands);
    }


}
