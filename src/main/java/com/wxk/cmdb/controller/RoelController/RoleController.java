package com.wxk.cmdb.controller.RoelController;

import com.wxk.cmdb.domain.Role;
import com.wxk.cmdb.domain.pageParameter.JsonData2;
import com.wxk.cmdb.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/6/6
 */
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping(value = "pages/member/roledata",method = RequestMethod.GET)
    public Object roledata (){

        List<Role> roles;
        roles=roleService.findAll();
        return JsonData2.buildSuccess(roles.size(),roles);

    }
}
