package com.wxk.cmdb.service;

import com.wxk.cmdb.domain.Department;

import java.util.List;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/4/12
 */
public interface DepartmentService {
    public int add(Department department);

    public List<Department> findall();
}
