package com.wxk.cmdb.mapper;


import com.wxk.cmdb.domain.ServerUser;
import com.wxk.cmdb.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface UserMapper {

    @Insert("INSERT INTO user(username,password,realname,depart_id,phone,email) VALUE(#{username}, #{password},#{realname}, #{departId},#{phone},#{email})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    public int add(User user);

    @Select("SELECT * FROM user")
    public List<User> findAll();

    @Select("SELECT PASSWORD FROM user WHERE username=#{name}")
    public String findPassword(String name);

    @Select("SELECT realname FROM user WHERE username=#{name}")
    public String findRealname(String name);

    @Select("SELECT id FROM user WHERE username=#{name}")
    public int findID(String name);

}