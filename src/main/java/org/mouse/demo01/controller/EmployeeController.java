package org.mouse.demo01.controller;

import org.mouse.demo01.dao.DepartmentMapper;
import org.mouse.demo01.dao.EmployeeMapper;
import org.mouse.demo01.entity.Department;
import org.mouse.demo01.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    @PostMapping("/login")
    public String login(@RequestParam("uname") String name, @RequestParam("upwd") String pwd, Model model, HttpSession session){
        System.out.println(name+"--"+pwd);
        try{
            if(StringUtils.isEmpty(name) || StringUtils.isEmpty(pwd)){
                throw new Exception("用户名或密码不可为空！");
            }else if(!name.equals("张三") || !pwd.equals("123456")){
                throw new Exception("用户名或密码错误");
            }else{
                session.setAttribute("userName", name);
                return "redirect:/main.html";   //如果是get请求防止表单重复提交，重定向
            }
        }catch (Exception e){
            model.addAttribute("msg", e.getMessage());
        }
        return "index";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Employee> employees =  employeeMapper.queryAllEmployees();
        model.addAttribute("emps",employees);
        return "customers";
    }

    @GetMapping("/query/{id}")
    public String query(@PathVariable("id") int id,Model model) {
        Employee employee = employeeMapper.queryEmployeeById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departmentMapper.queryAllDepartments());
        if (employee == null) {
            return "add";
        }
        return "update";
    }

    @PostMapping("/add")
    public String add(Employee employee){
        employeeMapper.insertEmployee(employee);
        return "redirect:/employee/list";
    }

   @PutMapping("/update")
    public String update(Employee employee){
       employeeMapper.updateEmployee(employee);
        return "redirect:/employee/list";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        employeeMapper.deleteEmployeeById(id);
        return "redirect:/employee/list";
    }
}

