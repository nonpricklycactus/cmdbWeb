package com.wxk.cmdb.mapper;

import com.wxk.cmdb.domain.Disk;
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
public interface DiskMapper {

    @Insert("INSERT INTO diskinfo(sn,sever_id,manufactory,model,capacity,iface_type,create_time,update_time) VALUE (#{sn},#{sever_id},#{manufactory},#{model},#{capacity},#{iface_type},#{create_time}, #{update_time})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    public int addDisk(Disk disk);

    @Select("SELECT * FROM diskinfo")
    public List<Disk> findAll();

    @Delete("DELETE FROM diskinfo WHERE sn=#{DiskSN}")
    public void del(String DiskSN);

    @Update("UPDATE diskinfo SET manufactory=#{manufactory},model=#{model},capacity=#{capacity},iface_type=#{iface_type},update_time=#{update_time} WHERE sn=#{sn}")
    public void updata(Disk disk);

    @Select("SELECT * FROM diskinfo WHERE sn=#{DiskSN}")
    public Disk findDisk(String DiskSN);

}
