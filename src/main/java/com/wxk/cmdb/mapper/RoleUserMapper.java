package com.wxk.cmdb.mapper;

import com.wxk.cmdb.domain.RoleUser;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/6/6
 */

@Repository
@Component
public interface RoleUserMapper {

    @Select("SELECT id,username,PASSWORD,realname,R.`roleid`,depname,phone,email FROM ermroleuser AS E JOIN ermrole AS R ON E.`roleid`=R.`roleid` JOIN (SELECT USER.`id`,username,PASSWORD,realname,depname,phone,email FROM USER,department WHERE user.`depart_id`=department.`id`) AS U ON E.`userid`=U.`id`")
    public List<RoleUser> findAll();


}
