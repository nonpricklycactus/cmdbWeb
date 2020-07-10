package com.wxk.cmdb.mapper;

import com.wxk.cmdb.domain.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface DepartmentMapper {

    @Insert("INSERT INTO department(depname,description) VALUE(#{depname}, #{description})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    public int add(Department department);

    @Select("SELECT * FROM department")
    public List<Department> findAll();
}
