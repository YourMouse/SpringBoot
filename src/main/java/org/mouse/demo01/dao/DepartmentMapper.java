package org.mouse.demo01.dao;

import org.apache.ibatis.annotations.Mapper;
import org.mouse.demo01.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DepartmentMapper {

    List<Department> queryAllDepartments();
}
