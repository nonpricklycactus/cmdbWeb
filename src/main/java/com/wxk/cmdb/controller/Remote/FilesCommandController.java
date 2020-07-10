package com.wxk.cmdb.controller.Remote;

import com.jcraft.jsch.ChannelSftp;
import com.wxk.cmdb.domain.ServerUser;
import com.wxk.cmdb.domain.pageParameter.JsonData;
import com.wxk.cmdb.service.SeverUserService;
import com.wxk.cmdb.utils.BaseFTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/15
 */

@Controller
public class FilesCommandController {

    @Autowired
    private SeverUserService severUserService;

    @RequestMapping(value="pages/remote/uploadSource" , method = RequestMethod.POST)
    @ResponseBody
    public String uploadSource(@RequestParam(value="server_id") String[] serverIDs,@RequestParam("file") MultipartFile file) {
        BaseFTP baseFTP=new BaseFTP();

        String directory = "/home/wxk/upload/";
        String pathString = null;
        if(file!=null) {
            //获取上传的文件名称
            String filename = file.getOriginalFilename();
            //文件上传时，chrome与IE/Edge对于originalFilename处理方式不同
            //chrome会获取到该文件的直接文件名称，IE/Edge会获取到文件上传时完整路径/文件名
            //Check for Unix-style path
            int unixSep = filename.lastIndexOf('/');
            //Check for Windows-style path
            int winSep = filename.lastIndexOf('\\');
            //cut off at latest possible point
            int pos = (winSep > unixSep ? winSep:unixSep);
            if (pos != -1)
                filename = filename.substring(pos + 1);
            pathString = "E:/upload/" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" +filename;//上传到本地
        }
        try {
            File files=new File(pathString);//在内存中创建File文件映射对象
            //打印查看上传路径
            System.out.println(pathString);
            for(String serverID:serverIDs) {
                try {
                    ServerUser serverUser = severUserService.loginserver(serverID);

                    String host = serverUser.getIpaddr();
                    String user = serverUser.getUser();
                    String password = serverUser.getPassword();

                    try {
                        ChannelSftp sftp = baseFTP.connect(host,22,user,password);
                        baseFTP.upload(directory, pathString, sftp);
                        System.out.println("上传完成");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }catch (Exception e){
                    continue;
                }
            }
            if(!files.getParentFile().exists()){//判断映射文件的父文件是否真实存在
                files.getParentFile().mkdirs();//创建所有父文件夹
            }
            file.transferTo(files);//采用file.transferTo 来保存上传的文件
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "{\"code\":0, \"msg\":\"success\", \"fileUrl\":\"" + pathString + "\"}";
    }

}
