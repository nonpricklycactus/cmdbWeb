package com.wxk.cmdb.service.impl;

import com.wxk.cmdb.domain.Department;
import com.wxk.cmdb.mapper.DepartmentMapper;
import com.wxk.cmdb.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/4/12
 */
@Service
public class DepartServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public int add(Department department) {
        departmentMapper.add(department);
        int id=department.getId();
        return id;
    }

    @Override
    public List<Department> findall() {
        return departmentMapper.findAll();
    }
}
