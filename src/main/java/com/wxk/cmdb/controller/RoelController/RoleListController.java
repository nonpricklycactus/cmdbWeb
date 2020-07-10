package com.wxk.cmdb.controller.RoelController;

import com.wxk.cmdb.domain.Department;
import com.wxk.cmdb.domain.RoleUser;
import com.wxk.cmdb.domain.pageParameter.JsonData2;
import com.wxk.cmdb.service.DepartmentService;
import com.wxk.cmdb.service.RoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class RoleListController {

    @Autowired
    private RoleUserService roleUserService;

    @ResponseBody
    @RequestMapping(value = "pages/member/memberdata",method = RequestMethod.GET)
    public Object memberdata (){

        List<RoleUser> roleUsers;
        roleUsers=roleUserService.findAll();
        return JsonData2.buildSuccess(roleUsers.size(),roleUsers);

    }

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "pages/member/user-add.html",method = RequestMethod.GET)
    public String userAdd(Model model){

        List<Department> departments;
        departments=departmentService.findall();
        model.addAttribute("departs",departments);

        return "pages/member/user-add.html";
    }
}
