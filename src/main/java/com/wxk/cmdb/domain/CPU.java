package com.wxk.cmdb.domain;

/**
 * @Description:CPU信息
 * @Author: nonpricklycactus
 * @CreateDate: 2020/3/17
 */
public class CPU {
    private Integer id;
    private String sn;  //随机生成16位大写字母+数字（实际生活中手动填写）
    private String sever_id;
    private String manufactory;
    private String model;

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



}
