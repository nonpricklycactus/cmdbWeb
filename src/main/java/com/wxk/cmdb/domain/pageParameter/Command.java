package com.wxk.cmdb.domain.pageParameter;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/15
 */
public class Command {
    public String getServerID() {
        return serverID;
    }

    public void setServerID(String serverID) {
        this.serverID = serverID;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    String serverID;
    String result;
}
