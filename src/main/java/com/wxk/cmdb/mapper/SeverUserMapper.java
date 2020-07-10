package com.wxk.cmdb.mapper;

import com.wxk.cmdb.domain.ServerUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
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
public interface SeverUserMapper {

    @Insert("INSERT INTO severuser(server_id,user_id,USER,PASSWORD,ipaddr,create_time,update_time) VALUE (#{severID}, #{userID},#{user}, #{password},#{ipaddr},#{createTime},#{updateTime})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    public int add(ServerUser serverUser);

    @Delete("DELETE FROM severuser WHERE server_id=#{serverID}")
    public void del(String serverID);

    @Select("SELECT USER,PASSWORD,ipaddr FROM severuser WHERE server_id=#{serverID}")
    public ServerUser loginserver(String serverID);

    @Select("SELECT * FROM severuser")
    public List<ServerUser> findAll();

}
