package com.wxk.cmdb.domain;

import java.util.Date;

/**
 * @Description:服务器资产信息
 * @Author: nonpricklycactus
 * @CreateDate: 2020/3/17
 */
public class ServerInfo {
    private Integer id;
    private String hostname;
    private String server_id;
    private String device_type;
    private String system_version;
    private String system_kernel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getServer_id() {
        return server_id;
    }

    public void setServer_id(String server_id) {
        this.server_id = server_id;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public String getSystem_version() {
        return system_version;
    }

    public void setSystem_version(String system_version) {
        this.system_version = system_version;
    }

    public String getSystem_kernel() {
        return system_kernel;
    }

    public void setSystem_kernel(String system_kernel) {
        this.system_kernel = system_kernel;
    }

    public String getHard_disk() {
        return hard_disk;
    }

    public void setHard_disk(String hard_disk) {
        this.hard_disk = hard_disk;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getPhysical_cpu_cores() {
        return physical_cpu_cores;
    }

    public void setPhysical_cpu_cores(String physical_cpu_cores) {
        this.physical_cpu_cores = physical_cpu_cores;
    }

    public String getSystem_ip() {
        return system_ip;
    }

    public void setSystem_ip(String system_ip) {
        this.system_ip = system_ip;
    }

    public Date getCheck_time() {
        return check_time;
    }

    public void setCheck_time(Date check_time) {
        this.check_time = check_time;
    }

    private String hard_disk;
    private String memory;
    private String physical_cpu_cores;
    private String system_ip;
    private Date check_time;

}
