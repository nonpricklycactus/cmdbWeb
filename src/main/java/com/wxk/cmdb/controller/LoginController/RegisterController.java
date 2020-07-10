package com.wxk.cmdb.controller.LoginController;

import com.wxk.cmdb.domain.Department;
import com.wxk.cmdb.domain.User;
import com.wxk.cmdb.domain.pageParameter.JsonData;
import com.wxk.cmdb.domain.pageParameter.PageRegister;
import com.wxk.cmdb.domain.pageParameter.PageUser;
import com.wxk.cmdb.service.DepartmentService;
import com.wxk.cmdb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * 注册用户
 * @Author: nonpricklycactus
 * @CreateDate: 2020/4/12
 */
@Controller
public class RegisterController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = {"/register","/register.html","/pages/register.html"},method = RequestMethod.GET)
    public String registerPage(Model model){

        List<Department> departments;
        departments=departmentService.findall();
        model.addAttribute("departs",departments);

        return "pages/register.html";
    }

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = {"/register","/register.html"},method = RequestMethod.POST)
    public Object login(@RequestBody PageRegister pageRegister){
        User user=new User();

        user.setUsername(pageRegister.getUsername());
        user.setPassword(pageRegister.getPassword());
        user.setRealname(pageRegister.getRealname());
        user.setDepartId(pageRegister.getDepartId());
        user.setPhone(pageRegister.getPhone());
        user.setEmail(pageRegister.getEmail());

        if (user!=null) {
            Integer i = userService.add(user);
            if (i!=null){
                return JsonData.buildSuccess();
            }
        }
       return JsonData.buildError("注册失败！");
    }

}
