package com.tupurp.learn.springboot.demo.mapper;

import com.tupurp.learn.springboot.demo.model.Department;
import com.tupurp.learn.springboot.demo.model.Employee;

/**
 * mybatis操作数据库接口
 * 配置文件版
 * */

public interface EmployeeMapper {

    int save(Employee employee);

    Employee getById(Integer id);

}
