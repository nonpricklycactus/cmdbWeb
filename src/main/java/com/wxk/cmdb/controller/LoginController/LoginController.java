package com.wxk.cmdb.controller.LoginController;
import com.wxk.cmdb.domain.pageParameter.JsonData;
import com.wxk.cmdb.domain.pageParameter.PageUser;
import com.wxk.cmdb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    //登录
    @RequestMapping(value = {"/login","/login.html"},method = RequestMethod.GET)
    public String toLogin(){
        return "pages/login";
    }

    @Autowired
    private UserService userService;
    //用户登录
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object login(@RequestBody PageUser pageUser,HttpSession session){
        //获取用户名和密码
        String userName=pageUser.getLoginUsername();
        String userPassword=pageUser.getLoginPassword();
        if(userName!=null&&userPassword!=null&&userPassword.equals(userService.findpassword(userName))){
                //将用户对象添加到Session中
                 session.setAttribute("USER_SESSION",pageUser);
                 //重定向到主页面的跳转方法
                 return JsonData.buildSuccess();
            }
         return JsonData.buildError("密码不正确！");
    }

    @RequestMapping(value = "/logout")
     public String logout(HttpSession session){
        //清除session
        session.invalidate();
        //重定向到登录页面的跳转方法
        return "pages/login";
    }
}
