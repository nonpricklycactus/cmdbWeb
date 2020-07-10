package com.wxk.cmdb.service;

import com.wxk.cmdb.domain.Role;

import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/6/6
 */
public interface RoleService {

    public List<Role> findAll();
}
