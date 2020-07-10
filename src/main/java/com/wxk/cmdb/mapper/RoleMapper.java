package com.wxk.cmdb.mapper;

import com.wxk.cmdb.domain.Role;
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
public interface RoleMapper {

    @Select("SELECT * FROM ermrole")
    public List<Role> findAll();

    @Select("")
    public String finUrl(int roleid);

    @Select("SELECT roleid FROM ermroleuser WHERE userid=#{userid}")
    public int findRole(int userid);
}
