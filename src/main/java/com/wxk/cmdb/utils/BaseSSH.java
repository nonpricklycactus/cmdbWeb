package com.wxk.cmdb.utils;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import com.wxk.cmdb.domain.CPU;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/3/27
 */
public class BaseSSH {
    public static Connection getOpenedConnection(String host, String username,
                                                  String password) throws IOException {

        System.out.println("connecting to " + host + " with user " + username
                + " and pwd " + password);
        //添加SSH连接端口，默认22
        Connection conn = new Connection(host, 22);
        conn.connect(); // make sure the connection is opened
        boolean isAuthenticated = conn.authenticateWithPassword(username,
                password);
        if (isAuthenticated == false)
            throw new IOException("Authentication failed.");
        return conn;
    }

    public  String GetSSH(String host, String username, String password,
                                 String cmd) throws IOException {
        System.out.println("running SSH cmd [" + cmd + "]");
        Connection conn = getOpenedConnection(host, username, password);
        Session sess = conn.openSession();
        sess.execCommand(cmd);

        InputStream stdout = new StreamGobbler(sess.getStdout());
        BufferedReader br = new BufferedReader(new InputStreamReader(stdout));

        String info="";
        while (true) {
            String line = br.readLine();
            if (line == null){
                break;
            }
            info=info+line;
        }
        sess.close();
        conn.close();
        return info;
    }

    public String  Serverinfo(String host, String username, String password,String cmd,String pattern) throws IOException {
        String str;
        str = GetSSH(host,username,password,cmd);
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        m.find();
        return m.group();
    }

    public  String Command(String host, String username, String password,
                          String cmd) throws IOException {
        System.out.println("running SSH cmd [" + cmd + "]");
        Connection conn = getOpenedConnection(host, username, password);
        Session sess = conn.openSession();
        sess.execCommand(cmd);

        InputStream stdout = new StreamGobbler(sess.getStdout());
        BufferedReader br = new BufferedReader(new InputStreamReader(stdout));

        String info="";
        while (true) {
            String line = br.readLine();
            if (line == null){
                break;
            }
            info=info+"\n"+line;
        }
        sess.close();
        conn.close();
        return info;
    }
}
