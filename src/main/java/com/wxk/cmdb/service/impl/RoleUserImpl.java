package com.wxk.cmdb.service.impl;

import com.wxk.cmdb.domain.RoleUser;
import com.wxk.cmdb.mapper.RoleUserMapper;
import com.wxk.cmdb.service.RoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/6/6
 */

@Service
public class RoleUserImpl implements RoleUserService {

    @Autowired
    private RoleUserMapper roleUserMapper;


    @Override
    public List<RoleUser> findAll() {
        return roleUserMapper.findAll();
    }
}
