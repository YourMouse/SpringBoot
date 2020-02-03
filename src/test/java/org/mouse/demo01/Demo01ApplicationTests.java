package org.mouse.demo01;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.mouse.demo01.dao.EmployeeMapper;
import org.mouse.demo01.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo01ApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    void contextLoads() {
        Employee employee = employeeMapper.queryEmployeeById(1004);
        System.out.println(employee);
    }

}
