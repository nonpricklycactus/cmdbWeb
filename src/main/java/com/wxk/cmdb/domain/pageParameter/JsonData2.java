package com.wxk.cmdb.domain.pageParameter;

import java.io.Serializable;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/10
 */

import java.io.Serializable;

public class JsonData2 implements Serializable {

    private static final long serialVersionUID = 1L;

    public Integer getCode() {
        return code;
    }

    public JsonData2(){}

    public JsonData2(Integer code, Integer count,String msg,Object data) {
        this.code = code;
        this.count = count;
        this.data = data;
        this.msg = msg;
    }
    // 成功，传入数据
    public static JsonData2 buildSuccess() {
        return new JsonData2(0, 0, null,null);
    }
    // 成功，传入数据
    public static JsonData2 buildSuccess(Integer count,Object data) {
        return new JsonData2(0,count ,null,data);
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private Integer code; // 状态码 0 表示成功，1表示处理中，-1表示失败
    private Integer count;//数据总数
    private Object data; // 数据
    private String msg;// 描述

    @Override
    public String toString() {
        return "JsonData [code=" + code + ", msg=" + msg + ",count="+ count +",data" + data +"]";
    }

}

