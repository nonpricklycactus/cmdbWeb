package com.wxk.cmdb.controller.PropertyController;

import com.wxk.cmdb.domain.Network;
import com.wxk.cmdb.domain.ServerUser;
import com.wxk.cmdb.domain.pageParameter.JsonData;
import com.wxk.cmdb.domain.pageParameter.JsonData2;
import com.wxk.cmdb.service.NetworkService;
import com.wxk.cmdb.service.SeverUserService;
import com.wxk.cmdb.utils.NetworkSSH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/14
 */
@Controller
public class NetworkController {

    @Autowired
    private NetworkService networkService;

    @Autowired
    private SeverUserService severUserService;

    @RequestMapping(value = "pages/property/networkproperty.data",method = RequestMethod.GET)
    @ResponseBody
    public Object Networkdata(){
        List<Network> networks=networkService.findall();
        return JsonData2.buildSuccess(networks.size(),networks);
    }

    @ResponseBody
    @RequestMapping(value = "pages/property/delnetwork",method = RequestMethod.POST)
    public Object delNetwork(@RequestParam(value="sn") String CpuSN){
        try {
            networkService.del(CpuSN);
        }catch (Exception e){
            return JsonData.buildError("删除失败");
        }
        return JsonData.buildSuccess();
    }

    @ResponseBody
    @RequestMapping(value = "pages/property/updatenetwork",method = RequestMethod.POST)
    public Object updateNetwork(@RequestParam(value="sn") String NetworkSN,@RequestParam(value="server_id") String serverID) throws IOException {
        Network network=new Network();
        NetworkSSH networkSSH=new NetworkSSH();
        ServerUser serverUser=severUserService.loginserver(serverID);

        String ip=serverUser.getIpaddr();
        String username=serverUser.getUser();
        String userpassword=serverUser.getPassword();

        String NetworkModel=networkSSH.NetworkModel(ip,username,userpassword);
        String NetworkManufactory=networkSSH.NetworkManufactory(ip,username,userpassword);
        String NetworkMacAddress=networkSSH.NetworkMacAddress(ip,username,userpassword);

        network.setSn(NetworkSN);
        network.setSever_id(serverID);
        network.setModel(NetworkModel);
        network.setManufactory(NetworkManufactory);
        network.setMac_address(NetworkMacAddress);

        try {
            networkService.updata(network);
        }catch (Exception e){
            return JsonData.buildError("更新失败");
        }
        return JsonData.buildSuccess(network);
    }
}
