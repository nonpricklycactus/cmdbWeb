package com.wxk.cmdb.mapper;

import com.wxk.cmdb.domain.CPU;
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
public interface CpuMapper {

    @Insert("INSERT INTO cpuinfo(sn,sever_id,manufactory,model) VALUE (#{sn}, #{sever_id},#{manufactory}, #{model})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    public int addCpu(CPU cpu);

    @Select("SELECT * FROM cpuinfo")
    public List<CPU> findAll();

    @Delete("DELETE FROM cpuinfo WHERE sn=#{CpuSN}")
    public void del(String CpuSN);

    @Update("UPDATE cpuinfo SET manufactory=#{manufactory},model=#{model} WHERE sn=#{sn}")
    public void updata(CPU cpu);

    @Select("SELECT * FROM cpuinfo WHERE sn=#{CpuSN}")
    public CPU findCpu(String CpuSN);

    @Select("SELECT * FROM cpuinfo WHERE sever_id=#{serverID}")
    public CPU findCpu2(String serverID);

}
