package com.wxk.cmdb.domain;

/**
 * @Description:网卡信息
 * @Author: nonpricklycactus
 * @CreateDate: 2020/3/17
 */
public class Network {
    private Integer id;
    private String sn;
    private String sever_id;

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

    public String getMac_address() {
        return mac_address;
    }

    public void setMac_address(String mac_address) {
        this.mac_address = mac_address;
    }

    private String manufactory;
    private String model;
    private String mac_address;
}
