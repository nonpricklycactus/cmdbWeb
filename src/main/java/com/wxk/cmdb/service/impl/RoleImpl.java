package com.wxk.cmdb.service.impl;

import com.wxk.cmdb.domain.Role;
import com.wxk.cmdb.mapper.RoleMapper;
import com.wxk.cmdb.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/6/6
 */
@Service
public class RoleImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }
}
