package com.tupurp.learn.springboot.demo.web.controller;

import com.tupurp.learn.springboot.demo.mapper.DepartmentMapper;
import com.tupurp.learn.springboot.demo.mapper.EmployeeMapper;
import com.tupurp.learn.springboot.demo.model.Department;
import com.tupurp.learn.springboot.demo.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DeptController {

    @Resource
    private DepartmentMapper departmentMapper;

    @Resource
    private EmployeeMapper employeeMapper;

    /**
     * /dept/1
     * 使用@PathVariable从路径变量取值
     * */
    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Integer id){
        return departmentMapper.getById(id);
    }


    @GetMapping("/dept")
    public Department saveDept(Department department){
        departmentMapper.save(department);
        return department;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){

        return employeeMapper.getById(id);
    }


    @GetMapping("/emp")
    public Employee saveEmp(Employee employee){
        employeeMapper.save(employee);
        return employee;
    }

}
