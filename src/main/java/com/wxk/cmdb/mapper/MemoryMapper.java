package com.wxk.cmdb.mapper;

import com.wxk.cmdb.domain.Memory;
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
public interface MemoryMapper {

    @Insert("INSERT INTO memoryinfo(sn,sever_id,manufactory,model,create_time,update_time) VALUE (#{sn},#{sever_id},#{manufactory},#{model},#{create_time},#{update_time})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    public int addMemory(Memory memory);

    @Select("SELECT * FROM memoryinfo")
    public List<Memory> findAll();

    @Delete("DELETE FROM memoryinfo WHERE server_id=#{serverID}")
    public void del(String serverID);

    @Update("UPDATE memoryinfo SET manufactory=#{manufactory},model=#{model},update_time=#{update_time} WHERE sn=#{sn}")
    public void updata(Memory memory);

    @Select("SELECT * FROM memoryinfo WHERE sn=#{MemorySN}")
    public Memory findMemory(String MemorySN);

}
