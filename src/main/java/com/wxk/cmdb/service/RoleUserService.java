package com.wxk.cmdb.service;

import com.wxk.cmdb.domain.RoleUser;

import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/6/6
 */
public interface RoleUserService {

    public List<RoleUser> findAll();
}
