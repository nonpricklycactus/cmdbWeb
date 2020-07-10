package com.wxk.cmdb.mapper;

import com.wxk.cmdb.domain.Network;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/12
 */

@Repository
@Component
public interface NetworkMapper {

    @Insert("INSERT INTO networkinfo(sn,sever_id,manufactory,model,mac_address) VALUE (#{sn}, #{sever_id},#{manufactory}, #{model},#{mac_address})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    public int addNetwork(Network network);

    @Select("SELECT * FROM networkinfo")
    public List<Network> findAll();

    @Delete("DELETE FROM networkinfo WHERE server_id=#{serverID}")
    public void del(String serverID);

    @Update("UPDATE networkinfo SET manufactory=#{manufactory},model=#{model},mac_address=#{mac_address} WHERE sn=#{sn}")
    public void updata(Network network);

    @Select("SELECT * FROM networkinfo WHERE sn=#{NetworkSN}")
    public Network findNetwork(String NetworkSN);

}
