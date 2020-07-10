package com.wxk.cmdb.controller;


import com.wxk.cmdb.domain.WebData.carte;
import com.wxk.cmdb.domain.WebData.carteChildren;
import com.wxk.cmdb.domain.pageParameter.JsonData;
import com.wxk.cmdb.domain.pageParameter.PageUser;
import com.wxk.cmdb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class WebController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/index","/"},method = RequestMethod.GET)
    public String index(Model model, HttpSession session){
        PageUser user = (PageUser) session.getAttribute("USER_SESSION");
        String realname=userService.findRealname(user.getLoginUsername());
        model.addAttribute("realname",realname);
        return "index.html";
    }

    @RequestMapping(value = "pages/system/log.html",method = RequestMethod.GET)
    public String log(Model model){
        List<String> logs=new ArrayList<>();

        BufferedReader br=null;
        try {
            br = new BufferedReader(new FileReader("D:\\app_log\\log\\app.info.2020-05-24.log"));

            String contentLine = br.readLine();
            while (contentLine!=null){
                logs.add(contentLine);
                contentLine=br.readLine();
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e1) {
                }
            }
        }

        model.addAttribute("logs",logs);

        return "/pages/system/log.html";
    }

    @RequestMapping(value = "pages/controller.html",method = RequestMethod.GET)
    public String controller(Model model){
        List<String> logs=new ArrayList<>();

        BufferedReader br=null;
        try {
            br = new BufferedReader(new FileReader("D:\\app_log\\log\\app.info.2020-05-24.log"));

            String contentLine = br.readLine();
            while (contentLine!=null){
                logs.add(contentLine);
                contentLine=br.readLine();
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e1) {
                }
            }
        }

        model.addAttribute("logs",logs);

        return "/pages/controller.html";
    }

    //获取菜单路径
    @RequestMapping(value = "data/navs.data",method = RequestMethod.GET)
    public String menu(){

        return "/data/navs.json";
    }


}
