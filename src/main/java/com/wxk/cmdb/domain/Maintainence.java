package com.wxk.cmdb.domain;

import java.util.Date;

/**
 * @Description:维护记录
 * @Author: nonpricklycactus
 * @CreateDate: 2020/3/17
 */
public class Maintainence {
    private Integer id;
    private String name;
    private String maintain_type;
    private String description;
    private String applicant;
    private String device_sn;
    private Date event_start;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaintain_type() {
        return maintain_type;
    }

    public void setMaintain_type(String maintain_type) {
        this.maintain_type = maintain_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getDevice_sn() {
        return device_sn;
    }

    public void setDevice_sn(String device_sn) {
        this.device_sn = device_sn;
    }

    public Date getEvent_start() {
        return event_start;
    }

    public void setEvent_start(Date event_start) {
        this.event_start = event_start;
    }

    public Date getEvent_end() {
        return event_end;
    }

    public void setEvent_end(Date event_end) {
        this.event_end = event_end;
    }

    private Date event_end;
}
