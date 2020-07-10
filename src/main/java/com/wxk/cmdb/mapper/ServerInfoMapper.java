package com.wxk.cmdb.mapper;

import com.wxk.cmdb.domain.ServerInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/10
 */

@Repository
@Component
public interface ServerInfoMapper {

    @Insert("INSERT INTO serverinfo (hostname,server_id,device_type,system_version,system_kernel,hard_disk,memory,physical_cpu_cores,system_ip,check_time) VALUE (#{hostname},#{server_id},#{device_type},#{system_version},#{system_kernel},#{hard_disk},#{memory},#{physical_cpu_cores},#{system_ip},#{check_time})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    public int add(ServerInfo serverInfo);

    @Select("SELECT * FROM serverinfo")
    public List<ServerInfo> findAll();

    @Delete("DELETE FROM serverinfo WHERE server_id=#{serverID}")
    public void del(String serverID);

    @Update("UPDATE serverinfo SET hostname=#{hostname} WHERE server_id=#{serverID}")
    public void update(String serverID,String hostname);
}
