package com.tupurp.learn.springboot.demo.web.controller;

import com.tupurp.learn.springboot.demo.mapper.DepartmentMapper;
import com.tupurp.learn.springboot.demo.model.Department;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

@RestController
public class DeptController {

    @Resource
    private DepartmentMapper departmentMapper;

    /**
     * /dept/1
     * 使用@PathVariable从路径变量取值
     * */
    @GetMapping("/dept/{id}")
    public Department get(@PathVariable("id") Integer id){
        return departmentMapper.getById(id);
    }


    @GetMapping("/dept")
    public Department save(Department department){
        departmentMapper.save(department);
        return department;
    }

}
