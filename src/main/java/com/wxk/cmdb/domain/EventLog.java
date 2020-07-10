package com.wxk.cmdb.domain;

import java.util.Date;

/**
 * @Description:操作日志
 * @Author: nonpricklycactus
 * @CreateDate: 2020/3/17
 */
public class EventLog {
    private Integer uuid;
    private String post_data;
    private Date create_time;
    private String detail;

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getPost_data() {
        return post_data;
    }

    public void setPost_data(String post_data) {
        this.post_data = post_data;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
