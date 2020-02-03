package org.mouse.demo01.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mouse.demo01.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {
    //查询一个员工
    Employee queryEmployeeById(@Param("id") int id);

    //查询所有员工
    List<Employee> queryAllEmployees();

    //删除一个员工
    void deleteEmployeeById(@Param("id") int id);

    //修改一个员工
    void updateEmployee(Employee employee);

    //增加一个员工
    void insertEmployee(Employee employee);

}
