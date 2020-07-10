package com.wxk.cmdb.domain.pageParameter;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/4
 */
public class AddServer {
    private String ip;
    private String port;
    private String username;
    private String password;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
