package com.tupurp.learn.springboot.demo.service;

import com.tupurp.learn.springboot.demo.mapper.DepartmentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;


}
