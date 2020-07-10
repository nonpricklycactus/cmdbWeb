package com.wxk.cmdb.domain;

import java.util.Date;

/**
 * @Description:磁盘详细信息
 * @Author: nonpricklycactus
 * @CreateDate: 2020/3/17
 */
public class Disk {
    private Integer id;
    private String sn;
    private String sever_id;
    private String manufactory;
    private String model;
    private String capacity;
    private String iface_type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getSever_id() {
        return sever_id;
    }

    public void setSever_id(String sever_id) {
        this.sever_id = sever_id;
    }

    public String getManufactory() {
        return manufactory;
    }

    public void setManufactory(String manufactory) {
        this.manufactory = manufactory;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getIface_type() {
        return iface_type;
    }

    public void setIface_type(String iface_type) {
        this.iface_type = iface_type;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    private Date create_time;
    private Date update_time;
}
