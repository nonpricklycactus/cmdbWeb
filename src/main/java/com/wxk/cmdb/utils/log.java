package com.wxk.cmdb.utils;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/24
 */
public class log {
        public static void main(String[] args) throws FileNotFoundException {

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

            for (String log:logs){
                System.out.println("logs:"+log);
            }
        }
}
